package com.scaler.ProductService.dtos;

import lombok.Data;

@Data
public class PriceDto {
    private String currency;
    private double price;
}
