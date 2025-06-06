package com.epam.FoodDeliveryApp.dto;

public record ResponseWrapper<T> (
        String transactionId,
        T data,
        String error,
        int status
) {
    public static <T> ResponseWrapper<T> success(String transactionId, T data, int status) {
        return new ResponseWrapper<>(transactionId, data, null, status);
    }

    public static <T> ResponseWrapper<T> error(String transactionId, String error, int status) {
        return new ResponseWrapper<>(transactionId, null, error, status);
    }
}

