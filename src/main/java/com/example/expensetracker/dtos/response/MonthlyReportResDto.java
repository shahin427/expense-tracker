package com.example.expensetracker.dtos.response;


import com.example.expensetracker.entities.CategoryEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class MonthlyReportResDto {

    private Long id;
    private LocalDate reportTime;
    private CategoryResDto category;
    private Long totalSpent;
    private Long monthlyLimit;

}
