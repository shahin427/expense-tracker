package com.example.expensetracker.controllers;

import com.example.expensetracker.dtos.AddExpenseReqDto;
import com.example.expensetracker.dtos.ExpenseResDto;
import com.example.expensetracker.services.ExpenseService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Expenses Management", description = "Endpoints for User Managing")
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
