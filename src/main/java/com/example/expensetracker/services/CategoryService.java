package com.example.expensetracker.services;

import com.example.expensetracker.dtos.request.AddCategoryReqDto;
import com.example.expensetracker.dtos.response.CategoryResDto;
import com.example.expensetracker.entities.CategoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {
    List<CategoryEntity> getAllCategories();

    CategoryResDto addCategory(AddCategoryReqDto req);

    Page<CategoryResDto> categoryList(String name, Pageable pageable);
}
