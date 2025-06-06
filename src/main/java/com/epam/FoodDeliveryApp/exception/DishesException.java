package com.epam.FoodDeliveryApp.exception;

import org.springframework.http.HttpStatus;

public class DishesException extends FoodDeliveryException {
    public DishesException(String title) {
        super(HttpStatus.NOT_FOUND, "Dish with title: " + title + " not found");
    }
}
