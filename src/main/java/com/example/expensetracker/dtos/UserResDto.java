package com.example.expensetracker.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserResDto {

    private String name;
    private String familyName;
    private String username;
    private boolean registered;
}
