package com.code.main.command.model;

import com.code.main.command.Command;

public class KirbyRightCommand implements Command {

	private KirbyCharacterReceiver kirCharacterReceiver;

	public KirbyRightCommand(KirbyCharacterReceiver kirbyCharacterReceiver) {
		this.kirCharacterReceiver = kirbyCharacterReceiver;
	}

	@Override
	public void execute() {

		kirCharacterReceiver.moveRight();
	}

}
