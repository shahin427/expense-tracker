package com.example.expensetracker.services;

import com.example.expensetracker.dtos.request.AddExpenseReqDto;
import com.example.expensetracker.dtos.response.ExpenseResDto;

public interface ExpenseService {
    ExpenseResDto addExpense(AddExpenseReqDto req);
}
