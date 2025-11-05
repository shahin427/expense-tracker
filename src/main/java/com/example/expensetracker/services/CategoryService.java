package com.example.expensetracker.services;

import com.example.expensetracker.dtos.AddCategoryReqDto;
import com.example.expensetracker.dtos.CategoryResDto;
import com.example.expensetracker.entities.CategoryEntity;

import java.util.List;

public interface CategoryService {
    List<CategoryEntity> getAllCategories();

    CategoryResDto addCategory(AddCategoryReqDto req);
}
