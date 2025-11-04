package com.example.expensetracker.mapper;

import com.example.expensetracker.dto.CategoryResDto;
import com.example.expensetracker.entities.CategoryEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {AlertMapper.class})
public interface CategoryMapper {
    CategoryResDto toDto(CategoryEntity category);
}
