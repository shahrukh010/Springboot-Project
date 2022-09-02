package com.code.main.decorator.controller;

public class IceCreamDecorator implements IceCream {

	private IceCream iceCream;

	public IceCreamDecorator(IceCream iceCream) {
		this.iceCream = iceCream;
	}

	@Override
	public int cost() {
		return iceCream.cost();
	}

}
