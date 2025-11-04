package com.example.expensetracker.services;

import com.example.expensetracker.entities.MonthlyReport;

public interface MonthlyReportService {
    MonthlyReport saveMonthlyReport(MonthlyReport monthlyReport);
}
