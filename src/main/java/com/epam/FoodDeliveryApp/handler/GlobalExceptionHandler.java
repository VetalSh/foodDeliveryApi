package com.epam.FoodDeliveryApp.handler;

import com.epam.FoodDeliveryApp.exception.DishesException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(DishesException.class)
    public ResponseEntity<ErrorResponse> handleFoodDeliveryException(DishesException ex) {
        log.error(ex.getMessage());
        ErrorResponse response = new ErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage());
        return new ResponseEntity<>(response, ex.getStatusCode());
    }
}
