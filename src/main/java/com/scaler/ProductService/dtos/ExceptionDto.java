package com.scaler.ProductService.dtos;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Data
public class ExceptionDto {

    private Date timestamp;
    private int status;
    private HttpStatus error;
    private String message;
    private String path;


    public ExceptionDto(Date timestamp, int status, HttpStatus error, String message, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }
}
