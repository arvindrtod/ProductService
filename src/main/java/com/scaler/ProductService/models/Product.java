package com.scaler.ProductService.models;

import lombok.Data;

@Data
public class Product extends BaseModel{
    private String title;
    private String description;
    private String image;
    private String catagory;
    private double price;
}
