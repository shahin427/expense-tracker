package com.example.expensetracker.controllers;

import com.example.expensetracker.dto.AddCategoryReqDto;
import com.example.expensetracker.dto.CategoryResDto;
import com.example.expensetracker.services.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("/add")
    public ResponseEntity<CategoryResDto> addCategory(@RequestBody @Valid AddCategoryReqDto req) {
        return new ResponseEntity<>(categoryService.addCategory(req), HttpStatus.CREATED);
    }
}
