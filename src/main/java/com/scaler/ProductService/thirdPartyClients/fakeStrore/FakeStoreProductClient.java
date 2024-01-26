package com.scaler.ProductService.thirdPartyClients.fakeStrore;

import com.scaler.ProductService.dtos.GenericProductDto;
import com.scaler.ProductService.exceptions.NotFoundException;
import com.scaler.ProductService.thirdPartyClients.fakeStrore.dtos.FakeStoreProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class FakeStoreProductClient {
    private String productUrl ;
    private String productRequestUrl;
    private RestTemplateBuilder restTemplateBuilder;

    @Autowired
    public FakeStoreProductClient(RestTemplateBuilder restTemplateBuilder,
                                  @Value("${fakestore.api.baseUrl}")
                                   String fakeStoreApiBaseUrl,
                                  @Value("${fakestore.api.products}")
                                      String fakeStoreApiProductPath) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.productUrl=fakeStoreApiBaseUrl+fakeStoreApiProductPath+"/{id}";
        this.productRequestUrl=fakeStoreApiBaseUrl+fakeStoreApiProductPath;
    }


    public FakeStoreProductDto getProductById(Long id) throws NotFoundException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.getForEntity(productUrl, FakeStoreProductDto.class, id);
        FakeStoreProductDto fakeStoreProductDto = response.getBody();

        if (fakeStoreProductDto == null) {
            throw new NotFoundException("Product with id " + id + " not found");
        }
        return fakeStoreProductDto;
    }


    public FakeStoreProductDto createProduct(GenericProductDto requestDto) {

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.postForEntity(productRequestUrl,
                requestDto, FakeStoreProductDto.class);
        FakeStoreProductDto fakeStoreProductDto = response.getBody();
        return fakeStoreProductDto;
    }


    public List<FakeStoreProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> response = restTemplate.getForEntity(productRequestUrl, FakeStoreProductDto[].class);
        FakeStoreProductDto[] fakeStoreProductDtos = response.getBody();
        return Arrays.asList(fakeStoreProductDtos);
    }


    public FakeStoreProductDto deleteProduct(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.exchange(productUrl, HttpMethod.DELETE, null, FakeStoreProductDto.class, id);
        FakeStoreProductDto fakeStoreProductDto = response.getBody();
        return fakeStoreProductDto;
    }

}
