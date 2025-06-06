package com.epam.FoodDeliveryApp.repository;

import com.epam.FoodDeliveryApp.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
