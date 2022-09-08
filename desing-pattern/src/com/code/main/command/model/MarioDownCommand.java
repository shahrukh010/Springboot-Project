package com.code.main.command.model;

import com.code.main.command.Command;

public class MarioDownCommand implements Command {

	private MariCharacterReceiver mariCharacterReceiver;

	public MarioDownCommand(MariCharacterReceiver mariCharacterReceiver) {
		this.mariCharacterReceiver = mariCharacterReceiver;
	}

	@Override
	public void execute() {

		mariCharacterReceiver.moveDown();

	}

}
