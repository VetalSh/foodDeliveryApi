package com.epam.DeliveryFoodApp.repository;

import com.epam.DeliveryFoodApp.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DishRepository extends JpaRepository<Dish, Long> {
    Optional<Dish> findDishByTitle(String title);
}
