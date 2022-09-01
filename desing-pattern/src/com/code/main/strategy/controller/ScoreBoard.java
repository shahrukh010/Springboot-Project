package com.code.main.strategy.controller;

public class ScoreBoard {

	// composition[because it is referencing to another class.]
	private ScoreBoardAlgorithm scoreBoardAlgorithm;

	public void showScore(int tap, int multiplier) {

		System.out.println(scoreBoardAlgorithm.calculateScore(tap, multiplier));
	}

	public void setScoreBoardAlgorithm(ScoreBoardAlgorithm scoreBoardAlgo) {

		this.scoreBoardAlgorithm = scoreBoardAlgo;
	}

}
