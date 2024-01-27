package com.scaler.ProductService.services;

import com.scaler.ProductService.dtos.DeleteProductResponseDto;
import com.scaler.ProductService.dtos.MyGenericProductDto;
import com.scaler.ProductService.dtos.ProductRequestDto;
import com.scaler.ProductService.models.Product;
import com.scaler.ProductService.thirdPartyClients.fakeStrore.FakeStoreProductClient;
import com.scaler.ProductService.thirdPartyClients.fakeStrore.dtos.FakeStoreProductDto;
import com.scaler.ProductService.dtos.GenericProductDto;
import com.scaler.ProductService.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service("FakeStoreProductService")
public class FakeStoreProductService implements ProductService {

    FakeStoreProductClient fakeStoreProductClient;

    @Autowired
    public FakeStoreProductService(FakeStoreProductClient fakeStoreProductClient) {
        this.fakeStoreProductClient = fakeStoreProductClient;
    }

    public GenericProductDto convertFakeStroreDtopToGenericProductDto(FakeStoreProductDto fakeStoreProductDto) {

        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setId(fakeStoreProductDto.getId());
        genericProductDto.setCategory(fakeStoreProductDto.getCategory());
        genericProductDto.setTitle(fakeStoreProductDto.getTitle());
        genericProductDto.setPrice(fakeStoreProductDto.getPrice());
        genericProductDto.setImage(fakeStoreProductDto.getImage());
        genericProductDto.setDescription(fakeStoreProductDto.getDescription());
        return genericProductDto;
    }

    @Override
    public GenericProductDto getProductById(Long id) throws NotFoundException {
        return convertFakeStroreDtopToGenericProductDto(fakeStoreProductClient.getProductById(id));
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto requestDto) {
        return convertFakeStroreDtopToGenericProductDto(fakeStoreProductClient.createProduct(requestDto));
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
       List<FakeStoreProductDto> fakeStoreProductDtos = fakeStoreProductClient.getAllProducts();
        List<GenericProductDto> genericProductDtos = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
            GenericProductDto genericProductDto = convertFakeStroreDtopToGenericProductDto(fakeStoreProductDto);
            genericProductDtos.add(genericProductDto);
        }
        return genericProductDtos;
    }

    @Override
    public List<MyGenericProductDto> getMyAllProducts() {
        return null;
    }

    @Override
    public GenericProductDto deleteProduct(Long id) {
       return convertFakeStroreDtopToGenericProductDto(fakeStoreProductClient.deleteProduct(id));
    }

    @Override
    public DeleteProductResponseDto deleteMyProductById(UUID id) {
        return null;
    }

    @Override
    public MyGenericProductDto getProductByUUID(UUID id) throws NotFoundException {
        return null;
    }

    @Override
    public MyGenericProductDto createMyProduct(ProductRequestDto productRequestDto) {
        return null;
    }

    @Override
    public MyGenericProductDto updateMyProduct(ProductRequestDto productRequestDto,UUID id) {
        return null;
    }
}
