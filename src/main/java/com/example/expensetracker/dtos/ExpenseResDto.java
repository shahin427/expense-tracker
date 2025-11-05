package com.example.expensetracker.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ExpenseResDto {

    private Long id;
    private String title;
    private Long amount;
    private LocalDateTime creationTime;
    private Long category;
    private String note;


}
