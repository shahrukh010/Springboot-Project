package com.code.main.singleton.controller;

public class MyClass extends Thread {

	private static MyClass instance;

	public MyClass() {
	};

	public static synchronized MyClass getInstance() {

		// make our code to singleton thread safe.

		if (instance == null)
			instance = new MyClass();

		return instance;
	}

}
