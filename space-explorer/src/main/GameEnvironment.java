package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.concurrent.ThreadLocalRandom;

public class GameEnvironment {
	private Scanner in = new Scanner(System.in);
	private Scanner enter = new Scanner(System.in);
	private String input;
	private int choice; 
	private int parsedInput;
	private Crew crew = new Crew();
	private Ship ship = crew.getShip();
	private ArrayList<MedicalItem> medItems = new ArrayList<MedicalItem>();
	private ArrayList<FoodItem> foodItems = new ArrayList<FoodItem>();
	private ArrayList<Planet> planets = new ArrayList<Planet>();
	int gameDuration;
	private int day = 1;
	
	
	public static void main(String[] args) {
		GameEnvironment game = new GameEnvironment();
		game.initMedItems();
		game.initFoodItems();
		game.initPlanets();
		game.generateOutpostsItems();
		game.gameSetUp();
		game.mainGame();
		game.endGame();
	}
	
	public void initMedItems() {
		medItems.add(new MedicalItem("Antiplague", 50, "Cures space plague, heals 20 health.", 20, true));
		medItems.add(new MedicalItem("Space Bandages", 20, "Heals 45 health", 45, false));
		medItems.add(new MedicalItem("Galaxy Pills", 10, "Heals 20 health", 20, false));
	}
	
	public void initFoodItems() {
		foodItems.add(new FoodItem("Space soup", 10, "Restore 20 hunger", 5));
		foodItems.add(new FoodItem("Asteroid Meatballs", 30, "Restore 50 hunger", 20));
		foodItems.add(new FoodItem("Cosmo crepes", 20, "Restore 30 hunger", 10));
		foodItems.add(new FoodItem("Galaxy steak", 70, "Restore 80 hunger", 55));
		foodItems.add(new FoodItem("Moon cheese", 50, "Restore 40 hunger", 40));
		foodItems.add(new FoodItem("Space snack", 15, "Restore 8 hunger", 8));
	}
	
	public void initPlanets() {
		String[] planetNames = {"Asauzuno","Uchiliv","Yangosie","Putrilia","Emia","Doyama","Bruxotune","Divunus","Coth LTS4"};
		for (String name: planetNames) {
			planets.add(new Planet(name));
		}
	}
	
	public void generateOutpostsItems() {
		for (Planet planet: planets) {
			SpaceOutpost planetOutpost = planet.getOutpost();
			while (planetOutpost.getFoodItems().size() < 8) {
				int randomNum = ThreadLocalRandom.current().nextInt(0, foodItems.size());
				planetOutpost.getFoodItems().add(foodItems.get(randomNum));
			}
			while (planetOutpost.getMedicalItems().size() < 4) {
				int randomNum = ThreadLocalRandom.current().nextInt(0, medItems.size());
				planetOutpost.getMedicalItems().add(medItems.get(randomNum));
			}	
		}
	}
	
	public void gameSetUp() {
		/* Setting up the game */
		System.out.println("Welcome to Space Explorers!");
		System.out.println("Your spaceship has been broken and its pieces are scattered throughout the surrounding planets."
				+ "\nYou will need to find the missing pieces of your spaceship so that you can repair it and get home.");
		System.out.println("How many days (between 3 and 10) do you want to play for?");
		input = in.nextLine();
		gameDuration = Integer.parseInt(input);
		ship.setPiecesNeeded(gameDuration * 2 / 3);
		System.out.println(ship.getPiecesNeeded() + " missing pieces are scattered throughout the surrounding planets.");
		createCrew();
		nameShip();
		chooseStartingPlanet();
	}
	
	public void mainGame() {
		System.out.println("The crew finds them on the planet " + crew.getCurrentLocation() + " with their spaceship.");
		currentDay();
	}
	
	public void currentDay() {
		while (!gameOver()) {
			System.out.println("Day " + day + "/" + gameDuration);
			System.out.println("What do you want to do?");
			System.out.println("1. View the status of a crew member.");
			System.out.println("2. View the status of the spaceship.");
			System.out.println("3. Visit the nearest outpost.");
			System.out.println("4. Perform a crew member action.");
			System.out.println("5. Move on to the next day.");
			choice = in.nextInt();
			switch(choice) {
			case 1:
				viewCrewMember();
				break;
			case 2:
				viewShip();
				break;
			case 3:
				visitOutpost();
				break;
			case 4:
				performAction();
				break;
			case 5:
				nextDay();
				break;
			}
		}
	}
	
	public void viewCrewMember() {
		System.out.println("Which crew member?");
		int i = 1;
		for (CrewMember member: crew.getCrewMembers()) {
			System.out.println(i + ". " + member.getName());
			i++;
		}
		System.out.println(i + ". Cancel.");
		choice = in.nextInt();
		if (choice == i) {
			currentDay();
		} else {
			System.out.println(crew.getCrewMembers().get(choice-1));
			System.out.println("Press enter to continue.");
			enter.nextLine();
			currentDay();
		}
	}
	
	public void viewShip() {
		System.out.println(ship);
		System.out.println("Press enter to continue.");
		enter.nextLine();
		currentDay();
	}
	
	public void visitOutpost() {
		System.out.println("Money: " + crew.getMoney());
		System.out.println("Inventory: ");
		System.out.println(crew.medicalItemsDetails());
		System.out.println(crew.foodItemsDetails());
		
		SpaceOutpost currentOutpost = crew.getCurrentLocation().getOutpost();
		System.out.println("What do you want to purchase?\n");
		/* medicalItemsSet gets rid of duplicates while still allowing indexing, there is probably a easier way that I haven't figured out */
		ArrayList<MedicalItem> medicalItemsSet = new ArrayList<MedicalItem>(new TreeSet<MedicalItem>(currentOutpost.getMedicalItems()));
		int i = 1;
		for (MedicalItem item: medicalItemsSet) {
			System.out.println(i +". " + item.getName() + "(" + Collections.frequency(currentOutpost.getMedicalItems(), item) + ")");
			System.out.println(item.getDescription());
			System.out.println("Price: " + item.getPrice());
			System.out.println("\n");
			i++;
		}
		int j = i;
		/* foodItemsSet gets rid of duplicates while still allowing indexing, there is probably a easier way that I haven't figured out */
		ArrayList<FoodItem> foodItemsSet = new ArrayList<FoodItem>(new TreeSet<FoodItem>(currentOutpost.getFoodItems()));
		for (FoodItem item: foodItemsSet) {
			System.out.println(i +". " + item.getName() + "(" + Collections.frequency(currentOutpost.getFoodItems(), item) + ")");
			System.out.println(item.getDescription());
			System.out.println("Price: " + item.getPrice());
			System.out.println("\n");
			i++;
		}
		System.out.println(i + ". Nothing.");
		choice = in.nextInt();
		if (choice != i) {
			if (choice < j) {
				MedicalItem item = medicalItemsSet.get(choice-1);
				currentOutpost.purchaseItem(item, crew);	
			} else {
				FoodItem item = foodItemsSet.get(choice-j);
				currentOutpost.purchaseItem(item, crew);	
			}
			System.out.println("Press enter to continue.");
			enter.nextLine();
			visitOutpost();
		} else {
			currentDay();
		}
	}
	
	
	public void performAction() {
		CrewMember chosenCrewMember = chooseCrewMember();
		if (chosenCrewMember.hasActionsLeft()) {
			chooseAction(chosenCrewMember);
		} else {
			System.out.println(chosenCrewMember.getName() + " has no more actions left, please choose another.");
			performAction();
		}
		System.out.println("Press enter to continue.");
		enter.nextLine();
		currentDay();
	}
	
	public CrewMember chooseCrewMember() {
		System.out.println("Choose crew member.");
		int i = 1;
		for (CrewMember member : crew.getCrewMembers()) {
			System.out.println(i + ". " + member.getName() + ", Actions Left: " + member.getActionsLeft());
			i++;
		}
		System.out.println(i + ". Cancel.");
		choice = in.nextInt();
		if (choice == i) {
			currentDay();
			return null;
		} else {
			return crew.getCrewMembers().get(choice - 1);
		} 
	}
	
	public void chooseAction(CrewMember member) {
		System.out.println("What action to perform?");
		System.out.println("1. Eat Food.");
		System.out.println("2. Apply medical item.");
		System.out.println("3. Sleep.");
		System.out.println("4. Repair the shields of the ship.");
		System.out.println("5. Search the current planet" + "(" + crew.getCurrentLocation() +") for missing parts.");
		System.out.println("6. Pilot the ship to a new planet.");
		System.out.println("7. Cancel.");
		choice = in.nextInt();
		switch(choice) {
		case 1:
			FoodItem foodItem = chooseFoodItem();
			member.eat(foodItem, crew);
			break;
		case 2: 
			MedicalItem medicalItem = chooseMedicalItem();
			member.useMedicalItem(medicalItem, crew);
			break;
		case 3:
			member.sleep();
			break;
		case 4:
			member.repair(ship);
			break;
		case 5:
			member.search(medItems, foodItems, crew, ship);
			break;
		case 6:
			System.out.println("Requires another crew member to pilot the ship");
			CrewMember otherCrewMember;
			do {
				otherCrewMember = chooseCrewMember();
				if (otherCrewMember == member) {
					System.out.println("You can't select the same crew member");
				} else if (!otherCrewMember.hasActionsLeft()) {
					System.out.println(otherCrewMember.getName() + " has no more actions left, please choose another.");
				}
			} while (!otherCrewMember.hasActionsLeft() || member == otherCrewMember);
			Planet chosenPlanet = chooseDestinationPlanet();
			member.pilot(chosenPlanet ,otherCrewMember, crew);
			break;
		case 7: 
			performAction();
			break;
		}
	}
	
	public Planet chooseDestinationPlanet() {
		System.out.println("Current Location: " + crew.getCurrentLocation() + ".");
		System.out.println("Which planet would you like to go to?");
		int i = 1;
		for(Planet planet: planets) {
			System.out.println(i + ". " + planet);
			i++;
		}
		System.out.println(i + ". Cancel.");
		choice = in.nextInt();
		if (choice == i) {
			currentDay();
		} else {
			Planet chosenPlanet = planets.get(choice-1);
			if (chosenPlanet == crew.getCurrentLocation()) {
				System.out.println("Please choose a different planet than the planet you are currently at.");
				chosenPlanet = chooseDestinationPlanet();
			}
			return chosenPlanet;
		}
		return null;
	}
	
	public FoodItem chooseFoodItem() {
		int i = 1;
		ArrayList<FoodItem> foodItemsSet = new ArrayList<FoodItem>(new TreeSet<FoodItem>(crew.getFoodItems()));
		for (FoodItem item: foodItemsSet) {
			System.out.println(i +". " + item.getName() + "(" + Collections.frequency(crew.getFoodItems(), item) + ")");
			System.out.println(item.getDescription());
			System.out.println("Price: " + item.getPrice());
			System.out.println("\n");
			i++;
		}
		System.out.println(i + ". Nothing.");
		choice = in.nextInt();
		if (choice == i) {
			currentDay();
		} else {
			return crew.getFoodItems().get(choice-1);
		}
		return null;
	}
	
	public MedicalItem chooseMedicalItem() {
		int i = 1;
		ArrayList<MedicalItem> medicalItemsSet = new ArrayList<MedicalItem>(new TreeSet<MedicalItem>(crew.getMedicalItems()));
		for (MedicalItem item: medicalItemsSet) {
			System.out.println(i +". " + item.getName() + "(" + Collections.frequency(crew.getMedicalItems(), item) + ")");
			System.out.println(item.getDescription());
			System.out.println("Price: " + item.getPrice());
			System.out.println("\n");
			i++;
		}
		System.out.println(i + ". Nothing.");
		choice = in.nextInt();
		if (choice == i) {
			currentDay();
		} else {
			return crew.getMedicalItems().get(choice-1);
		}
		return null;
		
	}
	
	public boolean gameOver() {
		if (day > gameDuration || ship.getPiecesNeeded() == ship.getPiecesFound() || ship.isDestroyed() || crew.getCrewMembers().size() == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public void nextDay() {
		day++;
		if (!gameOver()) {
			
	
			for (CrewMember member: crew.getCrewMembers()) {
				member.setActionsLeft(member.getMaxActions());
			}
			generateOutpostsItems();
			
			
			for (CrewMember member: crew.getCrewMembers()) {
				if (member.isInfected()) {
					member.setHealth(member.getHealth()-15);
					if (member.isDead()) {
						System.out.println(member.getName() + " has died to the space plague and has been removed from the crew.");
						crew.getCrewMembers().remove(member);
					} else {
						System.out.println(member.getName() + " will lose 15 health each day until he gets cured.");
						System.out.println(member.getName() + " now has " + member.getHealth() + "/" + member.getMaxHealth() + " health.");
					}
				}
			}
			
			randomEvent.occurDay(crew);
			currentDay();
		}
	}
		
	
	
	public void endGame() {
		int score = 0;
		for (CrewMember member: crew.getCrewMembers()) {
			score += member.getHealth() * 2;
			score -= member.getFatigue();
			score -= member.getHunger();
		}
		score += ship.getShieldLevel();
		System.out.println("The game has ended.");
		System.out.println("Days took to complete the game: " + day + ".");
		if (ship.getPiecesFound() == ship.getPiecesNeeded()) {
			System.out.println("You have found all the pieces needed, and your crew can get back home!");
			score = score * 2;
		} else {
			System.out.println("You have failed to find all the pieces.");
		}
		System.out.println("Your score for completing the game: " + score + ".");
		
	}
	
	public void createCrew() {
		System.out.println("How many crew members (between 2 and 4) would you like?");
		input = in.nextLine();
		parsedInput = Integer.parseInt(input);
		int crewMemberNeeded = parsedInput; 
		while (crewMemberNeeded != 0) {
			chooseCrewMemberType();
			crewMemberNeeded-=1;
		}
	}
	
	public void chooseCrewMemberType() {
		ArrayList<CrewMember> crewMembers = crew.getCrewMembers();
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
		switch(input) {
		case("Y"):
			System.out.println("Name your crew member: ");
			input = in.nextLine();
			String name = input;
			if (selectedCrewMember == "Engineer") {
				crewMembers.add(new Engineer(name));
			}
			break;
		case("N"):
			chooseCrewMemberType();
			break;
		}
	}
	
	public void nameShip() {
		System.out.println("Name your ship: ");
		input = in.nextLine();
		crew.setName(input);
	}
	
	public void chooseStartingPlanet() {
		System.out.println("Which planet would you like to start at");
		
		for(int i = 0; i < planets.size() ; i++) {
			System.out.println(i+1 + ". " + planets.get(i));
		}
		input = in.nextLine();
		parsedInput = Integer.parseInt(input);
		crew.setCurrentLocation(planets.get(parsedInput-1));
	}
	
}
