package com.code.main.singleton.controller;

public class MyClass extends Thread {

	// Lazily singleton creation
//	private static MyClass instance;

	// Eagerly singleton creation
	private static MyClass instance = new MyClass();

	public MyClass() {
	};

	public static synchronized MyClass getInstance() {

		// make our code to singleton thread safe.

		//because of its lazily creation
//		if (instance == null)
//			instance = new MyClass();

		return instance;
	}

}
