package com.capstone.project;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class LoginPage {
	
	static int windowWidth = 500 , windowHeight = 600;
	JFrame window;
	JPanel menuPanel, buttonPanel;
	JTextField userTextField;
	JPasswordField passwordTextField;
	JLabel usernameLabel, passwordLabel;
	JButton loginButton, registerButton;
	
	registerButtonHandler registerButtonHandler = new registerButtonHandler();
	loginButtonHandler loginButtonHandler = new loginButtonHandler();
	
	public ArrayList<UserClass> user = new ArrayList<UserClass>();
	
	EncryptionClass encrypt = new EncryptionClass();
	
	
	public LoginPage(){
		
		//initialize and create the application window
		window = new JFrame();
		window.setSize(windowWidth, windowHeight);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.gray);
		window.setLayout(null);
				
		menuPanel = new JPanel();
		menuPanel.setBounds(10,10,465,100); 
		menuPanel.setBackground(Color.blue);
		menuPanel.setLayout(new GridLayout(2,2));
				
		buttonPanel = new JPanel();
		buttonPanel.setBounds(10, 115, 465, 50);
		buttonPanel.setBackground(Color.blue);
		buttonPanel.setLayout(new GridLayout(1,2));
				
		usernameLabel = new JLabel("Username: ");
		usernameLabel.setForeground(Color.white);
		menuPanel.add(usernameLabel);
				
		userTextField = new JTextField();
		menuPanel.add(userTextField);
				
		passwordLabel = new JLabel("Password: ");
		passwordLabel.setForeground(Color.white);
		menuPanel.add(passwordLabel);
				
		passwordTextField = new JPasswordField();
		menuPanel.add(passwordTextField);
				
		registerButton = new JButton("Register User");
		registerButton.setBackground(Color.blue);
		registerButton.setForeground(Color.white);
		buttonPanel.add(registerButton);
		registerButton.addActionListener(registerButtonHandler);
		registerButton.setActionCommand("register");
				
		loginButton = new JButton("Login");
		loginButton.setBackground(Color.blue);
		loginButton.setForeground(Color.white);
		buttonPanel.add(loginButton);
		loginButton.addActionListener(loginButtonHandler);
		loginButton.setActionCommand("login");
		
		window.add(menuPanel);
		window.add(buttonPanel);
		window.setVisible(true);
	}
	
	// handles press action to the register button
	public class registerButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			String username = userTextField.getText();
			char[] password = passwordTextField.getPassword();
			
			
			String pass = encrypt.enryptMD5(String.valueOf(password));
			
			
			UserClass newUser = new UserClass(username, pass.toCharArray());
			user.add(newUser);
					
		}
	}
	
	// handles press action to the login button
	public class loginButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			
			window.setVisible(false);
			new Driver();
			
		}
	}

}
