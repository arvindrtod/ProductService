package com.scaler.ProductService.exceptions;

import com.scaler.ProductService.dtos.ExceptionDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDto> handleNNotFoundException(NotFoundException notFoundException, HttpServletRequest request){
        return new ResponseEntity<>(new ExceptionDto(new Date(), HttpStatus.NOT_FOUND.value(),HttpStatus.NOT_FOUND,
                notFoundException.getMessage(),request.getRequestURI()),
                HttpStatus.NOT_FOUND);
    }

}
