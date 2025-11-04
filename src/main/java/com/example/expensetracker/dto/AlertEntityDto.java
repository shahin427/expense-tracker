package com.example.expensetracker.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AlertEntityDto {

    private Long id;

    private Long monthlyLimit;

    private String message;

    private boolean enabled = true;

}
