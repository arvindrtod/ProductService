package com.scaler.ProductService.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class MyGenericProductDto {
    private UUID id;
    private String title;
    private String description;
    private String image;
    private CategoryDto category;
    private PriceDto price;
}
