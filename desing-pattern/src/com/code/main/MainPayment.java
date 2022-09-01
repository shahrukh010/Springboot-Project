package com.code.main;

import com.code.main.strategy.controller.CreditCardAlgorithm;
import com.code.main.strategy.controller.PaypalAlgorithm;
import com.code.main.strategy.controller.ShopingCart;
import com.code.main.strategy.model.Product;

public class MainPayment {

	public static void main(String... strings) {

		ShopingCart cart = new ShopingCart();
		Product laptop = new Product("Laptop", 32000);
		Product camera = new Product("Camera", 54000);
		Product mobile = new Product("Mobile", 27000);

		cart.addProduct(laptop);
		cart.addProduct(camera);
		cart.addProduct(mobile);

		int totalPrice = cart.calculateTotal();

		System.out.println("total:" + totalPrice);

		cart.pay(new PaypalAlgorithm("shahrukh.khan@cognitivzen.com", "annieHector"));
		System.out.println("total:" + totalPrice);
		cart.pay(new CreditCardAlgorithm("shahrukh", "256789432146"));
	}

}
