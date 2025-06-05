package com.epam.DeliveryFoodApp.controller;

import com.epam.DeliveryFoodApp.model.Dish;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Dish controller", description = "Operations related to dishes management")
public interface DishController {

    @Operation(summary = "Get dish details", description = "This endpoint allows to get a dish by their title")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dish details successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "Dish not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    Dish getDish(String title);
}
