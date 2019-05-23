package main;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Represents a crew member.
 * 
 * @author Yu Duan
 * @author Joyce Cheah
 */
public class CrewMember {
	private String name;
	private String type;
	private String status;
	private String image;
	private int health;
	private int maxHealth;
	private int hunger;
	private int maxHunger;
	private int fatigue;
	private int maxFatigue;
	private int actionsLeft;
	private int maxActions;
	private boolean infected;
	private boolean dead;
	private int repairFatigueCost;
	private int repairHungerCost;
	private int pilotFatigueCost;
	private int pilotHungerCost;
	private int searchFatigueCost;
	private int searchHungerCost;

	/**
	 * Creates a crew member with the given values. This constructor is only used in
	 * the CreateCrewWindow.
	 * 
	 * @param name  A string name of the crew member.
	 * @param type  A string type of the crew member.
	 * @param image A string image of the crew member.
	 */
	public CrewMember(String name, String type, String image) {
		this.name = name;
		this.type = type;
		this.status = "Normal";
		this.health = 100;
		this.maxHealth = 100;
		this.hunger = 0;
		this.maxHunger = 100;
		this.fatigue = 0;
		this.maxFatigue = 100;
		this.actionsLeft = 2;
		this.maxActions = 2;
		this.infected = false;
		this.dead = false;
		this.repairFatigueCost = 10;
		this.repairHungerCost = 10;
		this.pilotFatigueCost = 10;
		this.pilotHungerCost = 10;
		this.searchFatigueCost = 20;
		this.searchHungerCost = 20;
		this.image = image;

	}

	/**
	 * Creates a crew member with the given values.
	 * 
	 * @param name       A string name of the crew member.
	 * @param type       A string type of the crew member.
	 * @param image      A string image of the crew member.
	 * @param maxHealth  An int of the maximum health level.
	 * @param maxHunger  An int of the maximum hunger level.
	 * @param maxFatigue An int of the maximum fatigue level.
	 * @param maxActions An int of the maximum actions allowed.
	 */
	public CrewMember(String name, String type, String image, int maxHealth, int maxHunger, int maxFatigue,
			int maxActions) {
		this.name = name;
		this.type = type;
		this.status = "Normal";
		this.maxHealth = maxHealth;
		this.health = maxHealth;
		this.maxHunger = maxHunger;
		this.hunger = 0;
		this.maxFatigue = maxFatigue;
		this.fatigue = 0;
		this.maxActions = maxActions;
		this.actionsLeft = maxActions;
		this.infected = false;
		this.dead = false;
		this.repairFatigueCost = 10;
		this.repairHungerCost = 10;
		this.pilotFatigueCost = 10;
		this.pilotHungerCost = 10;
		this.searchFatigueCost = 20;
		this.searchHungerCost = 20;
		this.image = image;
	}

	/**
	 * Creates a crew member with the given values.
	 * 
	 * @param name              A string name of the crew member.
	 * @param type              A string type of the crew member.
	 * @param image             A string image of the crew member.
	 * @param maxHealth         An int of the maximum health level.
	 * @param maxHunger         An int of the maximum hunger level.
	 * @param maxFatigue        An int of the maximum fatigue level.
	 * @param maxActions        An int of the maximum actions allowed.
	 * @param repairFatigueCost An int of the fatigue cost when the crew member
	 *                          repairs the ship shields.
	 * @param repairHungerCost  An int of the hunger cost when the crew member
	 *                          repairs the ship shields.
	 * @param pilotFatigueCost  An int of the fatigue cost when the crew member
	 *                          pilots the ship.
	 * @param pilotHungerCost   An int of the hunger cost when the crew member
	 *                          pilots the ship.
	 * @param searchFatigueCost An int of the fatigue cost when the crew member
	 *                          searches the planet.
	 * @param searchHungerCost  An int of the hunger cost when the crew member
	 *                          searches the planet.
	 */
	public CrewMember(String name, String type, String image, int maxHealth, int maxHunger, int maxFatigue,
			int maxActions, int repairFatigueCost, int repairHungerCost, int pilotFatigueCost, int pilotHungerCost,
			int searchFatigueCost, int searchHungerCost) {
		this.name = name;
		this.type = type;
		this.status = "Normal";
		this.maxHealth = maxHealth;
		this.health = maxHealth;
		this.maxHunger = maxHunger;
		this.hunger = 0;
		this.maxFatigue = maxFatigue;
		this.fatigue = 0;
		this.maxActions = maxActions;
		this.actionsLeft = maxActions;
		this.infected = false;
		this.dead = false;
		this.repairFatigueCost = repairFatigueCost;
		this.repairHungerCost = repairHungerCost;
		this.pilotFatigueCost = pilotFatigueCost;
		this.pilotHungerCost = pilotHungerCost;
		this.searchFatigueCost = searchFatigueCost;
		this.searchHungerCost = searchHungerCost;
		this.image = image;
	}

	/**
	 * Checks if the crew member has enough attributes to pilot.
	 * 
	 * @return true if the crew member has enough attributes to pilot, false
	 *         otherwise.
	 */
	public boolean canPilot() {
		return (fatigue + pilotFatigueCost <= maxFatigue && hunger + pilotHungerCost <= maxHunger && actionsLeft > 0);
	}

	/**
	 * Checks if the crew member is available to perform actions.
	 * 
	 * @return true if the crew member has actions left, false otherwise.
	 */
	public boolean isAvailable() {
		return actionsLeft > 0;
	}

	/**
	 * Consumes a food item to decrease hunger level.
	 * 
	 * @param item A FoodItem object.
	 * @param crew A Crew object.
	 * @return A string message of the crew member's updated hunger level.
	 */
	public String eat(FoodItem item, Crew crew) {
		decreaseHunger(item.getRestoreHungerAmount());
		crew.getFoodItems().remove(item);
		actionsLeft -= 1;
		return name + " now has " + hunger + "/" + maxHunger + " hunger.";
	}

	/**
	 * Applies medical items to increase health level.
	 * 
	 * @param item A MedicalItem object.
	 * @param crew A Crew object.
	 * @return A string message of the crew member's updated status or health level.
	 */
	public String useMedicalItem(MedicalItem item, Crew crew) {
		String message = "";
		increaseHealth(item.getRestoreHealthAmount());
		message += name + " now has " + health + "/" + maxHealth + " health.\n";
		if (item.isRemovePlague()) {
			infected = false;
			status = "Normal";
			message += name + " has been cured of space plague.";
		}
		crew.getMedicalItems().remove(item);
		actionsLeft -= 1;
		return message;
	}

	/**
	 * Performs the sleep action to decrease fatigue level.
	 * 
	 * @return A string message of the crew member's updated fatigue level.
	 */
	public String sleep() {
		int previousFatigue = fatigue;
		decreaseFatigue(30);
		int fatigueRecovered = previousFatigue - fatigue;
		actionsLeft -= 1;
		return name + " has recovered " + fatigueRecovered + " fatigue and now has " + fatigue + "/" + maxFatigue
				+ " fatigue.";
	}

	/**
	 * Repairs the ship to increase shield level, if the conditions are met for the
	 * crew member.
	 * 
	 * @param ship A Ship object.
	 * @return A string message that the crew member is unable to repair ship, or a
	 *         string of the ship's updated shield level.
	 */
	public String repair(Ship ship) {
		String returnString = "";
		if (fatigue + repairFatigueCost > maxFatigue) {
			returnString += name + " is too tired to repair the ship.";
		}

		if (hunger + repairHungerCost > maxHunger) {
			returnString += name + " is too hungry to repair the ship.\n";
		}

		if (fatigue + repairFatigueCost <= maxFatigue && hunger + repairHungerCost <= maxHunger) {
			ship.increaseShieldLevel(10);
			actionsLeft -= 1;
			increaseFatigue(repairFatigueCost);
			increaseHunger(repairHungerCost);
			returnString += ship.getName() + "'s shields is at " + ship.getShieldLevel() + "/"
					+ ship.getMaxShieldLevel();
		}
		return returnString;
	}

	/**
	 * Pilots the ship to a new planet with another chosen crew member, if the
	 * conditions are met for both crew members.
	 * 
	 * @param planet A Planet object that is the destination planet.
	 * @param other  A CrewMember object that is the other pilot.
	 * @param crew   A Crew object that is the player's crew.
	 * @return A string message saying if an event happens or not.
	 */
	public String pilot(Planet planet, CrewMember other, Crew crew) {
		increaseFatigue(pilotFatigueCost);
		other.increaseFatigue(other.pilotFatigueCost);
		increaseHunger(pilotHungerCost);
		other.increaseHunger(other.pilotHungerCost);
		actionsLeft -= 1;
		other.actionsLeft -= 1;
		crew.setCurrentLocation(planet);
		String message = RandomEvent.occurPlanet(crew);
		return message;
	}

	/**
	 * Searches the planet for items and the ship piece, if the conditions of the
	 * crew member are met.
	 * 
	 * @param medicalItems An ArrayList of medical items.
	 * @param foodItems    An ArrayList of food items.
	 * @param crew         A Crew object.
	 * @return A string message of what was found.
	 */
	public String search(ArrayList<MedicalItem> medicalItems, ArrayList<FoodItem> foodItems, Crew crew) {
		String message = "";
		if (fatigue + searchFatigueCost > maxFatigue) {
			message += name + " is too tired to search the planet.\n";
		}
		if (hunger + searchHungerCost > maxHunger) {
			message += name + " is too hungry to search the planet.\n";
		}
		if (fatigue + searchFatigueCost <= maxFatigue && hunger + searchHungerCost <= maxHunger) {
			int randomNum = ThreadLocalRandom.current().nextInt(0, 100);
			if (randomNum >= 0 && randomNum < 30 && crew.getCurrentLocation().isPieceDetected()) {
				message += name + " has found a engine piece!\n";
				crew.getShip().foundPiece();
				message += "Pieces found: " + crew.getShip().getPiecesFound() + "/" + crew.getShip().getPiecesNeeded()
						+ ".";
				crew.getCurrentLocation().setPieceDetected(false);
			} else if (randomNum >= 30 && randomNum < 50) {
				randomNum = ThreadLocalRandom.current().nextInt(0, medicalItems.size());
				crew.getMedicalItems().add(medicalItems.get(randomNum));
				message += name + " has found a medical item " + medicalItems.get(randomNum) + "!\n";
			} else if (randomNum >= 50 && randomNum < 70) {
				randomNum = ThreadLocalRandom.current().nextInt(0, foodItems.size());
				crew.getFoodItems().add(foodItems.get(randomNum));
				message += name + " has found a food item " + foodItems.get(randomNum) + "!\n";
			} else if (randomNum >= 70 && randomNum < 90) {
				int amount = 50;
				crew.increaseMoney(amount);
				message += name + "has found " + amount + " Coins.\n";
			} else {
				message += name + " has found nothing.\n";
			}
			increaseFatigue(searchFatigueCost);
			increaseHunger(searchHungerCost);
			actionsLeft -= 1;
		}
		return message;
	}

	/**
	 * Creates a description and special abilities of the crew member type.
	 * 
	 * @return A string of the crew member type description.
	 */
	public String description() {
		String returnString = "";
		switch (type) {
		case "Engineer":
			returnString = "Engineers are masters at building, designing and maintaining machines. "
					+ "The Engineer is more skilled at reparining the spaceship.";
			break;
		case "Health Nut":
			returnString = "Health Nut has a very healthy lifestyle. "
					+ "Health Nut's health level increases by more when consuming medical items";
			break;
		case "Nibbler":
			returnString = "Nibbler does not eat a lot. "
					+ "Nibbler's hunger level decreases by more when consuming food items";
			break;
		case "Night Owl":
			returnString = "Night Owl does not like sleeping. "
					+ "Night Owl's fatigue level increases by a slower rate when repairing ships, searching on planets, and piloting the ship.";
			break;
		case "Explorer":
			returnString = "Explorers are born to go where no one has been. "
					+ "Explorer's fatigue and hunger level increase by a slower rate when piloting the ship, and searching the planet.";
			break;
		case "Regular":
			returnString = "Regular does not have any special powers. "
					+ "Regular has higher hunger and fatigue tolerance levels.";
			break;
		}
		return returnString;
	}

	/**
	 * Increase the crew member's health by the given amount. The crew member's health cannot go above their maxHealth.
	 * 
	 * @param amount	An int amount.
	 */
	public void increaseHealth(int amount) {
		health += amount;
		if (health > maxHealth) {
			health = maxHealth;
		}
	}
	
	/**
	 * Decrease the crew member's health by the given amount. The crew member is dead if the health goes below 0, and then the health is set to 0.
	 * 
	 * @param amount	An int amount.
	 */
	public void decreaseHealth(int amount) {
		health -= amount;
		if (health <= 0) {
			health = 0;
			dead = true;
		}
	}
	/**
	 * Increase the crew member's hunger by the given amount. The crew member's hunger cannot go above their maxHunger.
	 * 
	 * @param amount	An int amount.
	 */
	public void increaseHunger(int amount) {
		hunger += amount;
		if (hunger > maxHunger) {
			hunger = maxHunger;
		}
	}
	/**
	 * Decrease the crew member's hunger by the given amount. The crew member's hunger cannot go below 0.
	 * 
	 * @param amount	An int amount.
	 */
	public void decreaseHunger(int amount) {
		hunger -= amount;
		if (hunger < 0) {
			hunger = 0;
		}
	}
	
	/**
	 * Increase the crew member's fatigue by the given amount. The crew member's fatigue cannot go above their maxFatigue.
	 * 
	 * @param amount	An int amount.
	 */
	public void increaseFatigue(int amount) {
		fatigue += amount;
		if (fatigue > maxFatigue) {
			fatigue = maxFatigue;
		}
	}
	/**
	 * Decrease the crew member's fatigue by the given amount. The crew member's fatigue cannot go below 0.
	 * 
	 * @param amount	An int amount.
	 */
	public void decreaseFatigue(int amount) {
		fatigue -= amount;
		if (fatigue < 0) {
			fatigue = 0;
		}
	}

	/**
	 * Creates a string representation of the crew member.
	 * 
	 * @return A string representation of the crew member.
	 */
	public String toString() {
		return name;
	}

	/**
	 * Gets the name of the crew member.
	 * 
	 * @return A string name of the crew member.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the crew member.
	 * 
	 * @param name A string name of the crew member.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the type of the crew member.
	 * 
	 * @return A string type of the crew member.
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the type of the crew member.
	 * 
	 * @param type A string type of the crew member.
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Gets the amount of actions left.
	 * 
	 * @return An int of actions left.
	 */
	public int getActionsLeft() {
		return actionsLeft;
	}

	/**
	 * Sets the amount of actions left.
	 * 
	 * @param actionsLeft An int of the actions left.
	 */
	public void setActionsLeft(int actionsLeft) {
		this.actionsLeft = actionsLeft;
	}

	/**
	 * Gets the health level.
	 * 
	 * @return An int of the health level.
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * Sets the health level.
	 * 
	 * @param health An int of the health level.
	 */
	public void setHealth(int health) {
		this.health = health;
	}

	/**
	 * Gets the maximum health level.
	 * 
	 * @return An int of the maximum health level.
	 */
	public int getMaxHealth() {
		return maxHealth;
	}

	/**
	 * Sets the maximum health level.
	 * 
	 * @param maxHealth An int of the maximum health level.
	 */
	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	/**
	 * Gets the hunger level.
	 * 
	 * @return An int of the hunger level.
	 */
	public int getHunger() {
		return hunger;
	}

	/**
	 * Sets the hunger level.
	 * 
	 * @param hunger An int of the hunger level.
	 */
	public void setHunger(int hunger) {
		this.hunger = hunger;
	}

	/**
	 * Gets the maximum hunger level.
	 * 
	 * @return An int of the maximum hunger level.
	 */
	public int getMaxHunger() {
		return maxHunger;
	}

	/**
	 * Sets the maximum hunger level.
	 * 
	 * @param maxHunger An int of the maximum hunger level.
	 */
	public void setMaxHunger(int maxHunger) {
		this.maxHunger = maxHunger;
	}

	/**
	 * Gets the fatigue level.
	 * 
	 * @return An int of the fatigue level.
	 */
	public int getFatigue() {
		return fatigue;
	}

	/**
	 * Sets the fatigue level.
	 * 
	 * @param fatigue An int of the fatigue level.
	 */
	public void setFatigue(int fatigue) {
		this.fatigue = fatigue;
	}

	/**
	 * Gets the maximum fatigue level.
	 * 
	 * @return An int of the maximum fatigue level.
	 */
	public int getMaxFatigue() {
		return maxFatigue;
	}

	/**
	 * Sets the maximum fatigue level.
	 * 
	 * @param maxFatigue An int of the maximum fatigue level.
	 */
	public void setMaxFatigue(int maxFatigue) {
		this.maxFatigue = maxFatigue;
	}

	/**
	 * Gets the maximum actions available.
	 * 
	 * @return An int of the maximum actions available.
	 */
	public int getMaxActions() {
		return maxActions;
	}

	/**
	 * Sets the maximum actions available.
	 * 
	 * @param maxActions An int of the maximum actions available.
	 */
	public void setMaxActions(int maxActions) {
		this.maxActions = maxActions;
	}

	/**
	 * Checks if the crew member is infected by space plague.
	 * 
	 * @return true if the crew member is infected, false otherwise.
	 */
	public boolean isInfected() {
		return infected;
	}

	/**
	 * Sets the crew member as infected by space plague.
	 * 
	 * @param infected A boolean expression on whether crew member is infected.
	 */
	public void setInfected(boolean infected) {
		this.infected = infected;
	}

	/**
	 * Checks if the crew member is dead.
	 * 
	 * @return true if the crew member is dead, false otherwise.
	 */
	public boolean isDead() {
		return dead;
	}

	/**
	 * Sets the crew member to be dead.
	 * 
	 * @param dead A boolean expression on whether the crew member is dead.
	 */
	public void setDead(boolean dead) {
		this.dead = dead;
	}

	/**
	 * Gets the status of the crew member.
	 * 
	 * @return A string status of the crew member.
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status of the crew member.
	 * 
	 * @param status The string status of the crew member.
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Gets the fatigue cost of repairing the ship.
	 * 
	 * @return An int of the fatigue cost of repairing the ship.
	 */
	public int getRepairFatigueCost() {
		return repairFatigueCost;
	}

	/**
	 * Sets the fatigue cost of repairing the ship.
	 * 
	 * @param repairFatigueCost An int of the fatigue cost of repairing the ship.
	 */
	public void setRepairFatigueCost(int repairFatigueCost) {
		this.repairFatigueCost = repairFatigueCost;
	}

	/**
	 * Gets the hunger cost of repairing the ship.
	 * 
	 * @return An int of the hunger cost of repairing the ship.
	 */
	public int getRepairHungerCost() {
		return repairHungerCost;
	}

	/**
	 * Sets the hunger cost of repairing the ship.
	 * 
	 * @param repairHungerCost An int of the hunger cost of repairing the ship.
	 */
	public void setRepairHungerCost(int repairHungerCost) {
		this.repairHungerCost = repairHungerCost;
	}

	/**
	 * Gets the fatigue cost of piloting the ship.
	 * 
	 * @return An int of the fatigue cost of piloting the ship.
	 */
	public int getPilotFatigueCost() {
		return pilotFatigueCost;
	}

	/**
	 * Sets the fatigue cost of piloting the ship.
	 * 
	 * @param pilotFatigueCost An int of the fatigue cost of piloting the ship.
	 */
	public void setPilotFatigueCost(int pilotFatigueCost) {
		this.pilotFatigueCost = pilotFatigueCost;
	}

	/**
	 * Gets the hunger cost of piloting the ship.
	 * 
	 * @return An int of the hunger cost of piloting the ship.
	 */
	public int getPilotHungerCost() {
		return pilotHungerCost;
	}

	/**
	 * Sets the hunger cost of piloting the ship.
	 * 
	 * @param pilotHungerCost An int of the hunger cost of piloting the ship.
	 */
	public void setPilotHungerCost(int pilotHungerCost) {
		this.pilotHungerCost = pilotHungerCost;
	}

	/**
	 * Gets the fatigue cost of searching the planet.
	 * 
	 * @return An int of the fatigue cost of searching the planet.
	 */
	public int getSearchFatigueCost() {
		return searchFatigueCost;
	}

	/**
	 * Sets the fatigue cost of searching the planet.
	 * 
	 * @param searchFatigueCost An int of the fatigue cost of searching the planet.
	 */
	public void setSearchFatigueCost(int searchFatigueCost) {
		this.searchFatigueCost = searchFatigueCost;
	}

	/**
	 * Gets the hunger cost of searching the planet.
	 * 
	 * @return An int of the hunger cost of searching the planet.
	 */
	public int getSearchHungerCost() {
		return searchHungerCost;
	}

	/**
	 * Sets the hunger cost of searching the planet.
	 * 
	 * @param searchHungerCost An int of the hunger cost of searching the planet.
	 */
	public void setSearchHungerCost(int searchHungerCost) {
		this.searchHungerCost = searchHungerCost;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
