package com.code.main.adapter.controller;

public class AviPlayer implements AdvanceMediaPlayer {

	@Override
	public void playAdvanceFormat(AdvanceFormat advanceFormat) {

		System.out.println("playing....song using advance format");
		System.out.println("playing...." + advanceFormat.getFileToPlay() + "..." + advanceFormat.getFormatToPlay());
	}

}
