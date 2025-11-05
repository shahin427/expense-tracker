package com.example.expensetracker.services;

import com.example.expensetracker.entities.RoleEntity;

import java.util.List;
import java.util.Set;

public interface RoleService {
    Set<RoleEntity> findByIdIn(Set<Long> roleIds);
}
