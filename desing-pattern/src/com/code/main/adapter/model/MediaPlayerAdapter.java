package com.code.main.adapter.model;

import com.code.main.adapter.controller.AdvanceFormat;
import com.code.main.adapter.controller.AdvanceMediaPlayer;
import com.code.main.adapter.controller.AviPlayer;
import com.code.main.adapter.controller.MediaPlayer;

public class MediaPlayerAdapter implements MediaPlayer {

	private AdvanceMediaPlayer advanceMediaPlayer;
	private AdvanceFormat advanceFormat;

	public MediaPlayerAdapter(AdvanceFormat advanceFormat) {

		this.advanceMediaPlayer = new AviPlayer();
		this.advanceFormat = advanceFormat;
	}

	@Override
	public void play(String fileToPlay, String formatToPlay) {

		advanceFormat.setFileToPlay(fileToPlay);
		advanceFormat.setFormatToPlay(formatToPlay);
		advanceMediaPlayer.playAdvanceFormat(advanceFormat);

	}

}
