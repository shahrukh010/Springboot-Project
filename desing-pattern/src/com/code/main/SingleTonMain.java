package com.code.main;

import com.code.main.singleton.controller.MyClass;

public class SingleTonMain {

	public static void main(String... strings) {

		MyClass myClass = MyClass.getInstance();
		System.out.println(myClass.getInstance().hashCode());
		MyClass mycls = MyClass.getInstance();
		System.out.println(myClass.getInstance().hashCode());

		MyClass c1 = new MyClass();
		MyClass c2 = new MyClass();
		System.out.println(myClass.equals(mycls));

	}

}
