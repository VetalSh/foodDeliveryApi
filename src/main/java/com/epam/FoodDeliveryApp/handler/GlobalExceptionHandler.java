package com.epam.FoodDeliveryApp.handler;

import com.epam.FoodDeliveryApp.dto.ResponseWrapper;
import com.epam.FoodDeliveryApp.exception.FoodDeliveryException;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(FoodDeliveryException.class)
    @ApiResponse(responseCode = "404", description = "Source not found")
    public ResponseWrapper<Void> handleFoodDeliveryException(FoodDeliveryException ex) {
        log.error("Not found error [{}]: {}", ex.getTransactionId(), ex.getMessage());
        return ResponseWrapper.error(ex.getTransactionId(), ex.getMessage(), ex.getStatusCode().value());
    }
}
