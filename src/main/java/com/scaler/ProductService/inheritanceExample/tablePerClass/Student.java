package com.scaler.ProductService.inheritanceExample.tablePerClass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "tpc_student")
public class Student extends User {
    private double psp;
    private String batch;
}
