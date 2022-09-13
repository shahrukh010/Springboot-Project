package com.code.main.adapter.model;

import com.code.main.adapter.controller.AdvanceFormat;
import com.code.main.adapter.controller.DefaultMediaPlayer;
import com.code.main.adapter.controller.MediaPlayer;

public class MediaPlayerImpl implements MediaPlayer {

	private MediaPlayerAdapter mediaPlayerAdapter;
	private MediaPlayer mediaPlayer;

	@Override
	public void play(String fileToPlay, String formatToPlay) {

		if (formatToPlay.equals("mp3")) {

			mediaPlayer = new DefaultMediaPlayer();
			mediaPlayer.play(fileToPlay, formatToPlay);
		} else {

			AdvanceFormat advanceFormat = new AdvanceFormat();
			advanceFormat.setResolution("720");
			mediaPlayerAdapter = new MediaPlayerAdapter(advanceFormat);
			mediaPlayerAdapter.play(fileToPlay, formatToPlay);
		}

	}

}
