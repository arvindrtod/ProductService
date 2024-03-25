package com.scaler.ProductService.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Data
@MappedSuperclass
public class BaseModel {
    @Id
//    @GeneratedValue(generator = "uuidgenerator")
//    @GenericGenerator(name = "uuidgenerator", strategy = "uuid2")
//    @Column(name = "id", columnDefinition = "binary(16)", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
}
