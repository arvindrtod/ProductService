package com.scaler.ProductService.controllers;

import com.scaler.ProductService.dtos.CategoryResponseDto;
import com.scaler.ProductService.models.Category;
import com.scaler.ProductService.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("categories")
public class CategoryContrller {

    public CategoryService categoryService;
    @Autowired
    public CategoryContrller(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @GetMapping
    public List<CategoryResponseDto> getAllCategories(){
        return categoryService.getAllCategories();
    }
}
