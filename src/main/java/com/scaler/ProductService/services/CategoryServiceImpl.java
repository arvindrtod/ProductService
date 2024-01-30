package com.scaler.ProductService.services;

import com.scaler.ProductService.dtos.*;
import com.scaler.ProductService.exceptions.NotFoundException;
import com.scaler.ProductService.models.Category;
import com.scaler.ProductService.models.Price;
import com.scaler.ProductService.models.Product;
import com.scaler.ProductService.repositories.CategoryRepository;
import com.scaler.ProductService.repositories.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

    private CategoryRepository categoryRepository;
    private PriceRepository priceRepository;
    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository,PriceRepository priceRepository) {
        this.categoryRepository = categoryRepository;
        this.priceRepository=priceRepository;
    }

    @Override
    public List<CategoryResponseDto> getAllCategories() {
        List<Category> categoryList = categoryRepository.findAll();
        List<CategoryResponseDto> categoryResponseDtos= new ArrayList<>();
        for(Category category:categoryList){
            CategoryResponseDto categoryResponseDto= new CategoryResponseDto();
            categoryResponseDto.setName(category.getName());
            categoryResponseDto.setId(category.getUuid());
            categoryResponseDto.setProducts(getListOfProducts(category));
            categoryResponseDtos.add(categoryResponseDto);
        }
        return categoryResponseDtos;
    }

    @Override
    public CategoryResponseDto getAllProductsByCategory(String category) throws NotFoundException {
        Optional<Category> categoryOptional = categoryRepository.findByName(category);
       if(categoryOptional.isEmpty()){
           throw new NotFoundException(category+ " category is not available");
       }
        Category savedCategory = categoryOptional.get();
        List<MyGenericProductDto> listOfProducts = getListOfProducts(savedCategory);
        CategoryResponseDto categoryResponseDto= new CategoryResponseDto();
        categoryResponseDto.setName(savedCategory.getName());
        categoryResponseDto.setId(savedCategory.getUuid());
        categoryResponseDto.setProducts(listOfProducts);
        return categoryResponseDto;
    }







    public List<MyGenericProductDto> getListOfProducts(Category category){
        List<Product> products = category.getProducts();
        List<MyGenericProductDto> myGenericProductDtos= new ArrayList<>();
        for(Product product:products){
          MyGenericProductDto genericProductDto=  convertProductToMyGenericProductDto(product);
            myGenericProductDtos.add(genericProductDto);
        }
        return myGenericProductDtos;
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

}
