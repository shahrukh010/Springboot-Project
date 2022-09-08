package com.code.main.command.model;

import com.code.main.command.Command;

public class MarioRightCommand implements Command {

	private MariCharacterReceiver mariCharacterReceiver;

	public MarioRightCommand(MariCharacterReceiver mariCharacterReceiver) {
		this.mariCharacterReceiver = mariCharacterReceiver;
	}

	@Override
	public void execute() {

		mariCharacterReceiver.moveRight();
	}

}
