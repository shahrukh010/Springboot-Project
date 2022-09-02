package com.code.main.decorator.model;

import com.code.main.decorator.controller.IceCream;

public class BasicIceCream implements IceCream {

	public BasicIceCream() {
		System.out.println("BasicIceCream.....");
	}

	@Override
	public int cost() {
		return 0;
	}

}
