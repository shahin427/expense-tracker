package com.example.expensetracker.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CategoryResDto {

    private Long id;

    private String name;

    private AlertEntityDto alert;
}
