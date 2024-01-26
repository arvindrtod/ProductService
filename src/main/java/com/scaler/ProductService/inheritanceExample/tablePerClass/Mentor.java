package com.scaler.ProductService.inheritanceExample.tablePerClass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "tpc_mentor")
public class Mentor extends User {
    private double avgRating;
}
