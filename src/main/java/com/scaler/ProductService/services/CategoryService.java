package com.scaler.ProductService.services;

import com.scaler.ProductService.dtos.CategoryResponseDto;
import com.scaler.ProductService.exceptions.NotFoundException;
import com.scaler.ProductService.models.Category;
import com.scaler.ProductService.models.Product;

import java.util.List;

public interface CategoryService {

    public List<CategoryResponseDto> getAllCategories();

    public CategoryResponseDto getAllProductsByCategory(String category) throws NotFoundException;
}
