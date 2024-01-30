package com.scaler.ProductService.controllers;

import com.scaler.ProductService.dtos.CategoryResponseDto;
import com.scaler.ProductService.exceptions.NotFoundException;
import com.scaler.ProductService.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("categories")
public class CategoryController {

    public CategoryService categoryService;
    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @GetMapping
    public List<CategoryResponseDto> getAllCategories(){
        return categoryService.getAllCategories();
    }
    @GetMapping("{category}")
    public CategoryResponseDto getAllProductsByCategory(@PathVariable String category) throws NotFoundException {
        return categoryService.getAllProductsByCategory(category);
    }
}
