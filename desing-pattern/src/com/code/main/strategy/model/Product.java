package com.code.main.strategy.model;

public class Product {

	private String upcCode;
	private int price;

	public Product(String upcCode, int price) {
		this.upcCode = upcCode;
		this.price = price;
	}

	public String getUpcCode() {

		return this.upcCode;
	}

	public int getPrice() {

		return this.price;
	}
}
