package com.scaler.ProductService.controllers;

import com.scaler.ProductService.dtos.*;
import com.scaler.ProductService.exceptions.NotFoundException;
import com.scaler.ProductService.models.Product;
import com.scaler.ProductService.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
       return productService.createMyProduct(productRequestDto);

    }
    @GetMapping
    public List<MyGenericProductDto> getAllProducts() throws NotFoundException {
        return productService.getMyAllProducts();
    }
    @DeleteMapping("/{id}")
    public DeleteProductResponseDto deleteProductById(@PathVariable("id") UUID id) throws NotFoundException {
        return productService.deleteMyProductById(id);
    }
    @PutMapping("/{id}")
    public MyGenericProductDto updateProduct(@RequestBody ProductRequestDto productRequestDto,@PathVariable("id")UUID id) throws NotFoundException {
        return productService.updateMyProduct(productRequestDto,id);
    }


}
