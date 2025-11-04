package com.example.expensetracker.services.impl;

import com.example.expensetracker.dto.AddCategoryReqDto;
import com.example.expensetracker.dto.CategoryResDto;
import com.example.expensetracker.entities.AlertEntity;
import com.example.expensetracker.entities.CategoryEntity;
import com.example.expensetracker.mapper.CategoryMapper;
import com.example.expensetracker.repositories.CategoryRepository;
import com.example.expensetracker.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public List<CategoryEntity> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public CategoryResDto addCategory(AddCategoryReqDto addCategoryReqDto) {
        AlertEntity alert = null;
        if (addCategoryReqDto.getAlert() != null) {
            alert = AlertEntity.builder()
                    .message(addCategoryReqDto.getAlert().getMessage())
                    .monthlyLimit(addCategoryReqDto.getAlert().getMonthlyLimit())
                    .enabled(addCategoryReqDto.getAlert().isEnabled())
                    .build();
        }
        CategoryEntity category = CategoryEntity.builder()
                .name(addCategoryReqDto.getName())
                .alert(alert)
                .build();

        if (alert != null)
            alert.setCategory(category);

        CategoryEntity savedCategory = categoryRepository.save(category);
        return categoryMapper.toDto(savedCategory);
    }
}
