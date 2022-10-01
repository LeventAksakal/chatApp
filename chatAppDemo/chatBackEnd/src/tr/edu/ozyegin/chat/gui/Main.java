package tr.edu.ozyegin.chat.gui;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import tr.edu.ozyegin.chat.client.ChatMessageListener;
import tr.edu.ozyegin.chat.client.MockChatClient;
import tr.edu.ozyegin.chat.messages.LoginRequest;
import tr.edu.ozyegin.chat.messages.LoginResponse;
import tr.edu.ozyegin.chat.messages.MessageHistoryResponse;
import tr.edu.ozyegin.chat.messages.MessageResponse;
import tr.edu.ozyegin.chat.messages.PersonListRequest;
import tr.edu.ozyegin.chat.messages.PersonListResponse;

public class Main {
	static MockChatClient client;

	public static void main(String[] args) {

		App a = new App();
		client = new MockChatClient();
		ChatMessageListener chatListener = new ChatMessageListener() {

			@Override
			public void personListResponseReceived(PersonListResponse personListResponse) {
				for (String s : personListResponse.personList) {
					if (s.contentEquals(LoginPage.loginRequest.username)) {
						App.lstOnlineUsers.add("*" + s + "*");
					} else {
						App.lstOnlineUsers.add(s);
					}
				}

			}

			@Override
			public void messageResponseReceived(MessageResponse messageResponse) {
				App.txtMessages.append(String.format("%s, %s : %s \n", messageResponse.time, messageResponse.sender,
						messageResponse.message));
				App.notification.play();
			}

			@Override
			public void messageHistoryResponseReceived(MessageHistoryResponse messageHistoryResponse) {
				for (MessageResponse m : messageHistoryResponse.messages) {
					messageResponseReceived(m);
				}
			}

			@Override
			public void loginResponseReceived(LoginResponse loginResponse) {
				if (loginResponse.success) {
					App.lblConnection.setText("Connected");
					PersonListRequest personListRequest = new PersonListRequest();
					client.sendMessage(personListRequest);
					App.btnConnect.setLabel("Disconnect");
					App.txtMessages.setBackground(new Color(0xE0E0E0));
					App.txtWrite.setBackground(new Color(0xE0E0E0));
					App.lstOnlineUsers.setBackground(new Color(0xE0E0E0));
					App.txtWrite.setFocusable(true);
					try {
						ImageLabel.setIm(ImageIO.read(new File("connected2.png")));
						App.lblImage.repaint();
						App.f.setSize(961, 540);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}
		};

		client.registerChatMessageListener(chatListener);

		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Thread.sleep(1);
	}

}
