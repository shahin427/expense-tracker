package com.example.expensetracker.services.impl;

import com.example.expensetracker.dtos.request.AddCategoryReqDto;
import com.example.expensetracker.dtos.response.CategoryResDto;
import com.example.expensetracker.entities.AlertEntity;
import com.example.expensetracker.entities.CategoryEntity;
import com.example.expensetracker.mappers.CategoryMapper;
import com.example.expensetracker.repositories.CategoryRepository;
import com.example.expensetracker.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
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
    @Transactional(isolation = Isolation.READ_COMMITTED)
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

    @Override
    public Page<CategoryResDto> categoryList(String name, Pageable pageable) {
        Page<CategoryEntity> categoryEntities = categoryRepository.categoryList(name, pageable);
        List<CategoryResDto> categoryResDtos = categoryEntities.stream()
                .map(entity -> new CategoryResDto(entity.getId(), entity.getName()))
                .toList();
        return new PageImpl<>(categoryResDtos,pageable,categoryEntities.getTotalElements());
    }
}
