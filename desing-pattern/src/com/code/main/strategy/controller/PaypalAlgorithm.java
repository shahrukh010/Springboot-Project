package com.code.main.strategy.controller;

public class PaypalAlgorithm implements Payment {

	private String email;
	private String password;

	public PaypalAlgorithm(String email, String password) {
		this.email = email;
		this.password = password;
	}

	@Override
	public void pay(int amount) {
		System.out.println("Payment via: Paypal");
	}
}
