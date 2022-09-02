package com.code.main;

import com.code.main.decorator.controller.IceCream;
import com.code.main.decorator.model.BasicIceCream;
import com.code.main.decorator.model.ChocolateIceCream;
import com.code.main.decorator.model.VanillaIceCream;

public class DecoratorMain {

	public static void main(String... strings) {

		BasicIceCream basicIcream = new BasicIceCream();
		System.out.println("Basic IceCream Cost:" + basicIcream.cost());
		IceCream chocolate = new ChocolateIceCream(basicIcream);
		System.out.println("ChocolateIceCream cost:" + chocolate.cost());

		IceCream vanilla = new ChocolateIceCream(new VanillaIceCream(basicIcream));
		System.out.println("VanillaIceCream cost:" + vanilla.cost());

	}

}
