package com.example.expensetracker.services.impl;

import com.example.expensetracker.dtos.request.AddExpenseReqDto;
import com.example.expensetracker.dtos.response.ExpenseResDto;
import com.example.expensetracker.entities.AlertEntity;
import com.example.expensetracker.entities.CategoryEntity;
import com.example.expensetracker.entities.ExpenseEntity;
import com.example.expensetracker.exceptions.NotFoundException;
import com.example.expensetracker.mappers.ExpenseMapper;
import com.example.expensetracker.repositories.AlertRepository;
import com.example.expensetracker.repositories.CategoryRepository;
import com.example.expensetracker.repositories.ExpenseRepository;
import com.example.expensetracker.services.ExpenseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.Optional;

@Service
@Slf4j
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final CategoryRepository categoryRepository;
    private final AlertRepository alertRepository;

    private final ExpenseMapper expenseMapper;

    public ExpenseServiceImpl(ExpenseRepository expenseRepository, CategoryRepository categoryRepository, AlertRepository alertRepository, ExpenseMapper expenseMapper) {
        this.expenseRepository = expenseRepository;
        this.categoryRepository = categoryRepository;
        this.alertRepository = alertRepository;
        this.expenseMapper = expenseMapper;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public ExpenseResDto addExpense(AddExpenseReqDto req) {

        CategoryEntity category = categoryRepository.findById(req.getCategoryId()).orElseThrow(
                () -> new NotFoundException("category with id" + req.getCategoryId() + "not found..", HttpStatus.NOT_FOUND));
        ExpenseEntity expenseEntity = ExpenseEntity.builder()
                .title(req.getTitle())
                .amount(req.getAmount())
                .note(req.getNote())
                .creationTime(req.getCreationTime() != null ? req.getCreationTime() : LocalDateTime.now())
                .category(category)
                .build();
        ExpenseEntity savedEntity = expenseRepository.save(expenseEntity);
        try {
            checkAlertsForCategory(category, savedEntity.getCreationTime().toLocalDate());
        } catch (RuntimeException ex) {
            //Do Nothing
        }
        return expenseMapper.toDto(expenseEntity);
    }

    private void checkAlertsForCategory(CategoryEntity category, LocalDate dateOfExpense) {

        YearMonth currentMonth = YearMonth.from(dateOfExpense);
        LocalDateTime startOfMonth = currentMonth.atDay(1).atStartOfDay();
        LocalDateTime endOfMonth = currentMonth.plusMonths(1).atDay(1).atStartOfDay();
        Optional<AlertEntity> opAlert = alertRepository.findByCategoryAndEnabledTrue(category);
        if (opAlert.isEmpty()) return;
        AlertEntity alert = opAlert.get();
        Long totalSpent = expenseRepository.totalSpentForCategoryBetween(category, startOfMonth, endOfMonth);

        if (totalSpent.compareTo(alert.getMonthlyLimit()) > 0 && alert.isEnabled()) {
            log.warn("ALERT: {} | Category: {} | Limit: {} | Spent: {}",
                    alert.getMessage(),
                    category.getName(),
                    alert.getMonthlyLimit(),
                    totalSpent);
        }
    }
}
