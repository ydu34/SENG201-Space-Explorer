package main;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import views.CreateCrewWindow;
import views.CrewMemberWindow;
import views.GameOverWindow;
import views.InstructionsWindow;
import views.InventoryWindow;
import views.MainWindow;
import views.OutpostWindow;
import views.SelectPilotWindow;
import views.SelectPlanetWindow;
import views.SetupWindow;
import views.StartWindow;
import views.StartingPlanetWindow;

/**
 * Instantiates and keeps track of the objects in the game, and methods for
 * launching and closing GUI windows are here.
 * 
 * @author Yu Duan
 * @author Joyce Cheah
 */
public class GameEnvironment {
	private Crew crew;
	private Ship ship;
	private ArrayList<MedicalItem> gameMedicalItems;
	private ArrayList<FoodItem> gameFoodItems;
	private ArrayList<Planet> planets;
	private int gameDuration;
	private int currentDay;
	private ArrayList<CrewMember> crewMemberTypes;
	private CrewMember chosenCrewMember;
	private CrewMember otherChosenCrewMember;

	/**
	 * Creates the game environment and initializes objects.
	 */
	public GameEnvironment() {
		crew = new Crew();
		ship = crew.getShip();
		gameMedicalItems = new ArrayList<MedicalItem>();
		gameFoodItems = new ArrayList<FoodItem>();
		planets = new ArrayList<Planet>();
		currentDay = 1;
		crewMemberTypes = new ArrayList<CrewMember>();
	}

	/**
	 * Launches the window for a new game.
	 */
	public void launchStartWindow() {
		StartWindow startWindow = new StartWindow(this);
	}

	/**
	 * Closes the start window.
	 * 
	 * @param startWindow A StartWindow object.
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
	 * 
	 * @param inventoryWindow An InventoryWindow object.
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
	 * 
	 * @param setupWindow A SetupWindow object.
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
	 * 
	 * @param instructionsWindow An InstructionsWindow window.
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
	 * 
	 * @param createCrewWindow A CreateCrewWindow object.
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
	 * 
	 * @param startingPlanetWindow A StartingPlanetWindow object.
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
	 * 
	 * @param mainWindow A MainWindow object.
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
	 * 
	 * @param outpostWindow An OutpostWindow object.
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
	 * 
	 * @param crewMemberWindow A CrewMemberWindow object.
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
	 * 
	 * @param selectPlanetWindow A SelectPlanetWindow object.
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
	 * 
	 * @param selectPilotWindow A SelectPilotWindow object.
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
	 * 
	 * @param gameOverWindow A GameOverWindow object.
	 */
	public void closeGameOverWindow(GameOverWindow gameOverWindow) {
		gameOverWindow.closeWindow();
		GameEnvironment game = new GameEnvironment();
		game.initCrewMemberTypes();
		game.initMedicalItems();
		game.initFoodItems();
		game.initPlanets();
		game.generateOutpostsItems();
		game.launchStartWindow();
	}

	/**
	 * Initializes and starts the game.
	 * 
	 * @param args An array of strings.
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
		initMedicalItems();
		initFoodItems();
		initPlanets();
		generateOutpostsItems();
	}

	/**
	 * Initializes the crew member types.
	 */
	public void initCrewMemberTypes() {
		crewMemberTypes.add(new Engineer("Engineer", null));
		crewMemberTypes.add(new HealthNut("Health Nut", null));
		crewMemberTypes.add(new Nibbler("Nibbler", null));
		crewMemberTypes.add(new NightOwl("Night Owl", null));
		crewMemberTypes.add(new Regular("Regular", null));
		crewMemberTypes.add(new Explorer("Explorer", null));
	}

	/**
	 * Initializes the medical items.
	 */
	public void initMedicalItems() {
		gameMedicalItems.add(new MedicalItem("Antiplague", 50, "Cures space plague, heals 10 health.", 10, true));
		gameMedicalItems.add(new MedicalItem("Space Bandages", 20, "Heals 45 health", 45, false));
		gameMedicalItems.add(new MedicalItem("Galaxy Pills", 10, "Heals 20 health", 20, false));
		gameMedicalItems.add(new MedicalItem("Stimpak", 40, "Heals 60 health", 60, false));
	}

	/**
	 * Initializes the food items.
	 */
	public void initFoodItems() {
		gameFoodItems.add(new FoodItem("Space soup", 10, "Restore 20 hunger", 20));
		gameFoodItems.add(new FoodItem("Asteroid Meatballs", 30, "Restore 50 hunger", 50));
		gameFoodItems.add(new FoodItem("Cosmo crepes", 20, "Restore 30 hunger", 30));
		gameFoodItems.add(new FoodItem("Galaxy steak", 70, "Restore 80 hunger", 80));
		gameFoodItems.add(new FoodItem("Moon cheese", 50, "Restore 40 hunger", 40));
		gameFoodItems.add(new FoodItem("Space snack", 15, "Restore 8 hunger", 8));
	}

	/**
	 * Initializes the planets.
	 */
	public void initPlanets() {
		planets.add(new Planet("Asauzuno", "/resources/planet1.png"));
		planets.add(new Planet("Uchiliv", "/resources/planet2.png"));
		planets.add(new Planet("Yangosie", "/resources/planet3.jpg"));
		planets.add(new Planet("Putrilia", "/resources/planet4.jpg"));
		planets.add(new Planet("Emia", "/resources/planet5.png"));
		planets.add(new Planet("Doyama", "/resources/planet6.png"));
		planets.add(new Planet("Bruxotune", "/resources/planet7.jpg"));
		planets.add(new Planet("Coth LTS4", "/resources/planet8.jpg"));
		planets.add(new Planet("Divunus", "/resources/planet9.jpg"));
	}

	/**
	 * Generates eight food items and four medical items randomly to sell in
	 * outposts.
	 */
	public void generateOutpostsItems() {
		for (Planet planet : planets) {
			SpaceOutpost planetOutpost = planet.getOutpost();
			while (planetOutpost.getFoodItems().size() < 8) {
				int randomNum = ThreadLocalRandom.current().nextInt(0, gameFoodItems.size());
				planetOutpost.getFoodItems().add(gameFoodItems.get(randomNum));
			}
			while (planetOutpost.getMedicalItems().size() < 4) {
				int randomNum = ThreadLocalRandom.current().nextInt(0, gameMedicalItems.size());
				planetOutpost.getMedicalItems().add(gameMedicalItems.get(randomNum));
			}
		}
	}

	/**
	 * Introduces the game situation.
	 * 
	 * @return A string message of the game situation.
	 */
	public String introductionText() {
		String text = "Your crew is lost in space in an unknown galaxy. "
				+ "Your spaceship's lightspeed engines are broken and scattered throughout the surrounding planets. "
				+ "You will need to find the missing engine parts of your spaceship so that you can repair it and travel back to Earth."
				+ " \r\n\r\nEach day you may perform crew member actions. "
				+ "Each crew member has two actions that can be used.\n\n"
				+ "Use the actions to help you search for the parts. " + "Each planet only has one engine part.";
		return text;
	}

	/**
	 * Checks if the game is over by checking if any of the conditions for game over
	 * are met.
	 * 
	 * @return true if any of the conditions are met, false otherwise.
	 */
	public boolean gameOver() {
		if (currentDay > gameDuration || ship.getPartsNeeded() == ship.getPartsFound() || ship.isDestroyed()
				|| crew.getCrewMembers().size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Creates crew members personalized by the player.
	 * 
	 * @param member A CrewMember object.
	 * @return A null CrewMember object.
	 */
	public CrewMember createCrewMember(CrewMember member) {
		switch (member.getType()) {
		case "Engineer":
			return new Engineer(member.getName(), member.getImage());
		case "Health Nut":
			return new HealthNut(member.getName(), member.getImage());
		case "Nibbler":
			return new Nibbler(member.getName(), member.getImage());
		case "Night Owl":
			return new NightOwl(member.getName(), member.getImage());
		case "Explorer":
			return new Explorer(member.getName(), member.getImage());
		case "Regular":
			return new Regular(member.getName(), member.getImage());
		}
		return null;
	}

	/**
	 * Moves on to the next day.
	 * 
	 * @return A string message of currently infected crew members and the event
	 *         occurred.
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
	 * Checks the crew members and see which are infected.
	 * 
	 * @return A string message of the infected crew members' updated health levels
	 *         or if they have died.
	 */
	public String checkInfectedCrewMembers() {
		String returnString = "";
		ArrayList<CrewMember> deadCrewMembers = new ArrayList<CrewMember>();
		for (CrewMember member : crew.getCrewMembers()) {
			if (member.isInfected()) {
				member.decreaseHealth(20);
				;
				if (member.isDead()) {
					returnString += member.getName()
							+ " has died to the space plague and has been removed from the crew.\n";
					deadCrewMembers.add(member);
				} else {
					returnString += member.getName() + " will lose 20 health each day until they get cured.\n";
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
	 * 
	 * @return An int of the final score.
	 */
	public int calculateFinalScore() {
		int score = 0;
		for (CrewMember member : crew.getCrewMembers()) {
			score += member.getHealth();
			score += member.getMaxFatigue() - member.getFatigue();
			score += member.getMaxHunger() - member.getHunger();
			score += member.getActionsLeft() * 50;
		}
		score += ship.getShieldLevel();
		if (ship.getPartsFound() == ship.getPartsNeeded()) {
			score = score * 2;
			if (score < 0) {
				score = 0;
			}
		}
		return score;
	}

	/**
	 * Checks if the game is over by checking if any of the game over conditions are
	 * met.
	 * 
	 * @return A string message describing why the game is over.
	 */
	public String gameOverMessage() {
		if (ship.isDestroyed()) {
			return "The asteroid hits and your ship is torn apart.";
		} else if (ship.getPartsFound() >= ship.getPartsNeeded()) {
			return "Your crew have found the necessary engine pieces and they returned home.";
		} else if (currentDay >= gameDuration) {
			return "The days have passed and you have failed to find the required parts to return home.";
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

	public ArrayList<MedicalItem> getGameMedicalItems() {
		return gameMedicalItems;
	}

	public void setGameMedicalItems(ArrayList<MedicalItem> medItems) {
		this.gameMedicalItems = medItems;
	}

	public ArrayList<FoodItem> getGameFoodItems() {
		return gameFoodItems;
	}

	public void setGameFoodItems(ArrayList<FoodItem> foodItems) {
		this.gameFoodItems = foodItems;
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
