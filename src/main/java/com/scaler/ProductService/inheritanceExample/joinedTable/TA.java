package com.scaler.ProductService.inheritanceExample.joinedTable;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "joined_TA")
public class TA extends User {
    private String startTime;
    private String endTime;
}
