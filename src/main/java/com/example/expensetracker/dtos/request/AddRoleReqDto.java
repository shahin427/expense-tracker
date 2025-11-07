package com.example.expensetracker.dtos.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AddRoleReqDto {


    @NotEmpty(message = "title should not be null")
    private String title;
}
