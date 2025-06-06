package com.epam.FoodDeliveryApp.exception;

import lombok.Getter;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Getter
public class FoodDeliveryException extends ResponseStatusException {

    public FoodDeliveryException(HttpStatus statusCode, String reason) {
        super(statusCode, reason);
    }
}
