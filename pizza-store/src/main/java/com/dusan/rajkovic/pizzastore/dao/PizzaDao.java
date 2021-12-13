package com.dusan.rajkovic.pizzastore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dusan.rajkovic.pizzastore.entity.PizzaEntity;

@Repository
public interface PizzaDao extends JpaRepository<PizzaEntity,String> {
	
    PizzaEntity findByNameOrderByDateDesc(String name);
    
    PizzaEntity findBySlug(String slug);
    
    void deleteByName(String name);
    
    @Override
    boolean existsById(String s);

}
