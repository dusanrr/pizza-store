package com.dusan.rajkovic.pizzastore.exception;

import java.util.Set;

public class PizzaUnSupportedFieldPatchException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public PizzaUnSupportedFieldPatchException(Set<String> keys)
    {
        super("Field " + keys.toString() + " update is not allow.");
    }
}
