package com.capstone.project;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Driver {
	
	//instance an array list for dog and monkey lists.
	private static ArrayList<Dog> dogList = new ArrayList<Dog>();
	private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();
	
	// instance a hash table list for new dog and monkey lists.
	Hashtable<Dog, Integer> dogHashList = new Hashtable<>();
	Hashtable<Monkey, Integer> monkeyHashList = new Hashtable<>();
	int dogKey = 0, monkeyKey = 0;
	
	 static int windowWidth = 500 , windowHeight = 600;
	 String menuType;
	 JFrame window;
	 JPanel menuPanel, buttonPanel, textInputPanel;
	 JLabel textLabel;
	 JButton intakeDogButton, intakeMonkeyButton, reserveAnimalButton, 
	 printDogButton, printMonkeyButton, printNonReservedButton, cancelButton, 
	 confirmButton, backButton;
	 JTextField breedText, nameText, genderText, ageText, weightText, aquisitionText,
	 locationText, reservedText, serviceCountryText, trainingStatusText, speciesText,
	 heightText, tailLengthText, bodyLengthText, animalTypeText;
	 
	 // action handlers for menu buttons
	 ButtonHandler buttonhandler = new ButtonHandler();
	 MenuButtonHandler menuButtonHandler = new MenuButtonHandler();

	 // main function of the application
	public static void main(String[] args) {
		
		// Initialize login page and window for the application
		SqlConnect connect = new SqlConnect();
		connect.connect();
		new LoginPage();
		
	}
	
	// main constructor for the menu class
	public Driver() {
		
		//initialize and create the application window
		window = new JFrame();
		window.setSize(windowWidth, windowHeight);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.gray);
		window.setLayout(null);
		
		mainMenu();
	}
	
	// handles button events in the main menu.
	public class ButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			String action = event.getActionCommand();
			
			switch(action) {
			
				case "intakeDog": 
					intakeDog(); 
					break;
					
				case "intakeMonkey": 
					intakeMonkey(); 
					break;
					
				case "reserveAnimal": 
					reserveAnimal(); 
					break;
					
				case "printDogs": 
					printDogs(); 
					break;
					
				case "printMonkeys": 
					printMonkeys(); 
					break;
					
				case "printNonReserved": 
					printNonReserved(); 
					break;
					
				default:
					break;
			
			}
			
		}
	}
	
	// handles button events in the internal menus.
	public class MenuButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			String action = event.getActionCommand();
			
			switch(action) {
			
				case "cancel":
					buttonPanel.setVisible(false);
					textInputPanel.setVisible(false);
					mainMenu();
					break;
				case "confirm":
					
					switch(menuType) {
					
					case "intakeDog": 
						addDog();
						break;
					case "intakeMonkey":
						addMonkey();
						break;
					case "reserveAnimal": 
						break;
					
					}
					
					buttonPanel.setVisible(false);
					mainMenu();
					break;
				case "back": 
					buttonPanel.setVisible(false);
					textInputPanel.setVisible(false);
					mainMenu();
					break;
				
			}
		}
	}
	
	// function for the main menu panels and buttons.
	public void mainMenu() {	
		
		//create a panel for the column of buttons.
		menuPanel = new JPanel();
		menuPanel.setBounds(10,10,465,400); 
		menuPanel.setBackground(Color.blue);
		menuPanel.setLayout(new GridLayout(6,1));
		
		//button to add a new dog into the system.
		intakeDogButton = new JButton("Intake new dog");
		intakeDogButton.setBackground(Color.blue);
		intakeDogButton.setForeground(Color.white);
		menuPanel.add(intakeDogButton);
		intakeDogButton.addActionListener(buttonhandler);
		intakeDogButton.setActionCommand("intakeDog");
				
		//button to add a new monkey into the system.
		intakeMonkeyButton = new JButton("Intake new monkey");
		intakeMonkeyButton.setBackground(Color.blue);
		intakeMonkeyButton.setForeground(Color.white);
		menuPanel.add(intakeMonkeyButton);
		intakeMonkeyButton.addActionListener(buttonhandler);
		intakeMonkeyButton.setActionCommand("intakeMonkey");
			
		//change the register status of an animal in the system.
		reserveAnimalButton = new JButton("Reserve an animal");
		reserveAnimalButton.setBackground(Color.blue);
		reserveAnimalButton.setForeground(Color.white);
		menuPanel.add(reserveAnimalButton);
		reserveAnimalButton.addActionListener(buttonhandler);
		reserveAnimalButton.setActionCommand("reserveAnimal");
				
		//print a list of dogs in the system.
		printDogButton = new JButton("print a list of dogs");
		printDogButton.setBackground(Color.blue);
		printDogButton.setForeground(Color.white);
		menuPanel.add(printDogButton);
		printDogButton.addActionListener(buttonhandler);
		printDogButton.setActionCommand("printDogs");
			
		//print a list of monkeys in the system.
		printMonkeyButton = new JButton("print a list of monkeys");
		printMonkeyButton.setBackground(Color.blue);
		printMonkeyButton.setForeground(Color.white);
		menuPanel.add(printMonkeyButton);
		printMonkeyButton.addActionListener(buttonhandler);
		printMonkeyButton.setActionCommand("printMonkeys");
			
		//print a list of monkeys in the system.
		printNonReservedButton = new JButton("print a list of non reserved animals");
		printNonReservedButton.setBackground(Color.blue);
		printNonReservedButton.setForeground(Color.white);
		menuPanel.add(printNonReservedButton);
		printNonReservedButton.addActionListener(buttonhandler);
		printNonReservedButton.setActionCommand("printNonReserved");
						
		//add button panel to the window and display the window.
		window.add(menuPanel);
		window.setVisible(true);
		
	}
	
	// menu to add a new dog into the system
	public void intakeDog() {
		menuType = "intakeDog";
		menuPanel.setVisible(false);
		
		textInputPanel = new JPanel();
		textInputPanel.setBounds(10,10,465,400);
		textInputPanel.setBackground(Color.blue);
		textInputPanel.setLayout(new GridLayout(10,2));
		
		textLabel = new JLabel("What is the dog's name? ");
		textLabel.setForeground(Color.white);
		textInputPanel.add(textLabel);
		
		nameText = new JTextField();
		textInputPanel.add(nameText);
		
		textLabel = new JLabel("What is the dog's breed? ");
		textLabel.setForeground(Color.white);
		textInputPanel.add(textLabel);
		
		breedText = new JTextField();
		textInputPanel.add(breedText);
		
		textLabel = new JLabel("What is the dog's gender? ");
		textLabel.setForeground(Color.white);
		textInputPanel.add(textLabel);
		
		genderText = new JTextField();
		textInputPanel.add(genderText);
		
		textLabel = new JLabel("What is the dog's age? ");
		textLabel.setForeground(Color.white);
		textInputPanel.add(textLabel);
		
		ageText = new JTextField();
		textInputPanel.add(ageText);
		
		textLabel = new JLabel("How much does the doge weigh? ");
		textLabel.setForeground(Color.white);
		textInputPanel.add(textLabel);
		
		weightText = new JTextField();
		textInputPanel.add(weightText);
		
		textLabel = new JLabel("When was the dog aquired? ");
		textLabel.setForeground(Color.white);
		textInputPanel.add(textLabel);
		
		aquisitionText = new JTextField();
		textInputPanel.add(aquisitionText);
		
		textLabel = new JLabel("Where was the dog aquired? ");
		textLabel.setForeground(Color.white);
		textInputPanel.add(textLabel);
		
		locationText = new JTextField();
		textInputPanel.add(locationText);
		
		textLabel = new JLabel("What is the dog's training status? ");
		textLabel.setForeground(Color.white);
		textInputPanel.add(textLabel);
		
		trainingStatusText = new JTextField();
		textInputPanel.add(trainingStatusText);
		
		textLabel = new JLabel("is the dog reserved? ");
		textLabel.setForeground(Color.white);
		textInputPanel.add(textLabel);
		
		reservedText = new JTextField();
		textInputPanel.add(reservedText);
		
		textLabel = new JLabel("Where is the dog in service? ");
		textLabel.setForeground(Color.white);
		textInputPanel.add(textLabel);
		
		serviceCountryText = new JTextField();
		textInputPanel.add(serviceCountryText);
		
		bottomButtonRow();
		window.add(textInputPanel);
		
	}
	
	// menu to add a new monkey into the system
	public void intakeMonkey() {
		menuType = "intakeMonkey";
		menuPanel.setVisible(false);
		
		textInputPanel = new JPanel();
		textInputPanel.setBounds(10,10,465,400);
		textInputPanel.setBackground(Color.blue);
		textInputPanel.setLayout(new GridLayout(13,2));
		
		textLabel = new JLabel("What is the monkey's name? ");
		textLabel.setForeground(Color.white);
		textInputPanel.add(textLabel);
		
		nameText = new JTextField();
		textInputPanel.add(nameText);
		
		textLabel = new JLabel("What is the monkey's gender? ");
		textLabel.setForeground(Color.white);
		textInputPanel.add(textLabel);
		
		genderText = new JTextField();
		textInputPanel.add(genderText);
		
		textLabel = new JLabel("What is the monkey's age? ");
		textLabel.setForeground(Color.white);
		textInputPanel.add(textLabel);
		
		ageText = new JTextField();
		textInputPanel.add(ageText);
		
		textLabel = new JLabel("What is the monkey's weight? ");
		textLabel.setForeground(Color.white);
		textInputPanel.add(textLabel);
		
		weightText = new JTextField();
		textInputPanel.add(weightText);
		
		textLabel = new JLabel("When was the monkey aquired? ");
		textLabel.setForeground(Color.white);
		textInputPanel.add(textLabel);
		
		aquisitionText = new JTextField();
		textInputPanel.add(aquisitionText);
		
		textLabel = new JLabel("Where was the monkey aquired? ");
		textLabel.setForeground(Color.white);
		textInputPanel.add(textLabel);
		
		locationText = new JTextField();
		textInputPanel.add(locationText);
		
		textLabel = new JLabel("What is the monkey's training status? ");
		textLabel.setForeground(Color.white);
		textInputPanel.add(textLabel);
		
		trainingStatusText = new JTextField();
		textInputPanel.add(trainingStatusText);
		
		textLabel = new JLabel("Is the monkey reserved? ");
		textLabel.setForeground(Color.white);
		textInputPanel.add(textLabel);
		
		reservedText = new JTextField();
		textInputPanel.add(reservedText);
		
		textLabel = new JLabel("Where is the monkey in service? ");
		textLabel.setForeground(Color.white);
		textInputPanel.add(textLabel);
		
		serviceCountryText = new JTextField();
		textInputPanel.add(serviceCountryText);
		
		textLabel = new JLabel("What is the monkey's species? ");
		textLabel.setForeground(Color.white);
		textInputPanel.add(textLabel);
		
		speciesText = new JTextField();
		textInputPanel.add(speciesText);
		
		textLabel = new JLabel("What is the monkey's tail length? ");
		textLabel.setForeground(Color.white);
		textInputPanel.add(textLabel);
		
		tailLengthText = new JTextField();
		textInputPanel.add(tailLengthText);
		
		textLabel = new JLabel("What is the monkey's height? ");
		textLabel.setForeground(Color.white);
		textInputPanel.add(textLabel);
		
		heightText = new JTextField();
		textInputPanel.add(heightText);
		
		textLabel = new JLabel("What is the monkey's body length? ");
		textLabel.setForeground(Color.white);
		textInputPanel.add(textLabel);
		
		bodyLengthText = new JTextField();
		textInputPanel.add(bodyLengthText);
		
		bottomButtonRow();
		window.add(textInputPanel);
		
	}
	
	// menu to reserve animals by type name and country
	public void reserveAnimal() {
		menuType = "reserveAnimal";
		menuPanel.setVisible(false);
		
		textInputPanel = new JPanel();
		textInputPanel.setBounds(10,10,465,400);
		textInputPanel.setBackground(Color.blue);
		textInputPanel.setLayout(new GridLayout(3,2));
		
		textLabel = new JLabel("Please select the animal type: ");
		textLabel.setForeground(Color.white);
		textInputPanel.add(textLabel);
		
		animalTypeText = new JTextField();
		textInputPanel.add(animalTypeText);
		
		textLabel = new JLabel("Type the animal name: ");
		textLabel.setForeground(Color.white);
		textInputPanel.add(textLabel);
		
		nameText = new JTextField();
		textInputPanel.add(nameText);
		
		textLabel = new JLabel("Type the animal's service country: ");
		textLabel.setForeground(Color.white);
		textInputPanel.add(textLabel);
		
		serviceCountryText = new JTextField();
		textInputPanel.add(serviceCountryText);
		
		bottomButtonRow();
		window.add(textInputPanel);
		
	}
	
	// function to display a list of dogs
	public void printDogs() {
		menuType = "printDogs";
		menuPanel.setVisible(false);
		
		textInputPanel = new JPanel();
		textInputPanel.setBounds(10,10,465,400);
		textInputPanel.setBackground(Color.blue);
		textInputPanel.setLayout(new GridLayout(10,1));
		
		backButtonRow();
		window.add(textInputPanel);
		
		if (dogHashList.isEmpty()) {
			textLabel = new JLabel("Dog List is Empty");
			textLabel.setForeground(Color.white);
			textInputPanel.add(textLabel);
		}
		else {
			for(int i = 0; i < dogHashList.size(); i++) {
				textLabel = new JLabel("" + dogHashList.get(i));
				textLabel.setForeground(Color.white);
				textInputPanel.add(textLabel);
			}
		}
		
	}
	
	// function to display a list of monkeys
	public void printMonkeys() {
		menuType = "printMonkeys";
		menuPanel.setVisible(false);
		
		textInputPanel = new JPanel();
		textInputPanel.setBounds(10,10,465,400);
		textInputPanel.setBackground(Color.blue);
		textInputPanel.setLayout(new GridLayout(10,1));
		
		backButtonRow();
		window.add(textInputPanel);
		
		if (monkeyHashList.isEmpty()) {
			textLabel = new JLabel("Monkey List is Empty");
			textLabel.setForeground(Color.white);
			textInputPanel.add(textLabel);
		}
		else {
			for(int i = 0; i < monkeyHashList.size(); i++) {
				textLabel = new JLabel("" + monkeyHashList.get(i));
				textLabel.setForeground(Color.white);
				textInputPanel.add(textLabel);
			}
		}
		
	}
	
	// function to display a list of non reserved animals
	public void printNonReserved() {
		menuType = "NonReserved";
		menuPanel.setVisible(false);
		
		textInputPanel = new JPanel();
		textInputPanel.setBounds(10,10,465,400);
		textInputPanel.setBackground(Color.blue);
		textInputPanel.setLayout(new GridLayout(10,1));
		
		backButtonRow();
		window.add(textInputPanel);
		
		if (monkeyHashList.isEmpty() && dogHashList.isEmpty()) {
			textLabel = new JLabel("both lists empty");
			textLabel.setForeground(Color.white);
			textInputPanel.add(textLabel);			
		}
		else {
			for(int i = 0; i < dogHashList.size(); i++) {
				textLabel = new JLabel();
				textLabel.setForeground(Color.white);
				textInputPanel.add(textLabel);
			}
			for(int i = 0; i < monkeyHashList.size(); i++) {
				textLabel = new JLabel();
				textLabel.setForeground(Color.white);
				textInputPanel.add(textLabel);
			}
		}
		
	}
	
	// function to hold the cancel and confirm buttons on the bottom of menus.
	public void bottomButtonRow() {
		
		buttonPanel = new JPanel();
		buttonPanel.setBounds(10,450,465,100);
		buttonPanel.setBackground(Color.blue);
		buttonPanel.setLayout(new GridLayout(1,2));
		
		cancelButton = new JButton("Cancel");
		cancelButton.setBackground(Color.blue);
		cancelButton.setForeground(Color.white);
		buttonPanel.add(cancelButton);
		cancelButton.addActionListener(menuButtonHandler);
		cancelButton.setActionCommand("cancel");
		
		confirmButton = new JButton("Confirm");
		confirmButton.setBackground(Color.blue);
		confirmButton.setForeground(Color.white);
		buttonPanel.add(confirmButton);
		confirmButton.addActionListener(menuButtonHandler);
		confirmButton.setActionCommand("confirm");
		
		window.add(buttonPanel);
		
	}
	
	// function to hold the back button on the bottom of menus.
	public void backButtonRow() {
		
		buttonPanel = new JPanel();
		buttonPanel.setBounds(10,525,465,100);
		buttonPanel.setBackground(Color.blue);
		
		backButton = new JButton("Back");
		backButton.setBackground(Color.blue);
		backButton.setForeground(Color.white);
		buttonPanel.add(backButton);
		backButton.addActionListener(menuButtonHandler);
		backButton.setActionCommand("back");
		
		window.add(buttonPanel);
	}
	
	// function to add dog after adding information
	public void addDog() {
		
		Dog newDog = new Dog(
				nameText.getText(), 
				breedText.getText(), 
				genderText.getText(), 
				ageText.getText(), 
				weightText.getText(), 
				aquisitionText.getText(), 
				locationText.getText(), 
				trainingStatusText.getText(), 
				false, 
				serviceCountryText.getText()
				);
		//dogList.add(newDog);
		dogHashList.put(newDog, dogKey);
		dogKey++;
		
	}
	
	// function to add monkey after adding information
	public void addMonkey() {
		
		Monkey newMonkey = new Monkey(
				nameText.getText(), 
				genderText.getText(), 
				ageText.getText(), 
				weightText.getText(), 
				aquisitionText.getText(), 
				locationText.getText(), 
				trainingStatusText.getText(), 
				false, 
				serviceCountryText.getText(), 
				speciesText.getText(), 
				tailLengthText.getText(), 
				heightText.getText(), 
				bodyLengthText.getText()
				);
		//monkeyList.add(newMonkey);
		monkeyHashList.put(newMonkey, monkeyKey);
		monkeyKey++;
	}
	

}
