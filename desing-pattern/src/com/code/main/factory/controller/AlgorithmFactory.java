package com.code.main.factory.controller;

import com.code.main.factory.model.ShortestPathAlgorithm;
import com.code.main.factory.model.SpanningAlgorithm;

abstract public class AlgorithmFactory {

	public static final int SPANNING_TREE = 0;
	public static final int SHORTEST_PATH = 1;

	public static Algorithm createAlgorithm(int type) {

		switch (type) {

		case SPANNING_TREE:
			return new SpanningAlgorithm();

		case SHORTEST_PATH:
			return new ShortestPathAlgorithm();
		default:
			return null;

		}
	}
}
