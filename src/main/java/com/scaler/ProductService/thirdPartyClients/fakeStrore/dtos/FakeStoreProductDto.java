package com.scaler.ProductService.thirdPartyClients.fakeStrore.dtos;

import lombok.Data;

@Data
public class FakeStoreProductDto {

    private Long id;
    private String title;
    private String description;
    private String image;
    private String category;
    private double price;
}
