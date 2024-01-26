package com.scaler.ProductService.inheritanceExample.mappedSuperClass;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "msc_student")
public class Student extends User{
    private double psp;
    private String batch;
}
