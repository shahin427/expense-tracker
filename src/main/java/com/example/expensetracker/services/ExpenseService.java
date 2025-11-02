package com.example.expensetracker.services;

import com.example.expensetracker.dto.ExpenseResDto;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

public interface ExpenseService {
    ExpenseResDto addExpense(String title, Long amount, Long category, LocalDateTime localDateTime, String note);
}
