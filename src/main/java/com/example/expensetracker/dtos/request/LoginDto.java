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
public class LoginDto {

    @NotEmpty(message = "username should not be empty")
    private String username;

    @NotEmpty(message = "password should not be empty")
    private String password;
}
