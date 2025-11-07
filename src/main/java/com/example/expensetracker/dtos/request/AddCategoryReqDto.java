package com.example.expensetracker.dtos.request;


import com.example.expensetracker.dtos.response.AlertEntityDto;
import jakarta.validation.constraints.NotBlank;
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


