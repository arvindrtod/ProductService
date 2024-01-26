package com.scaler.ProductService.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity(name="orders")
public class Order extends BaseModel{

    @ManyToMany
    @JoinTable(name = "products_orders",
    joinColumns = @JoinColumn(name = "orderId"),
    inverseJoinColumns = @JoinColumn(name = "productId"))
    private List<Product> products;
}
