package com.code.controller;

public class Product {

	private String productName;
	private int productPrice;

	public Product(String productName, int productPrice) {
		this.productName = productName;
		this.productPrice = productPrice;
	}

	public void setProductName(String productName) {

		this.productName = productName;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductPrice() {
		return this.productPrice;
	}

}
