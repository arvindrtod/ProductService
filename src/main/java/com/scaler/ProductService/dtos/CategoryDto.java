package com.scaler.ProductService.dtos;

import com.scaler.ProductService.models.Product;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
public class CategoryDto {
    private String name;
}
