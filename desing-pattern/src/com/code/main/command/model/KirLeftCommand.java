package com.code.main.command.model;

import com.code.main.command.Command;

public class KirLeftCommand implements Command {

	private KirbyCharacterReceiver kirbyCharacterReceiver;

	public KirLeftCommand(KirbyCharacterReceiver kirbyCharacterReceiver) {
		this.kirbyCharacterReceiver = kirbyCharacterReceiver;
	}

	@Override
	public void execute() {

		kirbyCharacterReceiver.moveLeft();

	}

}