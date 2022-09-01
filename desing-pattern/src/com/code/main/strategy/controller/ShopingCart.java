package com.code.main.strategy.controller;

import java.util.ArrayList;
import java.util.List;

import com.code.main.strategy.model.Product;

public class ShopingCart {

	private List<Product> products = new ArrayList<>();

	public ShopingCart() {

	}

	public void addProduct(Product product) {
		products.add(product);
	}

	public void removeProduct(Product product) {

		products.remove(product);
	}

	public int calculateTotal() {

		int total = 0;
		for (Product item : products) {

			total += item.getPrice();
		}
		return total;
	}

	public void pay(Payment paymentStrategy) {

		int amount = this.calculateTotal();
		paymentStrategy.pay(amount);
	}
}
