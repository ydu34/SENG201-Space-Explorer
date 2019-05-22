package main;

import views.*;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Instantiates and keeps track of the objects.
 * @author Yu Duan
 * @author Joyce Cheah
 */
public class GameEnvironment {
	private Crew crew = new Crew();
	private Ship ship = crew.getShip();
	private ArrayList<MedicalItem> medItems = new ArrayList<MedicalItem>();
	private ArrayList<FoodItem> foodItems = new ArrayList<FoodItem>();
	private ArrayList<Planet> planets = new ArrayList<Planet>();
	private int gameDuration;
	private int currentDay = 1;
	private String[] planetNames = { "Asauzuno", "Uchiliv", "Yangosie", "Putrilia", "Emia", "Doyama", "Bruxotune",
			"Divunus", "Coth LTS4" };
	private ArrayList<CrewMember> crewMemberTypes = new ArrayList<CrewMember>();
	private CrewMember chosenCrewMember;
	private CrewMember otherChosenCrewMember;

	/**
	 * Launches the window for a new game.
	 */
	public void launchStartWindow() {
		StartWindow startWindow = new StartWindow(this);
	}

	/**
	 * Closes the start window.
	 * @param startWindow   A StartWindow object.
	 */
	public void closeStartWindow(StartWindow startWindow) {
		startWindow.closeWindow();
		launchInstructionsWindow();
	}
	
	/**
	 * Launches the window for inventory viewing.
	 */
	public void launchInventoryWindow() {
		InventoryWindow inventoryWindow = new InventoryWindow(this);
	}

	/**
	 * Closes the inventory window.
	 * @param inventoryWindow   An InventoryWindow object.
	 */
	public void closeInventoryWindow(InventoryWindow inventoryWindow) {
		inventoryWindow.closeWindow();
	}

	/**
	 * Launches the window for game duration adjustment.
	 */
	public void launchSetUpWindow() {
		SetupWindow setupWindow = new SetupWindow(this);
	}

	/**
	 * Closes the set up window.
	 * @param setupWindow   A SetupWindow object.
	 */
	public void closeSetupWindow(SetupWindow setupWindow) {
		setupWindow.closeWindow();
	}

	/**
	 * Launches the window for game instructions.
	 */
	public void launchInstructionsWindow() {
		InstructionsWindow instructionsWindow = new InstructionsWindow(this);
	}

	/**
	 * Closes the instructions window.
	 * @param instructionsWindow   An InstructionsWindow window.
	 */
	public void closeInstructionsWindow(InstructionsWindow instructionsWindow) {
		instructionsWindow.closeWindow();
		launchSetUpWindow();
	}

	/**
	 * Launches the window for crew creating.
	 */
	public void launchCreateCrewWindow() {
		CreateCrewWindow createCrewWindow = new CreateCrewWindow(this);
	}

	/**
	 * Closes the create crew window.
	 * @param createCrewWindow   A CreateCrewWindow object.
	 */
	public void closeCreateCrewWindow(CreateCrewWindow createCrewWindow) {
		createCrewWindow.closeWindow();
		launchStartingPlanetWindow();
	}

	/**
	 * Launches the window for starting planet selection.
	 */
	public void launchStartingPlanetWindow() {
		StartingPlanetWindow startingPlanetWindow = new StartingPlanetWindow(this);
	}

	/**
	 * Closes the starting planet window.
	 * @param startingPlanetWindow   A StartingPlanetWindow object.
	 */
	public void closeStartingPlanetWindow(StartingPlanetWindow startingPlanetWindow) {
		startingPlanetWindow.closeWindow();
	}

	/**
	 * Launches the main game window.
	 */
	public void launchMainWindow() {
		MainWindow mainWindow = new MainWindow(this);
	}

	/**
	 * Closes the main game window.
	 * @param mainWindow   A MainWindow object.
	 */
	public void closeMainWindow(MainWindow mainWindow) {
		mainWindow.closeWindow();
	}

	/**
	 * Launches the outpost window. 
	 */
	public void launchOutpostWindow() {
		OutpostWindow outpostWindow = new OutpostWindow(this);
	}

	/**
	 * Closes the outpost window.
	 * @param outpostWindow   An OutpostWindow object.
	 */
	public void closeOutpostWindow(OutpostWindow outpostWindow) {
		outpostWindow.closeWindow();
	}

	/**
	 * Launches the window for all the crew members' details.
	 */
	public void launchCrewMemberWindow() {
		CrewMemberWindow crewMemberWindow = new CrewMemberWindow(this);
	}

	/**
	 * Closes the crew member window.
	 * @param crewMemberWindow   A CrewMemberWindow object.
	 */
	public void closeCrewMemberWindow(CrewMemberWindow crewMemberWindow) {
		crewMemberWindow.closeWindow();
	}

	/**
	 * Launches the window for new planet selection.
	 */
	public void launchSelectPlanetWindow() {
		SelectPlanetWindow selectPlanetWindow = new SelectPlanetWindow(this);
	}

	/**
	 * Closes the select planet window.
	 * @param selectPlanetWindow   A SelectPlanetWindow object.
	 */
	public void closeSelectPlanetWindow(SelectPlanetWindow selectPlanetWindow) {
		selectPlanetWindow.closeWindow();
	}

	/**
	 * Launches the window for pilot selection.
	 */
	public void launchSelectPilotWindow() {
		SelectPilotWindow selectPilotWindow = new SelectPilotWindow(this);
	}

	/**
	 * Closes the pilot selection window 
	 * @param selectPilotWindow   A SelectPilotWindow object.
	 */
	public void closeSelectPilotWindow(SelectPilotWindow selectPilotWindow) {
		selectPilotWindow.closeWindow();
	}
	
	/**
	 * Launches the window for the final score. 
	 */
	public void launchGameOverWindow() {
		GameOverWindow gameOverWindow = new GameOverWindow(this);
	}

	/**
	 * Closes the game over window.
	 * @param gameOverWindow   A GameOverWindow object.
	 */
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

	/**
	 * Initializes and starts the game.
	 * @param args   An array of strings.
	 */
	public static void main(String[] args) {
		GameEnvironment game = new GameEnvironment();
		game.initialize();
		game.launchStartWindow();

	}

	/**
	 * Calls the methods for objects initializing.
	 */
	public void initialize() {
		initCrewMemberTypes();
		initMedItems();
		initFoodItems();
		initPlanets();
		generateOutpostsItems();
	}

	/**
	 * Initializes the crew member types.
	 */
	public void initCrewMemberTypes() {
		crewMemberTypes.add(new Engineer("Engineer"));
		crewMemberTypes.add(new HealthNut("Health Nut"));
		crewMemberTypes.add(new Nibbler("Nibbler"));
		crewMemberTypes.add(new NightOwl("Night Owl"));
		crewMemberTypes.add(new Protected("Protected"));
		crewMemberTypes.add(new Regular("Regular"));
	}

	/**
	 * Initializes the medical items.
	 */
	public void initMedItems() {
		medItems.add(new MedicalItem("Antiplague", 50, "Cures space plague, heals 20 health.", 20, true));
		medItems.add(new MedicalItem("Space Bandages", 20, "Heals 45 health", 45, false));
		medItems.add(new MedicalItem("Galaxy Pills", 10, "Heals 20 health", 20, false));
	}

	/**
	 * Initializes the food items.
	 */
	public void initFoodItems() {
		foodItems.add(new FoodItem("Space soup", 10, "Restore 20 hunger", 20));
		foodItems.add(new FoodItem("Asteroid Meatballs", 30, "Restore 50 hunger", 50));
		foodItems.add(new FoodItem("Cosmo crepes", 20, "Restore 30 hunger", 30));
		foodItems.add(new FoodItem("Galaxy steak", 70, "Restore 80 hunger", 80));
		foodItems.add(new FoodItem("Moon cheese", 50, "Restore 40 hunger", 40));
		foodItems.add(new FoodItem("Space snack", 15, "Restore 8 hunger", 8));
	}

	/**
	 * Initializes the planets.
	 */
	public void initPlanets() {
		for (String name : planetNames) {
			planets.add(new Planet(name));
		}
	}

	/**
	 * Generates eight food items and four medical items randomly to sell in outposts.
	 */
	public void generateOutpostsItems() {
		for (Planet planet : planets) {
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

	/**
	 * Introduces the game situation.
	 * @return A string message of the game situation.
	 */
	public String introductionText() {
		String text = "Your crew is lost in space in a unknown galaxy. Your spaceship's lightspeed engines are borken and scattered throughout the surrounding planets. You will need to find the missing pieces of your spaceship so that you can repair it and travel back to Earth. \r\n\r\nEach day you may perform crew member actions. Each crew member has two actions that can be used. ";
		return text;
	}

	/**
	 * Checks if the game is over by checking if any of the conditions for game over are met.
	 * @return true if any of the conditions are met, false otherwise.
	 */
	public boolean gameOver() {
		if (currentDay >= gameDuration || ship.getPiecesNeeded() == ship.getPiecesFound() || ship.isDestroyed()
				|| crew.getCrewMembers().size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Creates crew members personalized by players.
	 * @param member   A CrewMember object.
	 * @return A null CrewMember object.
	 */
	public CrewMember createCrewMember(CrewMember member) {
		switch (member.getType()) {
		case "Engineer":
			return new Engineer(member.getName());
		case "Health Nut":
			return new HealthNut(member.getName());
		case "Nibbler":
			return new Nibbler(member.getName());
		case "Night Owl":
			return new NightOwl(member.getName());
		case "Protected":
			return new Protected(member.getName());
		case "Regular":
			return new Regular(member.getName());
		}
		return null;
	}

	/**
	 * Moves on to the next day.
	 * @return A string message of currently infected crew members and the event occurred.
	 */
	public String nextDay() {
		currentDay++;
		String returnString = "Day " + currentDay + "/" + gameDuration + ".\n";
		for (CrewMember member : crew.getCrewMembers()) {
			member.setActionsLeft(member.getMaxActions());
		}
		returnString += checkInfectedCrewMembers();
		generateOutpostsItems();

		returnString += RandomEvent.occurDay(crew);
		return returnString;
	}

	/**
	 * Checks the well-being of the infected crew members.
	 * @return A string message of the infected crew members' updated health levels or if they have died. 
	 */
	public String checkInfectedCrewMembers() {
		String returnString = "";
		ArrayList<CrewMember> deadCrewMembers = new ArrayList<CrewMember>();
		for (CrewMember member : crew.getCrewMembers()) {
			if (member.isInfected()) {
				member.setHealth(member.getHealth() - 20);
				if (member.isDead()) {
					returnString += member.getName()
							+ " has died to the space plague and has been removed from the crew.\n";
					deadCrewMembers.add(member);
				} else {
					returnString += member.getName() + " will lose 20 health each day until he gets cured.\n";
					returnString += member.getName() + " now has " + member.getHealth() + "/" + member.getMaxHealth()
							+ " health.\n";
				}
			}
		}
		for (CrewMember deadMember : deadCrewMembers) {
			crew.getCrewMembers().remove(deadMember);
		}
		return returnString;
	}

	/**
	 * Calculates the final score of the game.
	 * @return An int of the final score.
	 */
	public int calculateFinalScore() {
		int score = 0;
		for (CrewMember member : crew.getCrewMembers()) {
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
	
	/**
	 * Checks if the game is over by checking if any of the game over conditions are met.
	 * @return A string message describing why the game is over.
	 */
	public String gameOverMessage() {
		if (ship.isDestroyed()) {
			return "The asteroid hits and your ship is torn apart.";
		} else if (ship.getPiecesFound() >= ship.getPiecesNeeded()) {
			return "Your crew have found the necessary engine pieces and they returned home.";
		} else if (currentDay >= gameDuration) {
			return "The days have passed and all the engines pieces were stolen by alien pirates.";
		} else if (crew.getCrewMembers().size() == 0) {
			return "The empty spaceship floats silently through space eventually looted by alien pirates.";
		} else {
			return "It is unkown what happend to your crew and spaceship.";
		}
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

	public CrewMember getOtherChosenCrewMember() {
		return otherChosenCrewMember;
	}

	public void setOtherChosenCrewMember(CrewMember otherChosenCrewMember) {
		this.otherChosenCrewMember = otherChosenCrewMember;
	}

}
