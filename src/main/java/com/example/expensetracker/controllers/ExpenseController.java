package com.example.expensetracker.controllers;

import com.example.expensetracker.dto.AddExpenseReqDto;
import com.example.expensetracker.dto.ExpenseResDto;
import com.example.expensetracker.services.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/expense")
@RequiredArgsConstructor
public class ExpenseController {

    private final ExpenseService expenseService;

    @PostMapping("/add")
    public ResponseEntity<ExpenseResDto> addExpense(@RequestBody AddExpenseReqDto req) {
        return new ResponseEntity<>(expenseService.addExpense(req.getTitle(), req.getAmount(), req.getCategory(),
                req.getCreationTime() != null ? req.getCreationTime() : LocalDateTime.now(),
                req.getNote()), HttpStatus.CREATED);
    }

}
