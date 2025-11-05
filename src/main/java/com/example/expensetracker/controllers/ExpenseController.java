package com.example.expensetracker.controllers;

import com.example.expensetracker.dto.AddExpenseReqDto;
import com.example.expensetracker.dto.ExpenseResDto;
import com.example.expensetracker.services.ExpenseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/expense")
@RequiredArgsConstructor
public class ExpenseController {

    private final ExpenseService expenseService;

    @PostMapping("/add")
    public ResponseEntity<ExpenseResDto> addExpense(@RequestBody @Valid AddExpenseReqDto req) {
        return new ResponseEntity<>(expenseService.addExpense(req), HttpStatus.CREATED);
    }

}
