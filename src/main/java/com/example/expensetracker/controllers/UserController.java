package com.example.expensetracker.controllers;

import com.example.expensetracker.dtos.request.LoginDto;
import com.example.expensetracker.dtos.request.SignupReqDto;
import com.example.expensetracker.dtos.response.UserResDto;
import com.example.expensetracker.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Tag(name = "User Management", description = "Endpoint for User Managing")
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping("/signup")
    @Operation(summary = "user signup endpoint")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Role successfully created"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "401", description = "Unauthorized access"),
            @ApiResponse(responseCode = "500", description = "Server error")
    })
    public ResponseEntity<UserResDto> signup(@RequestBody @Valid SignupReqDto req) {
        return new ResponseEntity<>(userService.signup(req), HttpStatus.CREATED);
    }


    @PostMapping("/login")
    @Operation(summary = "user login endpoint")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User successfully logged in"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "401", description = "Unauthorized access"),
            @ApiResponse(responseCode = "500", description = "Server error")
    })
    public ResponseEntity<Map<String, String>> login(@RequestBody @Valid LoginDto loginDto) {
        return new ResponseEntity<>(userService.login(loginDto), HttpStatus.OK);
    }

}
