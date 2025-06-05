package com.epam.DeliveryFoodApp.service.impl;

import com.epam.DeliveryFoodApp.dto.RequestDishDTO;
import com.epam.DeliveryFoodApp.mapper.DishMapper;
import com.epam.DeliveryFoodApp.model.Dish;
import com.epam.DeliveryFoodApp.repository.DishRepository;
import com.epam.DeliveryFoodApp.service.DishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
@Transactional
public class DishServiceImpl implements DishService {

    private final DishRepository dishRepository;
    private final DishMapper dishMapper;

    @Autowired
    public DishServiceImpl(DishRepository dishRepository, DishMapper dishMapper) {
        this.dishRepository = dishRepository;
        this.dishMapper = dishMapper;
    }

    @Override
    public Dish createDish(RequestDishDTO dto) {
        Dish savedDish = dishRepository.save(dishMapper.toDishEntity(dto));
        log.info("Dish with title: {} was created", savedDish.getTitle());
        return savedDish;
    }

    @Override
    @Transactional(readOnly = true)
    public Dish findDishByTitle(String title) {
        Dish dish = dishRepository.findDishByTitle(title)
                .orElseThrow(() -> new IllegalArgumentException("Dish with title: " + title + " not found"));
        log.info("Dish with title: " + dish.getTitle() + " was found");
        return dish;
    }

    @Override
    public Dish updateDish(String title, RequestDishDTO dto) {
        return null;
    }

    @Override
    public String deleteDish(String title) {
        return null;
    }

    @Override
    public String deleteDish(Long id) {
        return null;
    }
}
