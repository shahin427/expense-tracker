package com.example.expensetracker.services.impl;

import com.example.expensetracker.dtos.response.MonthlyReportResDto;
import com.example.expensetracker.entities.MonthlyReportEntity;
import com.example.expensetracker.mappers.MonthlyReportMapper;
import com.example.expensetracker.repositories.MonthlyReportRepository;
import com.example.expensetracker.services.MonthlyReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class MonthlyReportServiceImpl implements MonthlyReportService {

    private final MonthlyReportRepository monthlyReportRepository;
    private final MonthlyReportMapper monthlyReportMapper;

    @Override
    public MonthlyReportEntity saveMonthlyReport(MonthlyReportEntity monthlyReportEntity) {
        return monthlyReportRepository.save(monthlyReportEntity);
    }

    @Override
    public Page<MonthlyReportResDto> monthlyReport(Long categoryId, LocalDate from, LocalDate to, Pageable pageable) {
        return monthlyReportRepository.monthlyReport(categoryId, from, to, pageable)
                .map(monthlyReportMapper::toDto);
    }
}
