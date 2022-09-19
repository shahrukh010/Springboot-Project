package com.code.main;

import com.code.controller.Product;
import com.code.controller.ShopingCart;
import com.code.model.DebitCardAlogorithm;

public class PaymentMain {

	public static void main(String... strings) {

		ShopingCart cart = new ShopingCart();
		Product microservices = new Product("Master Microservices with Java, Spring, Docker, Kubernetes", 499);
		Product springSecurity = new Product("Spring Security Zero to Master along with JWT,OAUTH2", 499);
		cart.addProduct(springSecurity);
		cart.addProduct(microservices);
		
		cart.pay(new DebitCardAlogorithm((long)(Math.random()*1000000000000000L), "shahrukh khan"));
		System.out.println((long)(Math.random()* 10000000000000000L));
	}
}
