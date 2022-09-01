package com.code.main.model;

public class Product {

	Integer id;
	private String productName;
	private double productPrice;
	private int productQty;

	public Product() {
	}

	public Product(Integer id, String productName, double productPrice, int productQty) {
		super();
		this.id = id;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productQty = productQty;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductQty() {
		return productQty;
	}

	public void setProductQty(int productQty) {
		this.productQty = productQty;
	}

}
