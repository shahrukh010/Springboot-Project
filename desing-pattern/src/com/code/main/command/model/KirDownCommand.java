package com.code.main.command.model;

import com.code.main.command.Command;

public class KirDownCommand implements Command {

	private KirbyCharacterReceiver kirbyCharacterReceiver;

	public KirDownCommand(KirbyCharacterReceiver kirbyCharacterReceiver) {
		this.kirbyCharacterReceiver = kirbyCharacterReceiver;
	}

	@Override
	public void execute() {
		kirbyCharacterReceiver.moveDown();
	}

}
