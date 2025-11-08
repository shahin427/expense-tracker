package com.example.expensetracker.services;

import com.example.expensetracker.dtos.request.LoginDto;
import com.example.expensetracker.dtos.request.SignupReqDto;
import com.example.expensetracker.dtos.response.UserResDto;
import com.example.expensetracker.entities.UserEntity;

import java.util.Map;
import java.util.Optional;

public interface UserService {
    Optional<UserEntity> findByUserName(String username);

    void save(UserEntity userEntity);

    UserResDto signup(SignupReqDto req);

    Map<String, String> login(LoginDto loginDto);
}
