package com.code.main.command.model;

public class MariCharacterReceiver {

	private String name;

	public void moveUp() {

		System.out.println(getName() + " moving up...");
	}

	public void moveDown() {

		System.out.println(getName() + "moving down...");
	}

	public void moveLeft() {

		System.out.println(getName() + " moving left");
	}

	public void moveRight() {

		System.out.println(getName() + " moving right...");
	}

	public void setName(String name) {

		this.name = name;
	}

	public String getName() {

		return this.name;
	}

}
