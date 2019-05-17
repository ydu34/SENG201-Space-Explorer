package main;

import views.*;

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
	private int gameDuration;
	private int currentDay = 1;
	private String[] planetNames = {"Asauzuno","Uchiliv","Yangosie","Putrilia","Emia","Doyama","Bruxotune","Divunus","Coth LTS4"};
	private ArrayList<CrewMember> crewMemberTypes = new ArrayList<CrewMember>();
	private CrewMember chosenCrewMember;
	
	public void launchStartWindow() {
		StartWindow startWindow = new StartWindow(this);
	}
	
	public void launchInventoryPopUp() {
		InventoryPopUp inventoryPopUp = new InventoryPopUp(this);
	}
	
	public void closeInventoryPopUp(InventoryPopUp inventoryPopUP) {
		inventoryPopUP.closeWindow();
	}
	
	public void closeStartWindow(StartWindow startWindow) {
		startWindow.closeWindow();
		launchInstructionsWindow();
	}
	
	public void launchSetUpWindow() {
		SetupWindow setupWindow = new SetupWindow(this);
	}
	
	public void closeSetupWindow(SetupWindow setupWindow) {
		setupWindow.closeWindow();
	}
	
	public void launchInstructionsWindow() {
		InstructionsWindow instructionsWindow = new InstructionsWindow(this);
	}
	
	public void closeInstructionsWindow(InstructionsWindow instructionsWindow) {
		instructionsWindow.closeWindow();
		launchSetUpWindow();
	}
	
	public void launchCreateCrewWindow() {
		CreateCrewWindow createCrewWindow = new CreateCrewWindow(this);
	}
	
	public void closeCreateCrewWindow(CreateCrewWindow createCrewWindow) {
		createCrewWindow.closeWindow();
		launchStartingPlanetWindow();
	}
	
	public void launchStartingPlanetWindow() {
		StartingPlanetWindow startingPlanetWindow = new StartingPlanetWindow(this);
	}
	
	public void closeStartingPlanetWindow(StartingPlanetWindow startingPlanetWindow) {
		startingPlanetWindow.closeWindow();
		launchMainWindow();
	}
	
	public void launchMainWindow() {
		MainWindow mainWindow = new MainWindow(this);
	}
	
	public void closeMainWindow(MainWindow mainWindow) {
		mainWindow.closeWindow();
	}
	
	public void launchOutpostWindow() {
		OutpostWindow outpostWindow = new OutpostWindow(this);
	}
	
	public void closeOutpostWindow(OutpostWindow outpostWindow) {
		outpostWindow.closeWindow();
		launchMainWindow();
	}
	
	public void launchCrewMemberWindow() {
		CrewMemberWindow crewMemberWindow = new CrewMemberWindow(this);
	}
	
	public void closeCrewMemberWindow(CrewMemberWindow crewMemberWindow) {
		crewMemberWindow.closeWindow();
	}
	
	public void launchPilotWindow() {
		PilotWindow pilotWindow = new PilotWindow(this);
	}
	
	public void closePilotWindow(PilotWindow pilotWindow) {
		pilotWindow.closeWindow();
	}
	
	public void launchGameOverWindow() {
		GameOverWindow gameOverWindow = new GameOverWindow(this);
	}
	
	public void closeGameOverWindow(GameOverWindow gameOverWindow) {
		gameOverWindow.closeWindow();
		GameEnvironment game = new GameEnvironment();
		game.initCrewMemberTypes();
		game.initMedItems();
		game.initFoodItems();
		game.initPlanets();
		game.generateOutpostsItems();
		game.launchStartWindow();
	}
	
	
	
	
	public static void main(String[] args) {
		GameEnvironment game = new GameEnvironment();
		game.initCrewMemberTypes();
		game.initMedItems();
		game.initFoodItems();
		game.initPlanets();
		game.generateOutpostsItems();
		game.launchStartWindow();
	}
	
	public void initCrewMemberTypes() {
		crewMemberTypes.add(new Engineer("Engineer"));
		crewMemberTypes.add(new HealthNut("Health Nut"));
		crewMemberTypes.add(new Nibbler("Nibbler"));
		crewMemberTypes.add(new NightOwl("Night Owl"));
		crewMemberTypes.add(new Protected("Protected"));
		crewMemberTypes.add(new Regular("Regular"));
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
	
	public void introMessage() {
		System.out.println("Welcome to Space Explorers!");
		System.out.println("Your spaceship has been broken and its pieces are scattered throughout the surrounding planets."
				+ "\nYou will need to find the missing pieces of your spaceship so that you can repair it and get home.");
	}
	
	
	public void mainGame() {
		System.out.println("The crew finds them on the planet " + crew.getCurrentLocation() + " with their spaceship.");
		currentDay();
	}
	
	public void printMainOptions() {
		System.out.println("Day " + currentDay + "/" + gameDuration);
		System.out.println("What do you want to do?");
		System.out.println("1. View the status of a crew member.");
		System.out.println("2. View the status of the spaceship.");
		System.out.println("3. Visit the nearest outpost.");
		System.out.println("4. Perform a crew member action.");
		System.out.println("5. Move on to the next day.");
	}
	
	public void currentDay() {
		while (!gameOver()) {
			printMainOptions();
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
		if (chosenCrewMember.isAvailable()) {
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
	
	public void printCrewMemberActions() {
		System.out.println("What action to perform?");
		System.out.println("1. Eat Food.");
		System.out.println("2. Apply medical item.");
		System.out.println("3. Sleep.");
		System.out.println("4. Repair the shields of the ship.");
		System.out.println("5. Search the current planet" + "(" + crew.getCurrentLocation() +") for missing parts.");
		System.out.println("6. Pilot the ship to a new planet.");
		System.out.println("7. Cancel.");
	}
	
	public CrewMember selectOtherCrewMember(CrewMember member) {
		CrewMember otherCrewMember;
		do {
			otherCrewMember = chooseCrewMember();
			if (otherCrewMember == member) {
				System.out.println("You can't select the same crew member");
			} else if (!otherCrewMember.isAvailable()) {
				System.out.println(otherCrewMember.getName() + " has no more actions left, please choose another.");
			}
		} while (!otherCrewMember.isAvailable() || member == otherCrewMember);
		return otherCrewMember;
	}
	
	public void chooseAction(CrewMember member) {
		printCrewMemberActions();
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
			CrewMember otherCrewMember = selectOtherCrewMember(member);
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
		if (currentDay > gameDuration || ship.getPiecesNeeded() == ship.getPiecesFound() || ship.isDestroyed() || crew.getCrewMembers().size() == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public String nextDay() {
		currentDay++;
		String returnString = "";
		if (!gameOver()) {
			for (CrewMember member: crew.getCrewMembers()) {
				member.setActionsLeft(member.getMaxActions());
			}
			generateOutpostsItems();
			ArrayList<CrewMember> deadCrewMembers = new ArrayList<CrewMember>();
			for (CrewMember member: crew.getCrewMembers()) {
				if (member.isInfected()) {
					member.setHealth(member.getHealth()-15);
					if (member.isDead()) {
						returnString += member.getName() + " has died to the space plague and has been removed from the crew.\n";
						deadCrewMembers.add(member);
					} else {
						returnString += member.getName() + " will lose 15 health each day until he gets cured.\n";
						returnString += member.getName() + " now has " + member.getHealth() + "/" + member.getMaxHealth() + " health.\n";
					}
				}
			}
			for (CrewMember deadMember: deadCrewMembers) {
				crew.getCrewMembers().remove(deadMember);
			}
			returnString += RandomEvent.occurDay(crew);
		}
		return returnString;
	}
		
	public int calculateFinalScore() {
		int score = 0;
		for (CrewMember member: crew.getCrewMembers()) {
			score += member.getHealth();
			score += member.getMaxFatigue() - member.getFatigue();
			score += member.getMaxHunger() - member.getHunger();
		}
		score += ship.getShieldLevel();
		if (ship.getPiecesFound() == ship.getPiecesNeeded()) {
			score = score * 2;
			if (score < 0) {
				score = 0;
			}
		}
		return score;
	}
	

	public Crew getCrew() {
		return crew;
	}

	public void setCrew(Crew crew) {
		this.crew = crew;
	}

	public Ship getShip() {
		return ship;
	}

	public void setShip(Ship ship) {
		this.ship = ship;
	}

	public ArrayList<MedicalItem> getMedItems() {
		return medItems;
	}

	public void setMedItems(ArrayList<MedicalItem> medItems) {
		this.medItems = medItems;
	}

	public ArrayList<FoodItem> getFoodItems() {
		return foodItems;
	}

	public void setFoodItems(ArrayList<FoodItem> foodItems) {
		this.foodItems = foodItems;
	}

	public ArrayList<Planet> getPlanets() {
		return planets;
	}

	public void setPlanets(ArrayList<Planet> planets) {
		this.planets = planets;
	}

	public int getGameDuration() {
		return gameDuration;
	}

	public void setGameDuration(int gameDuration) {
		this.gameDuration = gameDuration;
	}

	public int getCurrentDay() {
		return currentDay;
	}

	public void setCurrentDay(int currentDay) {
		this.currentDay = currentDay;
	}
	
	public String[] getPlanetNames() {
		return planetNames;
	}

	public void setPlanetNames(String[] planetNames) {
		this.planetNames = planetNames;
	}

	public ArrayList<CrewMember> getCrewMemberTypes() {
		return crewMemberTypes;
	}

	public void setCrewMemberTypes(ArrayList<CrewMember> crewMemberTypes) {
		this.crewMemberTypes = crewMemberTypes;
	}

	public CrewMember getChosenCrewMember() {
		return chosenCrewMember;
	}

	public void setChosenCrewMember(CrewMember chosenCrewMember) {
		this.chosenCrewMember = chosenCrewMember;
	}


	
}
