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
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public CategoryResDto addCategory(AddCategoryReqDto req) {
        AlertEntity alert = null;
        if (req.getAlert() != null) {
            alert = AlertEntity.builder()
                    .message(req.getAlert().getMessage())
                    .monthlyLimit(req.getAlert().getMonthlyLimit())
                    .enabled(req.getAlert().isEnabled())
                    .build();
        }
        CategoryEntity category = CategoryEntity.builder()
                .name(req.getName())
                .alert(alert)
                .build();

        if (alert != null)
            alert.setCategory(category);

        CategoryEntity savedCategory = categoryRepository.save(category);
        return categoryMapper.toDto(savedCategory);
    }
}
