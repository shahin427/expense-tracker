package com.example.expensetracker.services.impl;

import com.example.expensetracker.dto.ExpenseResDto;
import com.example.expensetracker.services.ExpenseService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ExpenseServiceImpl implements ExpenseService {
    @Override
    public ExpenseResDto addExpense(String title, Long amount, Long category, LocalDateTime localDateTime, String note) {

    }
}
