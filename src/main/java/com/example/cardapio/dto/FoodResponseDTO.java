package com.example.cardapio.dto;


import com.example.cardapio.model.Food;

public record FoodResponseDTO(Long id, String image, String title, Integer price) {
    public FoodResponseDTO(Food food){
        this(food.getId(), food.getTitle(), food.getImage(), food.getPrice());
    }
}