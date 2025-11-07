package com.example.expensetracker.controllers;

import com.example.expensetracker.dtos.request.AddExpenseReqDto;
import com.example.expensetracker.dtos.response.ExpenseResDto;
import com.example.expensetracker.services.ExpenseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Expenses Management", description = "Endpoint for User Managing")
@RestController
@RequestMapping("/expense")
@RequiredArgsConstructor
public class ExpenseController {

    private final ExpenseService expenseService;


    @PostMapping("/add")
    @Operation(summary = "expense adding endpoint")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Expense successfully created"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "401", description = "Unauthorized access"),
            @ApiResponse(responseCode = "500", description = "Server error")
    })
    public ResponseEntity<ExpenseResDto> addExpense(@RequestBody @Valid AddExpenseReqDto req) {
        return new ResponseEntity<>(expenseService.addExpense(req), HttpStatus.CREATED);
    }

}
