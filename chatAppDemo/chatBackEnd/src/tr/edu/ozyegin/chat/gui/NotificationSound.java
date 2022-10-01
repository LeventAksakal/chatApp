package tr.edu.ozyegin.chat.gui;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class NotificationSound {
	AudioInputStream audioInput;
	Clip clip;

	public NotificationSound() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		audioInput = AudioSystem.getAudioInputStream(new File("notificationSound2.wav"));
		clip = AudioSystem.getClip();
		clip.open(audioInput);
	}

	public void play() {
		clip.start();
		clip.setMicrosecondPosition(0);
	}
}
