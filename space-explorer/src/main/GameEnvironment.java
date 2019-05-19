package main;

import views.*;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

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

	public void launchSelectPilotWindow() {
		SelectPilotWindow selectPilotWindow = new SelectPilotWindow(this);
	}

	public void closeSelectPilotWindow(SelectPilotWindow selectPilotWindow) {
		selectPilotWindow.closeWindow();
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
		game.initialize();
		game.launchStartWindow();

	}

	public void initialize() {
		initCrewMemberTypes();
		initMedItems();
		initFoodItems();
		initPlanets();
		generateOutpostsItems();
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
		for (String name : planetNames) {
			planets.add(new Planet(name));
		}
	}

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

	public String introductionText() {
		String text = "Your crew is lost in space in a unknown galaxy. Your spaceship's lightspeed engines are borken and scattered throughout the surrounding planets. You will need to find the missing pieces of your spaceship so that you can repair it and travel back to Earth. \r\n\r\nEach day you may perform crew member actions. Each crew member has two actions that can be used. ";
		return text;
	}
	
	

	public boolean gameOver() {
		if (currentDay > gameDuration || ship.getPiecesNeeded() == ship.getPiecesFound() || ship.isDestroyed()
				|| crew.getCrewMembers().size() == 0) {
			return true;
		} else {
			return false;
		}
	}
	
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

	public String nextDay() {
		currentDay++;
		String returnString = "";
		if (!gameOver()) {
			for (CrewMember member : crew.getCrewMembers()) {
				member.setActionsLeft(member.getMaxActions());
			}
			returnString += checkInfectedCrewMembers();
			generateOutpostsItems();
			
			returnString += RandomEvent.occurDay(crew);
		}
		return returnString;
	}
	
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
					returnString += member.getName() + " now has " + member.getHealth() + "/"
							+ member.getMaxHealth() + " health.\n";
				}
			}
		}
		for (CrewMember deadMember : deadCrewMembers) {
			crew.getCrewMembers().remove(deadMember);
		}
		return returnString;
	}

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
