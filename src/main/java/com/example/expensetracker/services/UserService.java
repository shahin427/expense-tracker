package com.example.expensetracker.services;

import com.example.expensetracker.entities.UserEntity;

import java.util.Optional;

public interface UserService {
    Optional<UserEntity> findByUserName(String username);

    void save(UserEntity userEntity);
}
