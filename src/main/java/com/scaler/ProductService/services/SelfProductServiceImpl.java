package com.scaler.ProductService.services;

import com.scaler.ProductService.controllers.ProductController;
import com.scaler.ProductService.dtos.*;
import com.scaler.ProductService.exceptions.NotFoundException;
import com.scaler.ProductService.models.Category;
import com.scaler.ProductService.models.Price;
import com.scaler.ProductService.models.Product;
import com.scaler.ProductService.repositories.CategoryRepository;
import com.scaler.ProductService.repositories.OrderRepository;
import com.scaler.ProductService.repositories.PriceRepository;
import com.scaler.ProductService.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service("SelfProductServiceImpl")
public class SelfProductServiceImpl implements ProductService {


    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    private PriceRepository priceRepository;
    private OrderRepository orderRepository;

    @Autowired
    public SelfProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository, PriceRepository priceRepository, OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.priceRepository = priceRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public MyGenericProductDto getProductByUUID(UUID id) throws NotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()) {
            throw new NotFoundException("Product with Id " + id + " not found");
        }
        Product product = optionalProduct.get();
        MyGenericProductDto myGenericProductDto = convertProductToMyGenericProductDto(product);

        return myGenericProductDto;
    }

    @Override
    public MyGenericProductDto createMyProduct(ProductRequestDto productRequestDto) {
        Product product = new Product();
        Product updatedProduct = convertProductRequestDtoToProduct(productRequestDto, product);
        Product savedProduct = productRepository.save(updatedProduct);
        MyGenericProductDto myGenericProductDto = convertProductToMyGenericProductDto(savedProduct);
        return myGenericProductDto;
    }

    @Transactional
    @Override
    public MyGenericProductDto updateMyProduct(ProductRequestDto productRequestDto, UUID id) throws NotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()) {
            throw new NotFoundException("Product with Id " + id + " not found");
        }
        Product savedProduct = optionalProduct.get();
        Product newSavedProduct = convertProductRequestDtoToProduct(productRequestDto, savedProduct);
        MyGenericProductDto myGenericProductDto = convertProductToMyGenericProductDto(newSavedProduct);
        return myGenericProductDto;
    }

    private Product convertProductRequestDtoToProduct(ProductRequestDto productRequestDto, Product product) {

        Price price = new Price();
        price.setPrice(productRequestDto.getPrice().getPrice());
        price.setCurrency(productRequestDto.getPrice().getCurrency());
        priceRepository.save(price);
        product.setPrice(price);
        product.setTitle(productRequestDto.getTitle());
        product.setDescription(productRequestDto.getDescription());
        product.setImage(productRequestDto.getImage());
        Optional<Category> categoryOptional = categoryRepository.findByName(productRequestDto.getCategory().getName());
        if (categoryOptional.isEmpty()) {
            Category category = new Category();
            category.setName(productRequestDto.getCategory().getName());
            categoryRepository.save(category);
            product.setCategory(category);
            return product;
        }
        Category category = categoryOptional.get();
        product.setCategory(category);
        return product;

    }

    private MyGenericProductDto convertProductToMyGenericProductDto(Product product) {
        MyGenericProductDto myGenericProductDto = new MyGenericProductDto();
        myGenericProductDto.setId(product.getUuid());
        myGenericProductDto.setDescription(product.getDescription());
        myGenericProductDto.setTitle(product.getTitle());
        myGenericProductDto.setImage(product.getImage());
        PriceDto priceDto = new PriceDto();
        priceDto.setCurrency(product.getPrice().getCurrency());
        priceDto.setPrice(product.getPrice().getPrice());
        myGenericProductDto.setPrice(priceDto);
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setName(product.getCategory().getName());
        myGenericProductDto.setCategory(categoryDto);
        return myGenericProductDto;
    }

    @Override
    public List<MyGenericProductDto> getMyAllProducts() {
        List<Product> allProducts = productRepository.findAll();
        List<MyGenericProductDto> myGenericProductDtos = new ArrayList<>();
        for (Product product : allProducts) {
            MyGenericProductDto myGenericProductDto = convertProductToMyGenericProductDto(product);
            myGenericProductDtos.add(myGenericProductDto);
        }
        return myGenericProductDtos;
    }

    @Override
    public DeleteProductResponseDto deleteMyProductById(UUID id) throws NotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()) {
            throw new NotFoundException("Product with id " + id + " not found");
        }
        Product product = optionalProduct.get();
        productRepository.deleteById(id);
        DeleteProductResponseDto deleteProductResponseDto = new DeleteProductResponseDto();
        deleteProductResponseDto.setDeletedProductId(product.getUuid());
        deleteProductResponseDto.setMessage("Product successfully deleted");

        return deleteProductResponseDto;
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
