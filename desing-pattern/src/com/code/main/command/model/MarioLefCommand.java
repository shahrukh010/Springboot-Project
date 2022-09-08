package com.code.main.command.model;

import com.code.main.command.Command;

public class MarioLefCommand implements Command {

	private MariCharacterReceiver mariCharacterReceiver;

	public MarioLefCommand(MariCharacterReceiver mariCharacterReceiver) {
		this.mariCharacterReceiver = mariCharacterReceiver;
	}

	@Override
	public void execute() {

		mariCharacterReceiver.moveLeft();
	}

}
