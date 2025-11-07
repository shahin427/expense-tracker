package com.example.expensetracker.services.impl;

import com.example.expensetracker.dtos.request.AddRoleReqDto;
import com.example.expensetracker.dtos.response.RoleResDto;
import com.example.expensetracker.entities.RoleEntity;
import com.example.expensetracker.mappers.RoleMapper;
import com.example.expensetracker.repositories.RoleRepository;
import com.example.expensetracker.services.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    @Override
    public Set<RoleEntity> findByIdIn(Set<Long> roleIds) {
        return roleRepository.findByIdIn(roleIds);
    }

    @Override
    @Transactional
    public RoleResDto addRole(AddRoleReqDto req) {
        RoleEntity role = RoleEntity.builder()
                .title(req.getTitle())
                .build();
        RoleEntity savedRole = roleRepository.save(role);
        return roleMapper.toDto(savedRole);
    }
}
