package com.code.main.command.model;

import com.code.main.command.Command;

public class KirbyUpCommand implements Command {

	private KirbyCharacterReceiver kirbyCharacterReceiver;

	public KirbyUpCommand(KirbyCharacterReceiver kirbyCharacterReceiver) {
		this.kirbyCharacterReceiver = kirbyCharacterReceiver;
	}

	@Override
	public void execute() {

		kirbyCharacterReceiver.moveUp();
	}
}
