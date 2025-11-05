package com.example.expensetracker.services.impl;

import com.example.expensetracker.entities.UserEntity;
import com.example.expensetracker.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> opUser = userRepository.findByUsername(username);
        if (opUser.isPresent()) {
            UserEntity user = opUser.get();
            Hibernate.initialize(user.getRoles());
            return new UserDetailsImpl(user);
        }
        throw new RuntimeException("Username not found!!");
    }
}
