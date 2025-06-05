package com.epam.DeliveryFoodApp.repository;

import com.epam.DeliveryFoodApp.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepository extends JpaRepository<Dish, Long> {
}
