package tr.edu.ozyegin.chat.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class EventHandler implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getID() == 1001 && App.btnConnect.getLabel().contentEquals("Connect")) {
			LoginPage login = new LoginPage();
			try {
				NotificationSound b = new NotificationSound();
			} catch (UnsupportedAudioFileException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (LineUnavailableException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		else if (e.getID() == 1001 && App.btnConnect.getLabel().contentEquals("Disconnect")) {
			System.exit(0);
		}
	}

}
