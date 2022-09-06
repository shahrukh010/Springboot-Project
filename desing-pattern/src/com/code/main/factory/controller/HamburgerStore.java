package com.code.main.factory.controller;

import com.code.main.factory.model.HamBurger;

public abstract class HamburgerStore {

	public HamBurger orderHamBurger(String type) {

		HamBurger burger;

		burger = createHamBurger(type);
		burger.prepare();
		burger.cook();
		burger.box();

		return burger;
	}

	public abstract HamBurger createHamBurger(String type);

}
