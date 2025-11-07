package com.example.expensetracker.controllers;


import com.example.expensetracker.dtos.response.MonthlyReportResDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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

    @GetMapping("/")
    public Page<MonthlyReportResDto> monthlyReport(
            @RequestParam("categoryId") Long categoryId,
            @RequestParam("from") LocalDate from,
            @RequestParam("to") LocalDate to) {

    }
}
