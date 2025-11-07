package com.example.expensetracker.mappers;


import com.example.expensetracker.dtos.response.RoleResDto;
import com.example.expensetracker.entities.RoleEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleResDto toDto(RoleEntity savedRole);
}
