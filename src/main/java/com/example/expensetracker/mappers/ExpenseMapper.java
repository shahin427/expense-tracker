package com.example.expensetracker.mappers;

import com.example.expensetracker.dtos.ExpenseResDto;
import com.example.expensetracker.entities.ExpenseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface ExpenseMapper {

    @Mapping(source = "category.id", target = "category")
    ExpenseResDto toDto(ExpenseEntity expenseEntity);
}
