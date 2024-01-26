package com.scaler.ProductService.inheritanceExample.joinedTable;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "joined_mentor")
public class Mentor extends User {
    private double avgRating;
}
