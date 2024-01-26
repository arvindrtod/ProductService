package com.scaler.ProductService.inheritanceExample.singleTable;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name ="st_user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "userType",discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorValue("0")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
}
