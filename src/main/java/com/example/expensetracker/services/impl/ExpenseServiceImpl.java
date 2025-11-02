package com.example.expensetracker.services.impl;

import com.example.expensetracker.dto.ExpenseResDto;
import com.example.expensetracker.entities.CategoryEntity;
import com.example.expensetracker.repositories.CategoryRepository;
import com.example.expensetracker.repositories.ExpenseRepository;
import com.example.expensetracker.services.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public ExpenseResDto addExpense(String title, Long amount, Long category, LocalDateTime localDateTime, String note) {
        CategoryEntity categoryEntity = categoryRepository.findById(category).orElseThrow(() -> new RuntimeException());  //TODO:: custom exception handling

        


    }
}
