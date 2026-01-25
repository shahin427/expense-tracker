package com.example.expensetracker.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "alerts")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class AlertEntity extends AbstractEntity {

    @JoinColumn(name = "category_id", unique = true)
    @OneToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private CategoryEntity category;

    private Long monthlyLimit;

    private String message;

    private boolean enabled = true;
}
