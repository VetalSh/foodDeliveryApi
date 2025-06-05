package com.epam.DeliveryFoodApp.service;

import com.epam.DeliveryFoodApp.model.Dish;
import com.epam.DeliveryFoodApp.model.Restaurant;
import com.epam.DeliveryFoodApp.repository.DishRepository;
import com.epam.DeliveryFoodApp.repository.RestaurantRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class JsonParserService implements DataLoader {

    private static final Logger logger = LoggerFactory.getLogger(JsonParserService.class);

    @Value("${restaurants.file}")
    private String restaurantsFilePath;

    @Value("${dishes.file}")
    private String dishesFilePath;

    private RestaurantRepository restaurantRepository;

    private DishRepository dishRepository;

    private ObjectMapper objectMapper;

    public JsonParserService(RestaurantRepository restaurantRepository, DishRepository dishRepository, ObjectMapper objectMapper) {
        this.restaurantRepository = restaurantRepository;
        this.dishRepository = dishRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void loadData() {
        logger.info("Starting data initialization...");
        loadRestaurants();
        loadDishes();
        logger.info("Data initialization completed.");
    }

    private void loadRestaurants() {
        logger.info("Loading restaurants from restaurants.json");
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(restaurantsFilePath)) {
            if (inputStream == null) {
                logger.error("restaurants.json not found in classpath");
                throw new IOException("restaurants.json not found");
            }
            List<Restaurant> restaurants = objectMapper.readValue(inputStream, new TypeReference<List<Restaurant>>() {});
            logger.info("Parsed {} restaurants", restaurants.size());
            restaurantRepository.saveAll(restaurants);
            logger.info("Saved restaurants to database");
        } catch (IOException e) {
            logger.error("Failed to load restaurants from JSON", e);
            throw new RuntimeException("Failed to load restaurants from JSON", e);
        }
    }

    private void loadDishes() {
        logger.info("Loading dishes from dishes.json");
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(dishesFilePath)) {
            if (inputStream == null) {
                logger.error("dishes.json not found in classpath");
                throw new IOException("dishes.json not found");
            }
            List<Dish> dishes = objectMapper.readValue(inputStream, new TypeReference<List<Dish>>() {});
            logger.info("Parsed {} dishes", dishes.size());
            dishRepository.saveAll(dishes);
            logger.info("Saved dishes to database");
        } catch (IOException e) {
            logger.error("Failed to load dishes from JSON", e);
            throw new RuntimeException("Failed to load dishes from JSON", e);
        }
    }
}
