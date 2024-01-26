package com.scaler.ProductService.controllers;

import com.scaler.ProductService.dtos.GenericProductDto;
import com.scaler.ProductService.exceptions.NotFoundException;
import com.scaler.ProductService.services.FakeStoreProductService;
import com.scaler.ProductService.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.support.HttpComponentsHeadersAdapter;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.util.MultiValueMapAdapter;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(@Qualifier("FakeStoreProductService") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("{id}")
   public GenericProductDto getProductById(@PathVariable("id") Long id) throws NotFoundException {
       return productService.getProductById(id);
   }
    @GetMapping
    public List<GenericProductDto> getAllProducts(){
        return productService.getAllProducts();
    }

   @PostMapping
   public GenericProductDto createProduct(@RequestBody GenericProductDto genericProductDto){
       return  productService.createProduct(genericProductDto);
   }

   @DeleteMapping("{id}")
   public ResponseEntity<GenericProductDto> deleteProduct(@PathVariable("id") Long id){

       return new ResponseEntity<>(productService.deleteProduct(id),  headers(), HttpStatus.OK);
   }

  /* @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDto> handleNNotFoundException(NotFoundException notFoundException, HttpServletRequest request){
        return new ResponseEntity<>(new ExceptionDto(new Date(),HttpStatus.NOT_FOUND.value(),HttpStatus.NOT_FOUND,
                                            notFoundException.getMessage(),request.getRequestURI()),
                HttpStatus.NOT_FOUND);
   }*/

    public MultiValueMap<String, String> headers(){
        MultiValueMap<String,String> headerMap = new HttpHeaders();
        headerMap.add("A","Z");
        headerMap.add("B","Y");

        return headerMap;

    }
}
