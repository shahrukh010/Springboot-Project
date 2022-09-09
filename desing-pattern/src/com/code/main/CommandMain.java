package com.code.main;

import com.code.main.command.model.GameBoy;
import com.code.main.command.model.KirDownCommand;
import com.code.main.command.model.KirLeftCommand;
import com.code.main.command.model.KirbyCharacterReceiver;
import com.code.main.command.model.KirbyRightCommand;
import com.code.main.command.model.KirbyUpCommand;
import com.code.main.command.model.MariCharacterReceiver;
import com.code.main.command.model.MarioDownCommand;
import com.code.main.command.model.MarioLefCommand;
import com.code.main.command.model.MarioRightCommand;
import com.code.main.command.model.MarioUpCommand;

public class CommandMain {

	public static void main(String... strings) {

		MariCharacterReceiver mariCharacterReceiver = new MariCharacterReceiver();
		KirbyCharacterReceiver kirbyCharacterReceiver = new KirbyCharacterReceiver();
		mariCharacterReceiver.setName("mario");
		kirbyCharacterReceiver.setName("kir");

		// create command
		MarioDownCommand marioDownCommand = new MarioDownCommand(mariCharacterReceiver);
		MarioUpCommand marioUpCommand = new MarioUpCommand(mariCharacterReceiver);
		MarioLefCommand marioLefCommand = new MarioLefCommand(mariCharacterReceiver);
		MarioRightCommand marioRightCommand = new MarioRightCommand(mariCharacterReceiver);

		KirbyUpCommand kirbyUpCommand = new KirbyUpCommand(kirbyCharacterReceiver);
		KirDownCommand kirbyDownCommand = new KirDownCommand(kirbyCharacterReceiver);
		KirLeftCommand kirLeftCommand = new KirLeftCommand(kirbyCharacterReceiver);
		KirbyRightCommand kirbyRightCommand = new KirbyRightCommand(kirbyCharacterReceiver);

		// invoker
		GameBoy gameBoy = new GameBoy(kirbyUpCommand, kirbyDownCommand, kirLeftCommand, kirbyRightCommand);
		gameBoy.arrowUp();
		gameBoy.arrowDown();

		GameBoy mGameBoy = new GameBoy(marioDownCommand, marioUpCommand, marioLefCommand, marioRightCommand);
		mGameBoy.arrowUp();
		mGameBoy.arrowDown();
		mGameBoy.arrowLeft();
		mGameBoy.arrowRight();
	}

}
