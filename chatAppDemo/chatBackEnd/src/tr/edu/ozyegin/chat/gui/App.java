package tr.edu.ozyegin.chat.gui;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class App {
	public static Frame f;
	public static TextArea txtMessages;
	public static TextField txtWrite;
	public static List lstOnlineUsers;
	public static Label lblConnection;
	public static ImageLabel lblImage;
	public static Button btnConnect;
	public static NotificationSound notification;
	
	public App() {
		f = new Frame("ChittyChat");
		f.setBounds(240, 135, 960, 540);
		f.setBackground(new Color(0x7092BE));
		
		Image i;
		try {
			i = ImageIO.read(new File("logo.png"));
			f.setIconImage(i);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
	
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		try {
			notification = new NotificationSound();
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
		
		txtMessages = new TextArea();
		txtMessages.setEditable(false);
		txtMessages.setBackground(new Color(0xC0C0C0));
		txtMessages.setFocusable(false);

		txtWrite = new TextField();
		txtWrite.setBackground(new Color(0xC0C0C0));
		txtWrite.addKeyListener(new KeyListener());
		txtWrite.setFocusable(false);
		
		lstOnlineUsers = new List();
		lstOnlineUsers.add("Online Users:");
		lstOnlineUsers.setBackground(new Color(0xC0C0C0));

		lblConnection = new Label("Not Connected");
		lblConnection.setBackground(new Color(0xc0c0c0));
		lblConnection.setAlignment(1);
		lblConnection.setFont(new Font(Font.SANS_SERIF, Font.BOLD | Font.ITALIC, 10));

		lblImage = new ImageLabel();
		lblImage.setBackground(new Color(0x7092BE));
		lblImage.setAlignment(1);
		lblImage.createImage(4, 4);

		btnConnect = new Button("Connect");
		btnConnect.setBackground(new Color(0xc0c0c0));
		btnConnect.addActionListener(new EventHandler());

		Insets instPnl = new Insets(8, 8, 8, 8);
		Insets instPnlTop = new Insets(13, 13, 13, 13);

		Panel pnlTop = new Panel();
		pnlTop.setBackground(new Color(0x7092BE));
		pnlTop.setLayout(new GridBagLayout());
		pnlTop.add(lblImage, new GridBagConstraints(0, 0, 1, 2, 0.1, 0.1, GridBagConstraints.NORTH,
				GridBagConstraints.BOTH, instPnlTop, 0, 0));
		pnlTop.add(lblConnection, new GridBagConstraints(2, 0, 2, 1, 0.1, 0.1, GridBagConstraints.NORTH,
				GridBagConstraints.BOTH, instPnlTop, 0, 0));
		pnlTop.add(btnConnect, new GridBagConstraints(4, 0, 1, 2, 0.1, 0.1, GridBagConstraints.NORTH,
				GridBagConstraints.BOTH, instPnlTop, 0, 0));

		Panel pnlBottom = new Panel();
		pnlBottom.setBackground(new Color(0x7092BE));
		pnlBottom.setLayout(new GridBagLayout());
		pnlBottom.add(txtMessages, new GridBagConstraints(0, 0, 5, 8, 1, 1, GridBagConstraints.WEST,
				GridBagConstraints.BOTH, instPnl, 0, 0));
		pnlBottom.add(txtWrite, new GridBagConstraints(0, 9, 5, 1, 0.4, 0.1, GridBagConstraints.SOUTHWEST,
				GridBagConstraints.BOTH, instPnl, 0, 0));
		pnlBottom.add(lstOnlineUsers, new GridBagConstraints(5, 1, 3, 7, 0.5, 0.5, GridBagConstraints.EAST,
				GridBagConstraints.BOTH, instPnl, 0, 0));

		Panel pnl = new Panel();

		f.setLayout(new GridBagLayout());
		f.add(pnlBottom, new GridBagConstraints(0, 8, 8, 8, 0.5, 0.5, GridBagConstraints.SOUTH, GridBagConstraints.BOTH,
				instPnl, 0, 0));
		f.add(pnlTop, new GridBagConstraints(0, 0, 1, 4, 0.1, 0.1, GridBagConstraints.NORTHWEST,
				GridBagConstraints.BOTH, instPnl, 0, 0));
		f.add(pnl, new GridBagConstraints(4, 0, 4, 1, 0.1, 0.1, GridBagConstraints.EAST, GridBagConstraints.BOTH,
				instPnl, 0, 0));

		f.setVisible(true);
	}
}
