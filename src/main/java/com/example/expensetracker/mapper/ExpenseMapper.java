package com.example.expensetracker.mapper;

import com.example.expensetracker.dto.ExpenseResDto;
import com.example.expensetracker.entities.ExpenseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ExpenseMapper {

    @Mapping(source = "category.id", target = "category")
    ExpenseResDto toDto(ExpenseEntity expenseEntity);
}
