package com.example.expensetracker.mappers;

import com.example.expensetracker.dtos.response.CategoryResDto;
import com.example.expensetracker.entities.CategoryEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring", uses = {AlertMapper.class})
public interface CategoryMapper {
    CategoryResDto toDto(CategoryEntity category);
}
