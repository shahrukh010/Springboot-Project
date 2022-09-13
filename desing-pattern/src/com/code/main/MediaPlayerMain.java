package com.code.main;

import com.code.main.adapter.controller.MediaPlayer;
import com.code.main.adapter.model.MediaPlayerImpl;

public class MediaPlayerMain {

	public static void main(String... strings) {

		MediaPlayer mediaPlayer = new MediaPlayerImpl();
		mediaPlayer.play("mysong...", "mp3");
		mediaPlayer.play("mysong.....", "HD");
	}

}
