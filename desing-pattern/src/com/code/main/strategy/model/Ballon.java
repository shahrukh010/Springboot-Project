package com.code.main.strategy.model;

import com.code.main.strategy.controller.ScoreBoardAlgorithm;

public class Ballon extends ScoreBoardAlgorithm {

	@Override
	public int calculateScore(int tap, int multiplier) {

		return (tap * multiplier) - 20;
	}
}
