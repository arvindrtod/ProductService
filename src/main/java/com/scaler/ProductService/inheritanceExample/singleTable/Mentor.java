package com.scaler.ProductService.inheritanceExample.singleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "st_mentor")
@DiscriminatorValue("1")
public class Mentor extends User {
    private double avgRating;
}
