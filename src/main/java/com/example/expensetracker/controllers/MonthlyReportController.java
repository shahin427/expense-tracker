package com.example.expensetracker.controllers;


import com.example.expensetracker.dtos.response.MonthlyReportResDto;
import com.example.expensetracker.services.MonthlyReportService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@Tag(name = "Monthly Report Management", description = "Endpoint for Monthly Report Managing")
@RestController
@RequestMapping("/monthly-report")
@RequiredArgsConstructor
public class MonthlyReportController {

    private final MonthlyReportService monthlyReportService;

    @GetMapping("/")
    @Operation(summary = "monthly report adding endpoint")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Monthly report successfully created"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "401", description = "Unauthorized access"),
            @ApiResponse(responseCode = "500", description = "Server error")
    })
    public Page<MonthlyReportResDto> monthlyReport(
            @RequestParam(value = "categoryId", required = false) Long categoryId,
            @RequestParam(value = "from", required = false) LocalDate from,
            @RequestParam(value = "to", required = false) LocalDate to,
            Pageable pageable) {
        return monthlyReportService.monthlyReport(categoryId, from, to, pageable);
    }
}
