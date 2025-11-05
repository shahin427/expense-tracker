package com.example.expensetracker.mapper;


import com.example.expensetracker.dto.RoleResDto;
import com.example.expensetracker.entities.RoleEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {


    RoleResDto toDto(RoleEntity savedRole);
}
