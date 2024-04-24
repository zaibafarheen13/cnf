package com.zaiba_lab5.lab5;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Product {
	
	@Min(1)
	@Max(100)
	@NotNull(message="Id requied")
	Long id;
	
	@NotBlank(message="Name required")
	String name;
	
	@Min(1)
	@NotNull(message="Product requied")
	Float price;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

}
