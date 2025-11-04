package com.example.expensetracker.services;

import com.example.expensetracker.dto.AddCategoryReqDto;
import com.example.expensetracker.dto.CategoryResDto;
import com.example.expensetracker.entities.CategoryEntity;

import java.util.List;

public interface CategoryService {
    List<CategoryEntity> getAllCategories();

    CategoryResDto addCategory(AddCategoryReqDto addCategoryReqDto);
}
