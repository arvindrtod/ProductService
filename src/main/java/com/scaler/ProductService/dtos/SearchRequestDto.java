package com.scaler.ProductService.dtos;

import lombok.Data;

@Data
public class SearchRequestDto {

    private String query;
    private int pageSize;
    private int pageNumber;
}
