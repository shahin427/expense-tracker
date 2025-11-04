package com.example.expensetracker.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AddCategoryReqDto {

    @NotBlank(message = "name should not be null")
    private String name;

    private AlertEntityDto alert;
}


