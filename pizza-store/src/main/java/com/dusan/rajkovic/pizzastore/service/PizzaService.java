package com.dusan.rajkovic.pizzastore.service;

import java.util.List;

import com.dusan.rajkovic.pizzastore.entity.PizzaEntity;

public interface PizzaService {
	
    void deletePizzaByName(String name);
    
    PizzaEntity getPizzaByName(String name);
    
    PizzaEntity savePizza(PizzaEntity pizza);
    
    List<PizzaEntity> getAllPizzas();
    
    void updatePizzaBySlug(String slug, PizzaEntity pizza);
    
    boolean existsBySlug(String slug);
}
