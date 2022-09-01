package com.code.main;

import com.code.main.strategy.controller.ScoreBoard;
import com.code.main.strategy.model.Ballon;
import com.code.main.strategy.model.Clowns;
import com.code.main.strategy.model.SquareBallon;

public class Main {

	public static void main(String... strings) {

		ScoreBoard scoreBoardAlgo = new ScoreBoard();
		scoreBoardAlgo.setScoreBoardAlgorithm(new Ballon());
		System.out.println("Ballen Top Score");
		scoreBoardAlgo.showScore(10, 3);

		scoreBoardAlgo.setScoreBoardAlgorithm(new Clowns());
		System.out.println("Clowns Top Score");
		scoreBoardAlgo.showScore(12, 4);

		scoreBoardAlgo.setScoreBoardAlgorithm(new SquareBallon());
		System.out.println("SquareBallon Top Score");
		scoreBoardAlgo.showScore(45, 11);
	}
}
