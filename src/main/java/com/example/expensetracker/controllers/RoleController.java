package com.example.expensetracker.controllers;

import com.example.expensetracker.dto.AddRoleReqDto;
import com.example.expensetracker.dto.RoleResDto;
import com.example.expensetracker.services.RoleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @PostMapping("/add")
    public RoleResDto addRole(@RequestBody @Valid AddRoleReqDto req) {
        return roleService.addRole(req);
    }
}
