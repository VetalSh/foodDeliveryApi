package com.epam.FoodDeliveryApp.controller.impl;

import com.epam.FoodDeliveryApp.controller.DishController;
import com.epam.FoodDeliveryApp.model.Dish;
import com.epam.FoodDeliveryApp.service.DishService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dishes")
@RequiredArgsConstructor
public class DishControllerImpl implements DishController {

    private final DishService dishService;

    @Override
    @GetMapping("/{title}")
    public Dish getDish(@PathVariable String title) {
        return dishService.findDishByTitle(title);
    }
}
