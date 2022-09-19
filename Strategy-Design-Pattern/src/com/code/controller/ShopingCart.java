package com.code.controller;

import java.util.ArrayList;
import java.util.List;

import com.code.model.DebitCardAlogorithm;

public class ShopingCart {

	private List<Product> listProducts;

	public ShopingCart() {
		this.listProducts = new ArrayList<>();
	}

	public void addProduct(Product product) {
		listProducts.add(product);
	}

	public void removeProduct(Product product) {
		listProducts.remove(product);
	}

	public int calculateTotal() {

		int sum = 0;
		for (Product product : listProducts)
			sum += product.getProductPrice();

		return sum;
	}

	public void pay(Payment paymentStrategy) {

		int total = calculateTotal();
		if (paymentStrategy instanceof DebitCardAlogorithm)
			paymentStrategy.payment(total);
		
	}

}
