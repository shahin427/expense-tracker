package com.example.expensetracker.dto;

import jakarta.validation.constraints.Positive;
import lombok.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AddExpenseReqDto {

    private String title;
    @NotNull(message = "amount should not be null")
    @Positive(message = "amount should be positive")
    private Long amount;
    private LocalDateTime creationTime;
    private Long category;
    private String note;
}
