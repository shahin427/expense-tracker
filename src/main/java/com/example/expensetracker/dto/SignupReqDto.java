package com.example.expensetracker.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class SignupReqDto {

    private String name;
    private String familyName;
    @NotEmpty(message = "username should not be empty")
    private String username;
    @NotEmpty(message = "password should not be empty")
    private String password;
    @NotNull(message = "At least one role should be selected")
    private Set<Long> roleIds;

}
