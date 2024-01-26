package com.scaler.ProductService.inheritanceExample.tablePerClass;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name ="tpc_user")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String email;
}
