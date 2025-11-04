package com.example.expensetracker.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "alerts")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class AlertEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "category_id", unique = true)
    @OneToOne(fetch = FetchType.LAZY)
    private CategoryEntity category;

    private Long monthlyLimit;

    private String message;

    private boolean enabled = true;


}
