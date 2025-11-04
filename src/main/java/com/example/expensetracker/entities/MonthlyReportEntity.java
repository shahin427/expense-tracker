package com.example.expensetracker.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "monthly_reports")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonthlyReportEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate reportTime;

    @JoinColumn(name = "category_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CategoryEntity category;

    @Column(nullable = false)
    private Long totalSpent;

    private Long monthlyLimit;

}
