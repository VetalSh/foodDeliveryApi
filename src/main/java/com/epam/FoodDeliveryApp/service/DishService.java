package com.epam.FoodDeliveryApp.service;

import com.epam.FoodDeliveryApp.dto.RequestDishDTO;
import com.epam.FoodDeliveryApp.model.Dish;

public interface DishService extends Service {
    Dish createDish(RequestDishDTO dto);

    Dish findDishByTitle(String title);

    Dish updateDish(String title, RequestDishDTO dto);

    String deleteDish(String title);

    String deleteDish(Long id);
}
