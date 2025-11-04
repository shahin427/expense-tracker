package com.example.expensetracker.services;

import com.example.expensetracker.entities.MonthlyReportEntity;

public interface MonthlyReportService {
    MonthlyReportEntity saveMonthlyReport(MonthlyReportEntity monthlyReportEntity);
}
