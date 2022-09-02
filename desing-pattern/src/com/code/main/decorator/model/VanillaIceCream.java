package com.code.main.decorator.model;

import com.code.main.decorator.controller.IceCream;
import com.code.main.decorator.controller.IceCreamDecorator;

public class VanillaIceCream extends IceCreamDecorator {

	public VanillaIceCream(IceCream iceCream) {
		super(iceCream);
	}

	@Override
	public int cost() {
		return 2 + super.cost();
	}

}
