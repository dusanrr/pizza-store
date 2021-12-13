package com.dusan.rajkovic.pizzastore.exception;


public class PizzaNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PizzaNotFoundException(String name) {
        super("Could not find pizza " + name);
    }
}
