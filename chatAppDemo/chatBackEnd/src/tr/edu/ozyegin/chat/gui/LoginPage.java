package tr.edu.ozyegin.chat.gui;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Dialog.ModalityType;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import tr.edu.ozyegin.chat.messages.LoginRequest;

public class LoginPage {
	private Dialog d;
	private TextField txtName, txtPassword;
	private Button btnConnect, btnCancel;
	private Label lblMain, lblName, lblPassword;
	static String password="";
	public static LoginRequest loginRequest;
	public LoginPage() {
		
		d = new Dialog(App.f);
		d.setName("Login");
		d.setBounds(480, 270, 480, 270);
		d.setModalityType(ModalityType.APPLICATION_MODAL);
		d.setBackground(new Color(0xC8BFE7));
		d.setModal(false);
		d.setResizable(false);
		
		txtName = new TextField();
		txtPassword = new TextField();
		lblName = new Label("Name:");
		lblPassword = new Label("Password:");
		lblMain = new Label("Log in");
		btnConnect = new Button("Connect");
		btnCancel = new Button("Cancel");
		Insets inset = new Insets(2, 2, 2, 2);
		
		
		 
		txtPassword.addKeyListener(new KeyListener() {
			
			String q = "";
			@Override
			public void keyTyped(KeyEvent e) {
			
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {				
				if(e.getKeyCode()==e.VK_BACK_SPACE) {
					q=q.substring(0,q.length()-1);
					txtPassword.setText(q);	
				}else {
					txtPassword.setText(q);
					q = q + "*";
					LoginPage.password = LoginPage.password + e.getKeyChar();					
				}
				
			}
		});
		btnConnect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getID()==1001) {
					Main.client.connect("localhost", 7777);
					loginRequest = new LoginRequest();
					loginRequest.username = txtName.getText();
					loginRequest.password = password;
					Main.client.sendMessage(loginRequest);
					d.dispose();
				}
				
			}
		});
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				d.dispose();
				
			}
		});

		d.setLayout(new GridBagLayout());
		d.add(lblName, new GridBagConstraints(1, 1, 1, 1, 0.5, 0.5, GridBagConstraints.CENTER, 0, inset, 10, 10));
		d.add(lblPassword, new GridBagConstraints(1, 2, 1, 1, 0.5, 0.5, GridBagConstraints.CENTER, 0, inset, 10, 10));
		d.add(txtName, new GridBagConstraints(2, 1, 2, 1, 0.1, 0.4, GridBagConstraints.CENTER, 0, inset, 100, 0));
		d.add(txtPassword, new GridBagConstraints(2, 2, 1, 1, 0.1, 0.4, GridBagConstraints.CENTER, 0, inset, 100, 0));
		d.add(btnConnect, new GridBagConstraints(1, 6, 1, 1, 0.3, 0.3, GridBagConstraints.CENTER, 0, inset, 10, 10));
		d.add(btnCancel, new GridBagConstraints(2, 6, 1, 1, 0.3, 0.3, GridBagConstraints.CENTER, 0, inset, 10, 10));

		d.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				d.dispose();
				App.f.setFocusable(true);
			}
		});

		d.setVisible(true);
	}

}
