package com.example.expensetracker.controllers;

import com.example.expensetracker.dtos.LoginDto;
import com.example.expensetracker.dtos.SignupReqDto;
import com.example.expensetracker.dtos.UserResDto;
import com.example.expensetracker.entities.RoleEntity;
import com.example.expensetracker.entities.UserEntity;
import com.example.expensetracker.services.RoleService;
import com.example.expensetracker.services.UserService;
import com.example.expensetracker.security.TokenUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;


    @PostMapping("/signup")
    public ResponseEntity<UserResDto> signup(@RequestBody @Valid SignupReqDto req) {
        if (userService.findByUserName(req.getUsername()).isPresent()) {
            throw new RuntimeException("Entered username exists, please choose another username...");
        }
        Set<RoleEntity> roles = roleService.findByIdIn(req.getRoleIds());
        UserEntity userEntity = UserEntity.builder()
                .username(req.getUsername())
                .name(req.getName())
                .familyName(req.getFamilyName())
                .roles(roles)
                .password(passwordEncoder.encode(req.getPassword()))
                .build();
        userService.save(userEntity);
        return new ResponseEntity<>(UserResDto.builder()
                .username(req.getUsername())
                .familyName(req.getFamilyName())
                .name(req.getName())
                .registered(true)
                .build(), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody @Valid LoginDto loginDto) {

        UserEntity user = userService.findByUserName(loginDto.getUsername()).orElseThrow(() -> new RuntimeException("Username or password is invalid"));
        if (!passwordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
            throw new RuntimeException("Username or password is invalid");
        }

        String token = TokenUtils.generateToken(user);
        return new ResponseEntity<>(Map.of("token", token), HttpStatus.OK);
    }
}
