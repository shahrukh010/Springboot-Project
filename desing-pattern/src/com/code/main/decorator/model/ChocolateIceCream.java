package com.code.main.decorator.model;

import com.code.main.decorator.controller.IceCream;
import com.code.main.decorator.controller.IceCreamDecorator;

public class ChocolateIceCream extends IceCreamDecorator {

	public ChocolateIceCream(IceCream iceCream) {
		super(iceCream);
	}

	@Override
	public int cost() {
		return 1 + super.cost();
	}

}
