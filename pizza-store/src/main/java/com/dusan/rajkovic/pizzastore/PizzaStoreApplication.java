package com.dusan.rajkovic.pizzastore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class PizzaStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzaStoreApplication.class, args);
	}

}
