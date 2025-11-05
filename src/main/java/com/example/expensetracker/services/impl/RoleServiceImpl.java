package com.example.expensetracker.services.impl;

import com.example.expensetracker.entities.RoleEntity;
import com.example.expensetracker.repositories.RoleRepository;
import com.example.expensetracker.services.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public Set<RoleEntity> findByIdIn(Set<Long> roleIds) {
        return roleRepository.findByIdIn(roleIds);
    }
}
