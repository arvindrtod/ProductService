package com.scaler.ProductService.services;

import com.scaler.ProductService.dtos.FakeStoreProductDto;
import com.scaler.ProductService.dtos.GenericProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{

    String url="https://fakestoreapi.com/products/{id}";
    String createProductUrl= "https://fakestoreapi.com/products";
    String getAllProductUrl="https://fakestoreapi.com/products";
    private RestTemplateBuilder restTemplateBuilder;

    @Autowired
    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public GenericProductDto getProductById(Long id) {
        RestTemplate restTemplate= restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.getForEntity(url, FakeStoreProductDto.class, id);
        FakeStoreProductDto fakeStoreProductDto= response.getBody();
        GenericProductDto genericProductDto= new GenericProductDto();
        genericProductDto.setId(fakeStoreProductDto.getId());
        genericProductDto.setCategory(fakeStoreProductDto.getCategory());
        genericProductDto.setTitle(fakeStoreProductDto.getTitle());
        genericProductDto.setPrice(fakeStoreProductDto.getPrice());
        genericProductDto.setImage(fakeStoreProductDto.getImage());
        genericProductDto.setDescription(fakeStoreProductDto.getDescription());

        return genericProductDto;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto requestDto) {

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.postForEntity(createProductUrl,
                                                            requestDto, FakeStoreProductDto.class);
        FakeStoreProductDto fakeStoreProductDto=response.getBody();
        GenericProductDto genericProductDto= new GenericProductDto();
        genericProductDto.setId(fakeStoreProductDto.getId());
        genericProductDto.setCategory(fakeStoreProductDto.getCategory());
        genericProductDto.setTitle(fakeStoreProductDto.getTitle());
        genericProductDto.setPrice(fakeStoreProductDto.getPrice());
        genericProductDto.setImage(fakeStoreProductDto.getImage());
        genericProductDto.setDescription(fakeStoreProductDto.getDescription());
        return genericProductDto;
    }

    @Override
    public List<GenericProductDto> getAllProducts() {

        RestTemplate restTemplate= restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> response= restTemplate.getForEntity(getAllProductUrl, FakeStoreProductDto[].class);
        FakeStoreProductDto[] fakeStoreProductDtos = response.getBody();
        List<GenericProductDto> genericProductDtos= new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto:fakeStoreProductDtos){
            GenericProductDto genericProductDto= new GenericProductDto();
            genericProductDto.setId(fakeStoreProductDto.getId());
            genericProductDto.setCategory(fakeStoreProductDto.getCategory());
            genericProductDto.setTitle(fakeStoreProductDto.getTitle());
            genericProductDto.setPrice(fakeStoreProductDto.getPrice());
            genericProductDto.setImage(fakeStoreProductDto.getImage());
            genericProductDto.setDescription(fakeStoreProductDto.getDescription());
            genericProductDtos.add(genericProductDto);
        }

        return genericProductDtos;
    }

}
