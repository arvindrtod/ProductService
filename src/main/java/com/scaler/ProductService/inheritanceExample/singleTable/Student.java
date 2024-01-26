package com.scaler.ProductService.inheritanceExample.singleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "st_student")
@DiscriminatorValue("2")
public class Student extends User {
    private double psp;
    private String batch;
}
