package com.scaler.ProductService.inheritanceExample.tablePerClass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "tpc_TA")
public class TA extends User {
    private String startTime;
    private String endTime;
}
