package com.example.expensetracker.services;

import com.example.expensetracker.dto.AddExpenseReqDto;
import com.example.expensetracker.dto.ExpenseResDto;

public interface ExpenseService {
    ExpenseResDto addExpense(AddExpenseReqDto req);
}
