package com.scaler.ProductService.services;

import com.scaler.ProductService.dtos.FakeStoreProductDto;
import com.scaler.ProductService.dtos.GenericProductDto;

import java.util.List;

public interface ProductService {

    public GenericProductDto getProductById(Long id);
    public GenericProductDto createProduct(GenericProductDto genericProductDto);
    public List<GenericProductDto> getAllProducts();
}
