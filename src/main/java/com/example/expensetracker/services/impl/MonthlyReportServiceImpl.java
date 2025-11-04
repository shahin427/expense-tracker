package com.example.expensetracker.services.impl;

import com.example.expensetracker.entities.MonthlyReport;
import com.example.expensetracker.repositories.MonthlyReportRepository;
import com.example.expensetracker.services.MonthlyReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MonthlyReportServiceImpl implements MonthlyReportService {

    private final MonthlyReportRepository monthlyReportRepository;

    @Override
    public MonthlyReport saveMonthlyReport(MonthlyReport monthlyReport) {
        return monthlyReportRepository.save(monthlyReport);
    }
}
