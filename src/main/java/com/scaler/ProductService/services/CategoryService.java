package com.scaler.ProductService.services;

import com.scaler.ProductService.dtos.CategoryResponseDto;
import com.scaler.ProductService.models.Category;

import java.util.List;

public interface CategoryService {

    public List<CategoryResponseDto> getAllCategories();
}
