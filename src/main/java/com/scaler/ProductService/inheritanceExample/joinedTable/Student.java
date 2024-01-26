package com.scaler.ProductService.inheritanceExample.joinedTable;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "joined_student")
public class Student extends User {
    private double psp;
    private String batch;
}
