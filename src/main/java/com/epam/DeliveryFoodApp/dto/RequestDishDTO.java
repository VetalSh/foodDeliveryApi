package com.epam.DeliveryFoodApp.dto;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record RequestDishDTO(
        @NotBlank(message = "First name is required") String title,
        @NotBlank(message = "Last name is required") String description,
        BigDecimal price,
        String image
) {
}
