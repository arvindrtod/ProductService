package com.scaler.ProductService;

import com.scaler.ProductService.inheritanceExample.singleTable.Mentor;
import com.scaler.ProductService.inheritanceExample.singleTable.MentorRepository;
import com.scaler.ProductService.models.Category;
import com.scaler.ProductService.models.Price;
import com.scaler.ProductService.models.Product;
import com.scaler.ProductService.repositories.CategoryRepository;
import com.scaler.ProductService.repositories.OrderRepository;
import com.scaler.ProductService.repositories.PriceRepository;
import com.scaler.ProductService.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {

	private ProductRepository productRepository;
	private CategoryRepository categoryRepository;
	private PriceRepository priceRepository;


	public ProductServiceApplication(ProductRepository productRepository,
									 CategoryRepository categoryRepository,
									 PriceRepository priceRepository) {
		this.productRepository = productRepository;
		this.categoryRepository=categoryRepository;
		this.priceRepository=priceRepository;
		}

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Mentor mentor= new Mentor();
//		mentor.setId(1);
//		mentor.setName("arvind");
//		mentor.setEmail("arvind@gamil.com");
//		mentor.setAvgRating(10.0);
//
//		mentorRepository.save(mentor);


//		Price price= new Price("Rupees",200);
//		Price savedPrice = priceRepository.save(price);
//
//		Category category= new Category();
//		category.setName("Mobiles");
//		Category savedCategory = categoryRepository.save(category);
//		Product product= new Product();
//		product.setTitle("Iphone1");
//		product.setCategory(savedCategory);
//		product.setImage("iphone url");
//		product.setDescription("Best phone ever");
//		product.setPrice(price);
//		productRepository.save(product);

//		Product product1 = productRepository.findByTitleAndPrice_currency("Iphone1", "Rupees");
//		System.out.println();
//		productRepository.findByTitle2("Iphone1");
//
//		System.out.println(ar);


//		Optional<Product> productOptional=productRepository.findById(UUID.fromString("c8e66718-5226-429d-b87a-8690803fcc21"));
//		if(!productOptional.isEmpty()) {
//			Product product1= productOptional.get();
//			System.out.println(product1.getTitle());
//		}
//		Optional<Category> categoryOptional = categoryRepository.findById(UUID.fromString("590d16ab-f7d2-4ea6-87c6-3d196ef4aea9"));
//		if(!categoryOptional.isEmpty()){
//			Category category1=categoryOptional.get();
//			List<Product>products= category1.getProducts();
//			for(Product productss:products){
//				System.out.println(productss.getTitle());
//			}
//		}

	}
}
