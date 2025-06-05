package com.epam.DeliveryFoodApp.mapper;

import com.epam.DeliveryFoodApp.dto.RequestDishDTO;
import com.epam.DeliveryFoodApp.model.Dish;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DishMapper {

    @Mapping(target = "id", ignore = true)
    Dish toDishEntity(RequestDishDTO dto);
}
