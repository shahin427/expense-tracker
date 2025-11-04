package com.example.expensetracker.repositories;

import com.example.expensetracker.entities.MonthlyReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonthlyReportRepository extends JpaRepository<MonthlyReportEntity, Long> {
}
