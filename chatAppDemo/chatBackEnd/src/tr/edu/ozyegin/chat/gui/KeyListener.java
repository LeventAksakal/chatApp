package tr.edu.ozyegin.chat.gui;

import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.KeyEvent;

import tr.edu.ozyegin.chat.messages.MessageRequest;

public class KeyListener implements java.awt.event.KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (!App.txtWrite.getText().contentEquals("")) {
				Main.client.sendMessage(new MessageRequest(App.txtWrite.getText()));
				App.txtWrite.setText("");
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
