package com.example.expensetracker.services;

import com.example.expensetracker.entities.CategoryEntity;

import java.util.List;

public interface CategoryService {
    List<CategoryEntity> getAllCategories();
}
