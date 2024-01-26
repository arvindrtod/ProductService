package com.scaler.ProductService.services;

import com.scaler.ProductService.dtos.*;
import com.scaler.ProductService.exceptions.NotFoundException;
import com.scaler.ProductService.models.Category;
import com.scaler.ProductService.models.Price;
import com.scaler.ProductService.models.Product;
import com.scaler.ProductService.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service("SelfProductServiceImpl")
public class SelfProductServiceImpl implements ProductService {


    private ProductRepository productRepository;

    @Autowired
    public SelfProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public MyGenericProductDto getProductByUUID(UUID id) throws NotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()) {
            throw new NotFoundException("Product with Id " + id + "not found");
        }
        Product product = optionalProduct.get();
        MyGenericProductDto mygenericProductDto = new MyGenericProductDto();
        mygenericProductDto.setId(product.getUuid());
        mygenericProductDto.setDescription(product.getDescription());
        mygenericProductDto.setTitle(product.getTitle());
        PriceDto priceDto = new PriceDto();
        priceDto.setPrice(product.getPrice().getPrice());
        priceDto.setCurrency(product.getPrice().getCurrency());
        mygenericProductDto.setPrice(priceDto);
        mygenericProductDto.setImage(product.getImage());
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setName(product.getCategory().getName());
        mygenericProductDto.setCategory(categoryDto);

        return mygenericProductDto;
    }

    @Override
    public Product createMyProduct(ProductRequestDto productRequestDto) {
        Product product = new Product();
        product.setDescription(productRequestDto.getDescription());
        product.setTitle(productRequestDto.getTitle());
        product.setImage(productRequestDto.getImage());
        Price price = new Price();
        price.setCurrency(productRequestDto.getPrice().getCurrency());
        price.setPrice(productRequestDto.getPrice().getPrice());
        product.setPrice(price);
        Category category= new Category();
        category.setName(productRequestDto.getCategory().getName());
        category.setProducts(new ArrayList<>());
        product.setCategory(category);


        Product savedProduct = productRepository.save(product);

        return savedProduct;
    }

    @Override
    public GenericProductDto getProductById(Long id) throws NotFoundException {
        return null;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        return null;
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        return null;
    }

    @Override
    public GenericProductDto deleteProduct(Long id) {
        return null;
    }
}
