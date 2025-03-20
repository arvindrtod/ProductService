package com.scaler.ProductService.services;

import com.scaler.ProductService.dtos.GenericProductDto;
import com.scaler.ProductService.dtos.MyGenericProductDto;
import com.scaler.ProductService.models.Product;
import com.scaler.ProductService.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {

    private ProductRepository productRepository;
    @Autowired
    public SearchService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Page<MyGenericProductDto> search(String query, int pageSize, int pageNumber){
        Sort sort =Sort.by("title").descending();
        Pageable pageable= PageRequest.of(pageNumber,pageSize,sort);
        Page<Product> productPage = productRepository.findByTitleContaining(query, pageable);
        List<Product> products= productPage.get().toList();
        List<MyGenericProductDto> myGenericProductDtos= new ArrayList<>();
        for(Product product:products) {
              myGenericProductDtos.add(SelfProductServiceImpl.convertProductToMyGenericProductDto(product));
        }
        Page<MyGenericProductDto> myGenericProductDtoPage =new PageImpl<MyGenericProductDto>
                                (myGenericProductDtos,productPage.getPageable(),productPage.getTotalElements());

        return myGenericProductDtoPage;
    }
}
