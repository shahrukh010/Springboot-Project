package com.code.main.factory.model;

abstract public class HamBurger {

	private String name;
	private String sauce;
	private String buns;

	public void prepare() {

		System.out.println("preparing... " + name);
		System.out.println("adding..." + sauce);
		System.out.println("adding..." + buns);
	}

	public void cook() {

		System.out.println("Cooking....");
	}

	public void box() {
		System.out.println("Boxing....");

	}

	public String getName() {
		return this.name;
	}
}
