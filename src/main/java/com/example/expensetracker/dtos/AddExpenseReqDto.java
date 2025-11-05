package com.example.expensetracker.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
