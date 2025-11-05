package com.example.expensetracker.controllers;

import com.example.expensetracker.dto.SignupReqDto;
import com.example.expensetracker.dto.UserResDto;
import com.example.expensetracker.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public UserResDto signup(@RequestBody SignupReqDto req) {
        if (userService.findByUserName(req.getUserName()).isPresent()) {
            throw new RuntimeException("Entered username exists, please choose another username...");
        }


    }
}
