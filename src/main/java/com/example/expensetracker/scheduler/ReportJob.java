package com.example.expensetracker.scheduler;

import com.example.expensetracker.entities.CategoryEntity;
import com.example.expensetracker.entities.MonthlyReport;
import com.example.expensetracker.repositories.ExpenseRepository;
import com.example.expensetracker.services.CategoryService;
import com.example.expensetracker.services.MonthlyReportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class ReportJob {
    private final CategoryService categoryService;
    private final ExpenseRepository expenseRepository;
    private final MonthlyReportService monthlyReportService;

    @Scheduled(cron = "0 0 1 1 * ?") // 1st of every month 1 AM
    public void generateMonthlyReport() {
        YearMonth previousMonth = YearMonth.now().minusMonths(1);
        LocalDateTime startOfTheMonth = previousMonth.atDay(1).atStartOfDay();
        LocalDateTime endOfTheMonth = startOfTheMonth.plusMonths(1).toLocalDate().atStartOfDay();

        List<CategoryEntity> categories = categoryService.getAllCategories();

        for (CategoryEntity category : categories) {
            Long totalSpentAmount = expenseRepository.totalSpentForCategoryBetween(category, startOfTheMonth, endOfTheMonth);
            MonthlyReport monthlyReport = MonthlyReport.builder()
                    .reportTime(previousMonth)
                    .category(category)
                    .totalSpent(totalSpentAmount)
                    .monthlyLimit(category.getAlert() != null ? category.getAlert().getMonthlyLimit() : 0)
                    .build();
            monthlyReportService.saveMonthlyReport(monthlyReport);
        }
    }
}
