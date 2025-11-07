package com.example.expensetracker.dtos.response;


import com.example.expensetracker.dtos.response.AlertEntityDto;
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
