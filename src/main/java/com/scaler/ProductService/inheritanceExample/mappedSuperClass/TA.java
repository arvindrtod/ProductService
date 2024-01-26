package com.scaler.ProductService.inheritanceExample.mappedSuperClass;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "msc_TA")
public class TA extends User{
    private String startTime;
    private String endTime;
}
