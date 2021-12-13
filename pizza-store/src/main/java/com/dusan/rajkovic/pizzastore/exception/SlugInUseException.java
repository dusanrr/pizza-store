package com.dusan.rajkovic.pizzastore.exception;

public class SlugInUseException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SlugInUseException(String name) {
        super(name + " : Slug already in use " );
    }
}
