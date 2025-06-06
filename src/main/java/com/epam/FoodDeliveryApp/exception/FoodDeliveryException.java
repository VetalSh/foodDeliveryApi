package com.epam.FoodDeliveryApp.exception;

import lombok.Getter;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Getter
public class FoodDeliveryException extends ResponseStatusException {

    private final String transactionId;

    public FoodDeliveryException(HttpStatus status, String reason) {
        super(status, reason);
        this.transactionId = MDC.get("transactionId");
    }
}
