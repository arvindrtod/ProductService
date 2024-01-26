package com.scaler.ProductService.dtos;

import lombok.Data;

@Data
public class ProductRequestDto {
    private String title;
    private String description;
    private String image;
    private CategoryDto category;
    private PriceDto price;
}
