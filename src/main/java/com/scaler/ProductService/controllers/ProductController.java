package com.scaler.ProductService.controllers;

import com.scaler.ProductService.dtos.FakeStoreProductDto;
import com.scaler.ProductService.dtos.GenericProductDto;
import com.scaler.ProductService.services.ProductService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("{id}")
   public String getProductById(@PathVariable("id") long id,Model model){
        GenericProductDto product= productService.getProductById(id);
        model.addAttribute("products",product);
       return "products";
   }
    @GetMapping
    public String getAllProducts(Model model){
        List<GenericProductDto> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "products";
    }

   @PostMapping
   public String createProduct(@RequestBody GenericProductDto genericProductDto,Model model){

       GenericProductDto product=productService.createProduct(genericProductDto);
       model.addAttribute("products",product);
       return "products";
   }
}
