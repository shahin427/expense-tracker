package com.example.expensetracker.repositories;

import com.example.expensetracker.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {


    Set<RoleEntity> findByIdIn(Set<Long> ids);
}
