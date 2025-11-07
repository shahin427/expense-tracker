package com.example.expensetracker.controllers;

import com.example.expensetracker.dtos.AddRoleReqDto;
import com.example.expensetracker.dtos.RoleResDto;
import com.example.expensetracker.services.RoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Tag(name = "Role management", description = "Endpoints for Role Managing")
@RestController
@RequestMapping("/role")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @PostMapping("/add")
    @Operation(summary = "Add a new Role")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Role successfully created"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "401", description = "Unauthorized access"),
            @ApiResponse(responseCode = "500", description = "Server error")
    })
    public RoleResDto addRole(@RequestBody @Valid AddRoleReqDto req) {
        return roleService.addRole(req);
    }
}
