package com.example.expensetracker.services;

import com.example.expensetracker.dtos.request.AddRoleReqDto;
import com.example.expensetracker.dtos.response.RoleResDto;
import com.example.expensetracker.entities.RoleEntity;

import java.util.Set;

public interface RoleService {
    Set<RoleEntity> findByIdIn(Set<Long> roleIds);

    RoleResDto addRole(AddRoleReqDto req);
}
