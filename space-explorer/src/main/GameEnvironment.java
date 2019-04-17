package main;
import java.util.ArrayList;
import java.util.Scanner;

public class GameEnvironment {
	
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		/* Initialize objects */
		Crew crew = new Crew();
		ArrayList<CrewMember> crewMembers = crew.getCrewMembers();
		
		/* Initialize medical items */
		MedicalItem med1 = new MedicalItem("Antiplague", 50, "Cures space plague, heals 20 health.", 20, true);
		MedicalItem med2 = new MedicalItem("Space Bandages", 40, "Heals 50 health", 100, false);
		MedicalItem med3 = new MedicalItem("Galaxy Pills", 20, "Heals 40 health", 40, false);
		
		MedicalItem[] medItems = {med1, med2, med3};
		
		/* Initialize food items */
		FoodItem food1 = new FoodItem("Space soup", 10, "Restore 20 hunger", 5);
		FoodItem food2 = new FoodItem("Asteroid Meatballs", 30, "Restore 50 hunger", 20);
		FoodItem food3 = new FoodItem("Cosmo crepes", 20, "Restore 30 hunger", 10);
		FoodItem food4 = new FoodItem("Galaxy steak", 70, "Restore 80 hunger", 55);
		FoodItem food5 = new FoodItem("Moon cheese", 50, "Restore 40 hunger", 40);
		FoodItem food6 = new FoodItem("Space snack", 15, "Restore 8 hunger", 8);
		
		FoodItem[] foodItems = {food1, food2, food3, food4, food5, food6};
		
		/* Initialize planets that the crew can pilot to */
		String[] planetNames = {"asauzuno","uchiliv","yangosie","putrilia","emia","doyama","bruxotune","divunus","coth LTS4"};
		ArrayList<Planet> planets = new ArrayList<Planet>();
		for (String name: planetNames) {
			SpaceOutpost outpost = new SpaceOutpost();
			outpost.generateItems(medItems, foodItems);
			planets.add(new Planet(name, outpost));
		}

		
		/* Setting up the game */
		System.out.println("Welcome to Space Explorers!");
		System.out.println("Your spaceship has been broken and its pieces are scattered throughout the surrounding planets."
				+ "\nYou will need to find the missing pieces of your spaceship so that you can repair it and get home.");
		System.out.println("How many days (between 3 and 10) do you want to play for?");
		String input = in.nextLine();
		int gameDuration = Integer.parseInt(input);
		int partsToBeFound = gameDuration * 2 / 3;
		System.out.println(partsToBeFound + " missing pieces are scattered throughout the surrounding planets.");
		
		boolean crewCreation = true;
		int parsedInput = Integer.parseInt(input);
		System.out.println("How many crew members (between 2 and 4) would you like?");
		input = in.nextLine();
		parsedInput = Integer.parseInt(input);
		int crewMemberNeeded = parsedInput; 
		/* Shows the player the types of crew and ask them to select crew members until they have 4 */
		int crewMemberCount = 0; /* the number of crew member that has been created */
		
		
		/* Creating crew members */
		CREWCREATION:
		while (crewCreation) {
			
			System.out.println("There are 6 different types of crew members: ");
			System.out.println("\t1. Engineer");
			System.out.println("\t2. place holder"); /* Placeholder crew members, need to decide on them */
			System.out.println("\t3. place holder");
			System.out.println("\t4. place holder");
			System.out.println("\t5. place holder");
			System.out.println("\t6. place holder");
			System.out.println("Please select a crew member to recruit to your crew.");
			input = in.nextLine();
			parsedInput = Integer.parseInt(input);
			String selectedCrewMember = "";
			switch(parsedInput) {
			case 1:
				selectedCrewMember = "Engineer";
				Engineer.description();
				break;
			case 2:
				selectedCrewMember = "Placeholder";
				System.out.println("Placeholder");
				break;
			case 3:
				selectedCrewMember = "Placeholder";
				System.out.println("Placeholder");
				break;
			case 4:
				selectedCrewMember = "Placeholder";
				System.out.println("Placeholder");
				break;
			case 5:
				selectedCrewMember = "Placeholder";
				System.out.println("Placeholder");
				break;
			case 6:
				selectedCrewMember = "Placeholder";
				System.out.println("Placeholder");
				break;	
			}
			System.out.println("Recruit " + selectedCrewMember + "? (Y/N)");
			input = in.nextLine();
			if (input.equals("Y")) {
				System.out.println("Name your crew: ");
				input = in.nextLine();
				String name = input;
				if (selectedCrewMember == "Engineer") {
					crewMembers.add(new Engineer(name));
				}
				
			} else {
				continue CREWCREATION;
			}
			crewMemberCount++;
			if (crewMemberCount == crewMemberNeeded) {
				crewCreation = false;
			}
		}
		
		
		/* Naming space ship */
		System.out.println("Name your ship: ");
		input = in.nextLine();
		crew.setName(input);
		
		System.out.println("Which planet would you like to start at");
		
		/* The main game loop */
		boolean mainGame = true;
		MAINGAME:
		while (mainGame) {
			
		}
	}
	
	
}
