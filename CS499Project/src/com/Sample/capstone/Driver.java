package com.Sample.capstone;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Driver {
	//instance an array list for dog and monkey lists
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();

    public static void main(String[] args) {

        initializeDogList();
        initializeMonkeyList();

        int userInput = 0;
        Scanner scanner = new Scanner(System.in);
        
        //Menu loop, user inputs an integer to select a menu option.
        do {
        	try {
        	displayMenu();
        	userInput = scanner.nextInt();
 
        	switch (userInput) {
        	
        	case 1:
        		scanner.nextLine();
        		intakeNewDog(scanner);
        		break;
        		
        	case 2:
        		scanner.nextLine();
        		intakeNewMonkey(scanner);
        		break;
        		
        	case 3:
        		scanner.nextLine();
        		reserveAnimal(scanner);
        		break;
        		
        	case 4:
        		printAnimals("dog");
        		break;
        		
        	case 5:
        		printAnimals("monkey");
        		break;
        		
        	case 6:
        		printAnimals("notReserved");
        		break;
        		
        	case 0:
        		System.out.println("goodbye");
        		break;
        	}
        	}
        	catch(InputMismatchException e) {
        		System.out.println("Invalid input, please type a number");
        		scanner.nextLine();
        		userInput = scanner.nextInt();
        		
        	}
        }while(userInput != 0);
    }

    // This method prints the menu options
    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[0] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
    }


    // Adds dogs to a list for testing
    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true, "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    }


    // Adds monkeys to a list for testing
    //Optional for testing
    public static void initializeMonkeyList() {

    }


    // Complete the intakeNewDog method
    // The input validation to check that the dog is not already in the list
    // is done for you
    public static void intakeNewDog(Scanner scanner) {
        System.out.println("What is the dog's name?");
        String name = scanner.nextLine();
        for(Dog dog: dogList) {
            if(dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                return; //returns to menu
            }
        }
        System.out.println("What is the dog's breed?");
        String breed = scanner.nextLine();
        System.out.println("What is the dog's gender?");
        String gender = scanner.nextLine();
        System.out.println("What is the dog's age?");
        String age = scanner.nextLine();
        System.out.println("How much does the dog weigh?");
        String weight = scanner.nextLine();
        System.out.println("When was the dog aquired?");
        String aquisitionDate = scanner.nextLine();
        System.out.println("Where was the dog aquired?");
        String aquisitionCountry = scanner.nextLine();
        System.out.println("What is the dog's training status?");
        String trainingStatus = scanner.nextLine();
        System.out.println("is the dog reserved?");
        boolean reserved = scanner.nextBoolean();
        System.out.println("Where is the dog in service?");
        String inServiceCountry = scanner.nextLine();
        Dog dogInput = new Dog(name, breed, gender, age, weight, aquisitionDate, aquisitionCountry, trainingStatus, reserved, inServiceCountry);
        // Add the code to instantiate a new dog and add it to the appropriate list
        dogList.add(dogInput);
        return;
    }


        // Complete intakeNewMonkey
	//Instantiate and add the new monkey to the appropriate list
        // For the project submission you must also  validate the input
	// to make sure the monkey doesn't already exist and the species type is allowed
        public static void intakeNewMonkey(Scanner scanner) {
            System.out.println("What is the monkey's name?");
            String name = scanner.nextLine();
            for(Monkey monkey: monkeyList) {
            	if(monkey.getName().equalsIgnoreCase(name)) {
            		System.out.println("\n\nThis monkey is already in our system\n\n");
            		return;
            	}
            }
            
            
            System.out.println("What is the monkey's gender?");
            String gender = scanner.nextLine();
            System.out.println("What is the monkey's age?");
            String age = scanner.nextLine();
            System.out.println("What is the monkey's weight?");
            String weight = scanner.nextLine();
            System.out.println("When was the monkey aquired?");
            String aquisitionDate = scanner.nextLine();
            System.out.println("Where was the monkey aquired?");
            String aquisitionCountry = scanner.nextLine();
            System.out.println("What is the monkey's training status?");
            String trainingStatus = scanner.nextLine();
            System.out.println("Is the monkey reserved?");
            Boolean reserved = scanner.nextBoolean();
            System.out.println("where is the monkey in service?");
            String inServiceCountry = scanner.nextLine();
            System.out.println("What is the monkey's species?");
            String species = scanner.nextLine();
            System.out.println("What is the monkey's tail length?");
            String tailLength = scanner.nextLine();
            System.out.println("What is the monkey's height?");
            String height = scanner.nextLine();
            System.out.println("What is the monkey's body length?");
            String bodyLength = scanner.nextLine();
            
            Monkey monkeyInput = new Monkey(name, gender, age, weight, aquisitionDate, aquisitionCountry, trainingStatus, reserved, inServiceCountry, species, tailLength, height, bodyLength);
            monkeyList.add(monkeyInput);
            return;
        }

        // Complete reserveAnimal
        // You will need to find the animal by animal type and in service country
        public static void reserveAnimal(Scanner scanner) {
            System.out.println("Please type the animal type: ");
            String animalType = scanner.nextLine();
            if (animalType == "Dog") {
            	System.out.println("Please type the dog's country: ");
            	String country = scanner.nextLine();
            	for(int i = 0; i < (dogList.size()); i++) {
            		if (dogList.get(i).getInServiceCountry() == country) {
            			if (dogList.get(i).getReserved() == false && dogList.get(i).getTrainingStatus() == "in service") {
            				System.out.println("The dog: " + dogList.get(i).getName() + " has been reserved.");
            				dogList.get(i).setReserved(true);
            			}
            			else {
            				System.out.println("No available dog in this country.");
            			}
            		}
            	}
            }
            else if (animalType == "Monkey"){
            	System.out.println("Please type the monkey's country: ");
            	String country = scanner.nextLine();
            	for(int i = 0; i < (monkeyList.size()); i++) {
            		if (monkeyList.get(i).getInServiceCountry() == country) {
            			if (monkeyList.get(i).getReserved() == false && monkeyList.get(i).getTrainingStatus() == "in service") {
            				System.out.println("The monkey: " + monkeyList.get(i).getName() + " has been reserved.");
            				monkeyList.get(i).setReserved(true);
            			}
            			else {
            				System.out.println("No available monkey in this country.");
            			}
            		}
            	}
            }
            else {
            	System.out.println("Invalid animal type.");
            }

        }

        // Complete printAnimals
        // Include the animal name, status, acquisition country and if the animal is reserved.
	// Remember that this method connects to three different menu items.
        // The printAnimals() method has three different outputs
        // based on the listType parameter
        // dog - prints the list of dogs
        // monkey - prints the list of monkeys
        // available - prints a combined list of all animals that are
        // fully trained ("in service") but not reserved 
	// Remember that you only have to fully implement ONE of these lists. 
	// The other lists can have a print statement saying "This option needs to be implemented".
	// To score "exemplary" you must correctly implement the "available" list.
        public static void printAnimals(String animalType) {
        	if (animalType == "dog") {
        		for (int i = 0; i < (dogList.size()); i++) {
        			System.out.println(dogList.get(i).getName());
        		}
        	}
        	else if (animalType == "monkey") {
        		for (int i = 0; i < (monkeyList.size() - 1); i++) {
        			System.out.println(monkeyList.get(i).getName());
        		}
        	}
        	else if (animalType == "notReserved") {
        		for (int i = 0; i < (dogList.size()); i++) {
        			if (dogList.get(i).getReserved() == false) {
        				System.out.println(dogList.get(i).getName());
        			}
        		}
        		for (int i = 0; i < (monkeyList.size()); i++) {
        			if (monkeyList.get(i).getReserved() == false) {
        				System.out.println(monkeyList.get(i).getName());
        			}
        		}
        	}

        }
}

