package com.example.expensetracker.services.impl;

import com.example.expensetracker.entities.UserEntity;
import com.example.expensetracker.repositories.UserRepository;
import com.example.expensetracker.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;
    @Override
    public Optional<UserEntity> findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
}
