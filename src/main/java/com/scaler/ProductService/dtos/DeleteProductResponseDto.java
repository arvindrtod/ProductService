package com.scaler.ProductService.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class DeleteProductResponseDto {
    private String message;
    private UUID deletedProductId;
}
