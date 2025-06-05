package com.epam.DeliveryFoodApp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Restaurants")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    @JsonProperty("deliveryTime")
    private int deliveryTime;

    @Column
    private BigDecimal rating;

    @Column
    @JsonProperty("minDeliveryAmount")
    private BigDecimal minDeliveryAmount;

    @Column
    private String type;

    @Column
    @JsonProperty("restImage")
    private String restImage;
}