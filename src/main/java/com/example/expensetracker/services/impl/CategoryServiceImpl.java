package com.example.expensetracker.services.impl;

import com.example.expensetracker.entities.CategoryEntity;
import com.example.expensetracker.repositories.CategoryRepository;
import com.example.expensetracker.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryEntity> getAllCategories() {
        return categoryRepository.findAll();
    }
}
