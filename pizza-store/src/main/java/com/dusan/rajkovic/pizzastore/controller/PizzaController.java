package com.dusan.rajkovic.pizzastore.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.dusan.rajkovic.pizzastore.PizzaStoreApplication;
import com.dusan.rajkovic.pizzastore.entity.PizzaEntity;
import com.dusan.rajkovic.pizzastore.exception.SlugInUseException;
import com.dusan.rajkovic.pizzastore.service.impl.PizzaServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
public class PizzaController {
    private static final Logger logger = LoggerFactory.getLogger(PizzaStoreApplication.class);

    @Autowired
    private PizzaServiceImpl pizzaService;

    @GetMapping("/pizzastore")
    List<PizzaEntity> getAllPizzas() {
        return pizzaService.getAllPizzas();
    }

    @PostMapping("/pizzastore")
    @ResponseStatus(HttpStatus.CREATED)
    PizzaEntity newPizza(@RequestBody @Valid PizzaEntity pizzaEntity) {
        if(pizzaService.existsBySlug(pizzaEntity.getSlug())){
            throw new SlugInUseException(pizzaEntity.getSlug());
        }
        logger.info("Pizza added successfully");
        return pizzaService.savePizza(pizzaEntity);
    }

    @GetMapping("/pizzastore/{name}")
    PizzaEntity onePizza(@PathVariable String name) {
       return pizzaService.getPizzaByName(name);
    }

    @DeleteMapping("/pizzastore/{name}")
    void deletePizza(@PathVariable String name){

        pizzaService.deletePizzaByName(name);
        logger.info("Pizza deleted successfully");
    }

    @PatchMapping("/pizzastore/{slug}")
    public void updatePizza(@PathVariable String slug, @RequestBody @Valid PizzaEntity pizzaEntity) {
        if(!(slug.equals(pizzaEntity.getSlug()))){
            logger.error("Slug doesn't match url");
        }
        else {
            pizzaService.updatePizzaBySlug(slug, pizzaEntity);
            logger.info("Pizza changed successfully");
        }

    }

}
