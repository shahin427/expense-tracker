package com.example.expensetracker.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "expenses")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(nullable = false)
    private Long amount;

    @JoinColumn(name = "category")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST})
    private CategoryEntity categoryEntity;

    private LocalDateTime creationTime;

    private String note;
}
