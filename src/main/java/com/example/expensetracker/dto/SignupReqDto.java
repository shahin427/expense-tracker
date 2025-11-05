package com.example.expensetracker.dto;


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
    private String userName;
    private String password;
    private Set<Long> roleIds;

}
