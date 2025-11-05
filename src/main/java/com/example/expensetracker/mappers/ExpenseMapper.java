package com.example.expensetracker.mappers;

import com.example.expensetracker.dtos.ExpenseResDto;
import com.example.expensetracker.entities.ExpenseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ExpenseMapper {

    @Mapping(source = "category.id", target = "category")
    ExpenseResDto toDto(ExpenseEntity expenseEntity);
}
