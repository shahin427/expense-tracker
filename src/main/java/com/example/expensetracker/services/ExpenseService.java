package com.example.expensetracker.services;

import com.example.expensetracker.dtos.AddExpenseReqDto;
import com.example.expensetracker.dtos.ExpenseResDto;

public interface ExpenseService {
    ExpenseResDto addExpense(AddExpenseReqDto req);
}
