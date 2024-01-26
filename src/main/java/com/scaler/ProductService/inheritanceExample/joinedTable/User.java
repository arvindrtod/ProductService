package com.scaler.ProductService.inheritanceExample.joinedTable;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name ="joined_user")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
}
