package com.scaler.ProductService.controllers;

import com.scaler.ProductService.dtos.*;
import com.scaler.ProductService.exceptions.NotFoundException;
import com.scaler.ProductService.models.Product;
import com.scaler.ProductService.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/products1")
public class MyProductController {

    private ProductService productService;

    @Autowired
    public MyProductController(@Qualifier("SelfProductServiceImpl") ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/{id}")
    public MyGenericProductDto getProductById(@PathVariable("id") UUID id) throws NotFoundException {
        return productService.getProductByUUID(id);
    }
    @PostMapping
    public MyGenericProductDto createProduct(@RequestBody ProductRequestDto productRequestDto) {
        Product myProduct = productService.createMyProduct(productRequestDto);
        MyGenericProductDto myGenericProductDto = new MyGenericProductDto();
        myGenericProductDto.setId(myProduct.getUuid());
        myGenericProductDto.setDescription(myProduct.getDescription());
        myGenericProductDto.setTitle(myProduct.getTitle());
        myGenericProductDto.setImage(myProduct.getImage());
        PriceDto priceDto= new PriceDto();
        priceDto.setCurrency(myProduct.getPrice().getCurrency());
        priceDto.setPrice(myProduct.getPrice().getPrice());
        myGenericProductDto.setPrice(priceDto);
        CategoryDto categoryDto= new CategoryDto();
        categoryDto.setName(myProduct.getCategory().getName());
        myGenericProductDto.setCategory(categoryDto);
        return myGenericProductDto;
    }
}
