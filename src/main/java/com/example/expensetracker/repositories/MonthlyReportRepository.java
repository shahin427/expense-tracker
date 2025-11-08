package com.example.expensetracker.repositories;

import com.example.expensetracker.entities.MonthlyReportEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface MonthlyReportRepository extends JpaRepository<MonthlyReportEntity, Long> {

    @Query("select mr from MonthlyReportEntity mr where" +
            " (:categoryId is null or mr.category.id = :categoryId) " +
            "and (:from is null or mr.reportTime>= :from) " +
            "and (:to is null  or mr.reportTime<= :to)")
    Page<MonthlyReportEntity> monthlyReport(@Param("categoryId") Long categoryId, @Param("from") LocalDate from, @Param("to") LocalDate to, Pageable pageable);
}
