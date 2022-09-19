package com.code.model;

import com.code.controller.Payment;

public class DebitCardAlogorithm implements Payment {

	private long cardNumber;
	private String cardHolderName;

	public DebitCardAlogorithm(long cardNumber, String cardHolderName) {
		this.cardHolderName = cardHolderName;
		this.cardNumber = cardNumber;
	}

	@Override
	public void payment(int amount) {

		System.out.println(amount + " paid with debitcard");
	}

}
