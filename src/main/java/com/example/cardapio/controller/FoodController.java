package com.example.cardapio.controller;

import com.example.cardapio.dto.FoodRequestDTO;
import com.example.cardapio.dto.FoodResponseDTO;
import com.example.cardapio.model.Food;
import com.example.cardapio.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("food")
public class FoodController {
    @Autowired
    private FoodRepository foodRepository;


    @GetMapping
    public List<FoodResponseDTO> getAll(){
        List<FoodResponseDTO> foodList = foodRepository.findAll().stream().map(FoodResponseDTO::new).toList();
        return foodList;
    }

    @PostMapping
    public void saveFood(@RequestBody FoodRequestDTO data){
        Food food = new Food(data);
        foodRepository.save(food);
        return;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFood(@PathVariable(value = "id") Long id){

        Optional<Food> food = foodRepository.findById(id);
        foodRepository.deleteById(food.get().getId());

        return ResponseEntity.status(HttpStatus.OK).body("Deleted");
    }
}
