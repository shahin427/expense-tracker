package com.example.expensetracker.controllers;

import com.example.expensetracker.dtos.request.AddCategoryReqDto;
import com.example.expensetracker.dtos.response.CategoryResDto;
import com.example.expensetracker.services.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Expense Category Management", description = "Endpoint for Category Managing")
@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("/add")
    @Operation(summary = "category adding endpoint")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Category successfully created"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "401", description = "Unauthorized access"),
            @ApiResponse(responseCode = "500", description = "Server error")
    })
    public ResponseEntity<CategoryResDto> addCategory(@RequestBody @Valid AddCategoryReqDto req) {
        return new ResponseEntity<>(categoryService.addCategory(req), HttpStatus.CREATED);
    }
}
