package com.dusan.rajkovic.pizzastore.entity;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pizza")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class PizzaEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @NotEmpty(message = "This field is required")
    @Column(unique = true)
    private String slug;

    @NotEmpty(message = "This field is required")
    private String name;

    @NotNull(message = "This field is required")
    private Integer size;

    @DecimalMin(value="0.01", message = "testMinValue")
    @NotNull(message = "This field is required")
    private double price;

    private Instant date;

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}
}
