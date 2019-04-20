package main;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class GameEnvironment {
	private Scanner in = new Scanner(System.in);
	private Scanner enter = new Scanner(System.in);
	private Ship ship = new Ship();
	private String input;
	private int choice; 
	private int parsedInput;
	private Crew crew = new Crew();
	private ArrayList<MedicalItem> medItems = new ArrayList<MedicalItem>();
	private ArrayList<FoodItem> foodItems = new ArrayList<FoodItem>();
	private ArrayList<Planet> planets = new ArrayList<Planet>();
	int gameDuration;
	private int day = 0;
	
	
	public static void main(String[] args) {
		GameEnvironment game = new GameEnvironment();
		game.initMedItems();
		game.initFoodItems();
		game.initPlanets();
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
			SpaceOutpost outpost = new SpaceOutpost();
			outpost.generateItems(medItems, foodItems);
			planets.add(new Planet(name, outpost));
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
		System.out.println("What do you want to do?");
		System.out.println("1. View the status of a crew member.");
		System.out.println("2. View the status of the spaceship.");
		System.out.println("3. Visit the nearest outpost.");
		System.out.println("4. Perform a crew member action.");
		System.out.println("5. Move on to the next day.");
		choice = in.nextInt();
		switch(choice) {
		case 1:
			viewCrew();
		case 2:
			viewShip();
		case 3:
			visitOutpost();
		case 4:
			performAction();
		case 5:
			nextDay();
		}
		
	}
	
	public void viewCrew() {
		System.out.println("Which crew member?");
		int i = 1;
		for (CrewMember member: crew.getCrewMembers()) {
			System.out.println(i + ". " + member.getName());
			i++;
		}
		choice = in.nextInt();
		System.out.println(crew.getCrewMembers().get(i-1));
		System.out.println("Enter to continue.");
		enter.nextLine();
		currentDay();
	}
	
	public void viewShip() {
		System.out.println(ship);
	}
	
	public void visitOutpost() {
		SpaceOutpost currentOutpost = crew.getCurrentLocation().getOutpost();
		System.out.println("Items for sale:");
		for (Item item: currentOutpost.getItemsForSale()) {
			System.out.println(item);
			System.out.println("\n");
		}
		System.out.println("Money: " + crew.getMoney());
		System.out.println("Inventory: " + crew.inventoryDetails());
		System.out.println("");
	}
	
	public void purchaseItem() {
		
	}
	
	public void performAction() {
		
	}
	
	public void nextDay() {
		
	}
	
	
	
	
	public void endGame() {
		
	}
	
	public void createCrew() {
		System.out.println("How many crew members (between 2 and 4) would you like?");
		input = in.nextLine();
		parsedInput = Integer.parseInt(input);
		int crewMemberNeeded = parsedInput; 
		while (crewMemberNeeded != 0) {
			chooseCrewMember();
			crewMemberNeeded-=1;
		}
	}
	
	public void chooseCrewMember() {
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
			System.out.println("Name your crew: ");
			input = in.nextLine();
			String name = input;
			if (selectedCrewMember == "Engineer") {
				crewMembers.add(new Engineer(name));
			}
			break;
		case("N"):
			chooseCrewMember();
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
