package com.example.expensetracker.services.impl;

import com.example.expensetracker.dtos.request.LoginDto;
import com.example.expensetracker.dtos.request.SignupReqDto;
import com.example.expensetracker.dtos.response.UserResDto;
import com.example.expensetracker.entities.RoleEntity;
import com.example.expensetracker.entities.UserEntity;
import com.example.expensetracker.exceptions.BadRequestException;
import com.example.expensetracker.exceptions.NotFoundException;
import com.example.expensetracker.repositories.UserRepository;
import com.example.expensetracker.security.TokenUtils;
import com.example.expensetracker.services.RoleService;
import com.example.expensetracker.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;


    @Override
    public Optional<UserEntity> findByUserName(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void save(UserEntity userEntity) {
        userRepository.save(userEntity);
    }

    @Override
    public UserResDto signup(SignupReqDto req) {
        if (userRepository.findByUsername(req.getUsername()).isPresent()) {
            throw new BadRequestException("Entered username exists, please choose another username...", HttpStatus.BAD_REQUEST);
        }
        Set<RoleEntity> roles = roleService.findByIdIn(req.getRoleIds());
        if (roles.size() == 0) {
            throw new NotFoundException("Role with id " + req.getRoleIds() + " not found", HttpStatus.NOT_FOUND);
        }
        UserEntity userEntity = UserEntity.builder()
                .username(req.getUsername())
                .name(req.getName())
                .familyName(req.getFamilyName())
                .roles(roles)
                .password(passwordEncoder.encode(req.getPassword()))
                .build();
        userRepository.save(userEntity);

        return UserResDto.builder()
                .username(req.getUsername())
                .familyName(req.getFamilyName())
                .name(req.getName())
                .registered(true)
                .build();
    }

    @Override
    public Map<String, String> login(LoginDto loginDto) {
        UserEntity user = userRepository.findByUsername(loginDto.getUsername()).orElseThrow(
                () -> new BadRequestException("Username or password is invalid", HttpStatus.BAD_REQUEST));
        if (!passwordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
            throw new NotFoundException("Username or password is invalid", HttpStatus.NOT_FOUND);
        }

        String token = TokenUtils.generateToken(user);
        return Map.of("token", token);
    }
}
