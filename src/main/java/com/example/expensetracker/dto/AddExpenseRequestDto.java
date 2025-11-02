package com.example.expensetracker.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddExpenseRequestDto {

    private String title;
    private Long amount;
    private LocalDateTime creationTime;
    private Long category;
    private String note;
}
