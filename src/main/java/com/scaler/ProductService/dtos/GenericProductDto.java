package com.scaler.ProductService.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class GenericProductDto {
    private Long id;
    private String title;
    private String description;
    private String image;
    private String category;
    private double price;
}
