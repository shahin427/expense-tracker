package com.example.expensetracker.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "categories")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CategoryEntity extends AbstractEntity {

    @Column(unique = true, nullable = false)
    private String name;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "category", cascade = CascadeType.ALL)
    private AlertEntity alert;
}



