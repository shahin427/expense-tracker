package com.example.expensetracker.controllers;


import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Monthly Report Management", description = "Endpoint for Monthly Report Managing")
@RestController
@RequestMapping("/expense")
@RequiredArgsConstructor
public class MonthlyReportController {
}
