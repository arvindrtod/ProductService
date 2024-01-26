package com.scaler.ProductService.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Product extends BaseModel{
    private String title;
    private String description;
    private String image;
    @ManyToOne
    @JoinColumn(name = "categoryId") //is used to rename the column if not used default is used
    private Category category;
   // private double price;
    @OneToOne(cascade = {CascadeType.REMOVE,CascadeType.PERSIST})
    private Price price;
}
