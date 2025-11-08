package com.example.expensetracker.services;

import com.example.expensetracker.dtos.response.MonthlyReportResDto;
import com.example.expensetracker.entities.MonthlyReportEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;

public interface MonthlyReportService {
    MonthlyReportEntity saveMonthlyReport(MonthlyReportEntity monthlyReportEntity);
    Page<MonthlyReportResDto> monthlyReport(Long categoryId, LocalDate from, LocalDate to, Pageable pageable);
}
