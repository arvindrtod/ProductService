package com.scaler.ProductService.services;

import com.scaler.ProductService.dtos.DeleteProductResponseDto;
import com.scaler.ProductService.dtos.GenericProductDto;
import com.scaler.ProductService.dtos.MyGenericProductDto;
import com.scaler.ProductService.dtos.ProductRequestDto;
import com.scaler.ProductService.exceptions.NotFoundException;
import com.scaler.ProductService.models.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    public GenericProductDto getProductById(Long id) throws NotFoundException;
    public GenericProductDto createProduct(GenericProductDto genericProductDto);
    public List<GenericProductDto> getAllProducts();
    public List<MyGenericProductDto> getMyAllProducts();
    public GenericProductDto deleteProduct(Long id);
    public DeleteProductResponseDto deleteMyProductById(UUID id) throws NotFoundException;
    public MyGenericProductDto getProductByUUID(UUID id) throws NotFoundException;

    public MyGenericProductDto createMyProduct(ProductRequestDto productRequestDto);
    public MyGenericProductDto updateMyProduct(ProductRequestDto productRequestDto,UUID id) throws NotFoundException;
}
