package com.scaler.ProductService.dtos;

import com.scaler.ProductService.models.Category;
import com.scaler.ProductService.models.Product;
import lombok.Data;

import java.util.List;

@Data
public class CategoryResponseDto {
    private String name;
    private List<MyGenericProductDto> products;
}
