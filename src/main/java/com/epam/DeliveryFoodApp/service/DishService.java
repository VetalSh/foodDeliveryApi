package com.epam.DeliveryFoodApp.service;

import com.epam.DeliveryFoodApp.dto.RequestDishDTO;
import com.epam.DeliveryFoodApp.model.Dish;

import java.util.Optional;

public interface DishService extends Service {
    Dish createDish(RequestDishDTO dto);

    Dish findDishByTitle(String title);

    Dish updateDish(String title, RequestDishDTO dto);

    String deleteDish(String title);

    String deleteDish(Long id);
}
