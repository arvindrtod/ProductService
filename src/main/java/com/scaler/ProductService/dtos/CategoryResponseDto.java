package com.scaler.ProductService.dtos;

import com.scaler.ProductService.models.Category;
import com.scaler.ProductService.models.Product;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class CategoryResponseDto {
    private String name;
    private UUID id;
    private List<MyGenericProductDto> products;
}
