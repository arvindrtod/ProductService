package com.scaler.ProductService.repositories;

import com.scaler.ProductService.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    Product findByTitleAndPrice_currency(String title, String currency);
    @Query(value = "select * from Product where title= :title", nativeQuery = true)
    Product findByTitle(String title);
    @Query(value = "select p from Product p where p.title = :title")
    Product findByTitle2(String title);

}
