package com.code.main;

import com.code.main.factory.controller.Algorithm;
import com.code.main.factory.controller.AlgorithmFactory;

public class FactoryMain {

	public static void main(String... strings) {

		Algorithm algorithm = AlgorithmFactory.createAlgorithm(AlgorithmFactory.SPANNING_TREE);
		algorithm.solve();
	}

}
