package com.epam.DeliveryFoodApp.repository;

import com.epam.DeliveryFoodApp.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
