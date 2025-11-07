package com.example.expensetracker.services;

import com.example.expensetracker.dtos.request.AddCategoryReqDto;
import com.example.expensetracker.dtos.response.CategoryResDto;
import com.example.expensetracker.entities.CategoryEntity;

import java.util.List;

public interface CategoryService {
    List<CategoryEntity> getAllCategories();

    CategoryResDto addCategory(AddCategoryReqDto req);
}
