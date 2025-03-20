package com.scaler.ProductService.controllers;

import com.scaler.ProductService.dtos.MyGenericProductDto;
import com.scaler.ProductService.dtos.SearchRequestDto;
import com.scaler.ProductService.services.SearchService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search")
public class SearchController {

    private SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @PostMapping
    public Page<MyGenericProductDto> search(@RequestBody SearchRequestDto searchRequestDto){
      return searchService.search(searchRequestDto.getQuery(), searchRequestDto.getPageSize(), searchRequestDto.getPageNumber());
    }
}
