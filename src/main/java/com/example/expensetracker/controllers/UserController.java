package com.example.expensetracker.controllers;

import com.example.expensetracker.dto.SignupReqDto;
import com.example.expensetracker.dto.UserResDto;
import com.example.expensetracker.entities.RoleEntity;
import com.example.expensetracker.entities.UserEntity;
import com.example.expensetracker.services.RoleService;
import com.example.expensetracker.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final RoleService roleService;

    private final PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public UserResDto signup(@RequestBody SignupReqDto req) {
        if (userService.findByUserName(req.getUsername()).isPresent()) {
            throw new RuntimeException("Entered username exists, please choose another username...");
        }
        Set<RoleEntity> roles = roleService.findByIdIn(req.getRoleIds());
        UserEntity userEntity = UserEntity.builder()
                .userName(req.getUsername())
                .name(req.getName())
                .familyName(req.getFamilyName())
                .roles(roles)
                .password(passwordEncoder.encode(req.getPassword()))
                .build();
        userService.save(userEntity);
        return UserResDto.builder()
                .username(req.getUsername())
                .familyName(req.getFamilyName())
                .name(req.getName())
                .registered(true)
                .build();
    }
}
