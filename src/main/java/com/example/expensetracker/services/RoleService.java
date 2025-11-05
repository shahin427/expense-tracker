package com.example.expensetracker.services;

import com.example.expensetracker.dto.AddRoleReqDto;
import com.example.expensetracker.dto.RoleResDto;
import com.example.expensetracker.entities.RoleEntity;

import java.util.List;
import java.util.Set;

public interface RoleService {
    Set<RoleEntity> findByIdIn(Set<Long> roleIds);

    RoleResDto addRole(AddRoleReqDto req);
}
