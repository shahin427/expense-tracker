package com.example.expensetracker.mappers;


import com.example.expensetracker.dtos.response.RoleResDto;
import com.example.expensetracker.entities.RoleEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface RoleMapper {
    RoleResDto toDto(RoleEntity savedRole);
}
