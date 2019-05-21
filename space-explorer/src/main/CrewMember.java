package main;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

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
	
	public CrewMember(String name, String type, String image, int maxHealth, int maxHunger, int maxFatigue, int maxActions) {
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
	 * Creates a crew member.
	 * @param name    A string name of the crew member.
	 * @param type    A string type of the crew member.
	 * @param maxHealth An int number of the maximum health level.
	 * @param maxHunger An int number of the maximum hunger level.
	 * @param maxFatigue An int number of the maximum fatigue level.
	 * @param maxActions An int number of the maximum actions.
	 */
	public CrewMember(String name, String type, String image, int maxHealth, int maxHunger, int maxFatigue, int maxActions, 
			int repairFatigueCost, int repairHungerCost, int pilotFatigueCost, int pilotHungerCost, int searchFatigueCost, int searchHungerCost) {
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
	
	public boolean canPilot() {
		return (fatigue + pilotFatigueCost <= maxFatigue && hunger + pilotHungerCost <= maxHunger && actionsLeft > 0);
	}

	/**
	 * Checks if the crew member is available.
	 * @return true if the crew member has actions left, false otherwise.
	 */
	public boolean isAvailable() {
		return actionsLeft > 0;
	}
	
	
	/**
	 * Consumes food items.
	 * @param item   A FoodItem object.
	 * @param crew   A Crew object.
	 */
	public String eat(FoodItem item, Crew crew) {
		decreaseHunger(item.getRestoreHungerAmount());
		crew.getFoodItems().remove(item);
		actionsLeft -= 1;
		return name + " now has " + hunger + "/" + maxHunger  + " hunger.";
	}
	
	/**
	 * Applies medical items.
	 * @param item   A MedicalItem object.
	 * @param crew   A Crew object.
	 */
	public String useMedicalItem(MedicalItem item, Crew crew) {
		String returnString = "";
		increaseHealth(item.getRestoreHealthAmount());
		returnString += name + " now has " + health + "/" + maxHealth + " health.\n";
		if (item.isRemovePlague()) {
			infected = false;
			status = "Normal";
			returnString += name + " has been cured of space plague.";
		}
		crew.getMedicalItems().remove(item);
		actionsLeft -= 1;
		return returnString;
	}
	

	/**
	 * Lets crew members sleep.
	 */	
	public String sleep() {
		int previousFatigue = fatigue;
		decreaseFatigue(30);
		int fatigueRecovered = previousFatigue - fatigue;
		actionsLeft-=1;
		return name + " has recovered " + fatigueRecovered + " fatigue and now has " + fatigue + "/" + maxFatigue + " fatigue.";
	}
	
	/**
	 * Repairs the ship.
	 * @param ship   A Ship object.
	 */
	public String repair(Ship ship) {
		String returnString = "";
		if (fatigue + repairFatigueCost> maxFatigue) {
			returnString += name + " is too tired to repair the ship.";
		} 
		
		if (hunger + repairHungerCost > maxHunger) {
			returnString += name + " is too hungry to repair the ship.\n";
		}
		
		if (fatigue + repairFatigueCost  <= maxFatigue && hunger + repairHungerCost <= maxHunger) {
			ship.increaseShieldLevel(10);
			actionsLeft-=1;
			increaseFatigue(repairFatigueCost);
			increaseHunger(repairHungerCost);
			returnString += ship.getName() +"'s shields is at " + ship.getShieldLevel() + "/" + ship.getMaxShieldLevel();
		}
		return returnString;
	}
	
	/**
	 * Pilots the ship with another chosen crew member.
	 * @param planet   A Planet object.
	 * @param other    A CrewMember object.
	 * @param crew     A Crew object.
	 */
	public String pilot(Planet planet, CrewMember other, Crew crew) {
		String returnString = "";
		if (fatigue + pilotFatigueCost> maxFatigue) {
			returnString += name + " is too tired to pilot the ship.\n";
		} 
		if (hunger + pilotHungerCost > maxHunger) {
			returnString += name + " is too hungry to pilot the ship.\n";
		}
		if (other.fatigue + pilotFatigueCost > other.maxFatigue) {
			returnString += other.name + " is too tired to pilot the ship.\n";
		} 
		if (other.hunger + other.pilotHungerCost > other.maxHunger) {
			returnString += other.name + " is too hungry to pilot the ship.\n";
		}
		if (fatigue <= maxFatigue - pilotFatigueCost && other.fatigue <= other.maxFatigue - pilotFatigueCost 
				&& hunger <= maxHunger - pilotHungerCost && other.hunger <= other.maxHunger - other.pilotHungerCost) {
			increaseFatigue(pilotFatigueCost);
			other.increaseFatigue(other.pilotFatigueCost);
			increaseHunger(pilotHungerCost);
			other.increaseHunger(other.pilotHungerCost);
			actionsLeft -= 1;
			other.actionsLeft -=1;
			crew.setCurrentLocation(planet);
			return RandomEvent.occurPlanet(crew);
		}
		return returnString;
	}
	
	/**
	 * Searches the planet for items.
	 * @param medicalItems   An ArrayList of medical items.
	 * @param foodItems      An ArrayList of food items.
	 * @param crew           A Crew object.
	 * @param ship           A Ship object.
	 * 
	 */
	public String search(ArrayList<MedicalItem> medicalItems, ArrayList<FoodItem> foodItems, Crew crew) {
		String returnString = "";
		if (fatigue + searchFatigueCost  > maxFatigue) {
			returnString += name + " is too tired to search the planet.\n";
		}
		if (hunger + searchHungerCost > maxHunger) {
			returnString += name + " is too hungry to search the planet.\n";
		}
		if (fatigue + searchFatigueCost  <= maxFatigue && hunger + searchHungerCost <= maxHunger) {
			int randomNum = ThreadLocalRandom.current().nextInt(0, 100);
			if (randomNum >= 0 && randomNum < 20 && crew.getCurrentLocation().isPieceDetected()) {
				returnString += name + " has found a engine piece!\n";
				crew.getShip().foundPiece();
				returnString += "Pieces found: " + crew.getShip().getPiecesFound() + "/" + crew.getShip().getPiecesNeeded() + ".";
				crew.getCurrentLocation().setPieceDetected(false);
			} else if (randomNum >= 20 && randomNum < 40) {
				randomNum = ThreadLocalRandom.current().nextInt(0, medicalItems.size());
				crew.getMedicalItems().add(medicalItems.get(randomNum));
				returnString += name + " has found a medical item " + medicalItems.get(randomNum) + "!\n";
			} else if (randomNum >= 40 && randomNum < 60) {
				randomNum = ThreadLocalRandom.current().nextInt(0, foodItems.size());
				crew.getFoodItems().add(foodItems.get(randomNum));
				returnString += name + " has found a food item " + foodItems.get(randomNum) + "!\n";
			} else if (randomNum >= 60 && randomNum < 80) {
				int amount = 50;
				crew.increaseMoney(amount);
				returnString += name + "has found " + amount + " Coins.\n";
			} else {
				returnString += name + " has found nothing.\n";
			}
			increaseFatigue(searchFatigueCost);
			increaseHunger(searchHungerCost);
			actionsLeft -= 1;
		}
		return returnString;
	}
	
	public String description() {
		String returnString = "";
		switch(type) {
		case "Engineer" :
			returnString = "Engineers are masters at building, designing and maintaining machines. "
					+ "The Engineer is more skilled at reparining the spaceship.";
			break;
		case "Health Nut" :
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
	
	public void increaseHealth(int amount) {
		health += amount;
		if (health > maxHealth) {
			health = maxHealth;
		}
	}
	
	public void decreaseHealth(int amount) {
		health -= amount;
		if (health <= 0) {
			health = 0;
			dead = true; 
		}
	}
	
	public void increaseHunger(int amount) {
		hunger += amount;
		if (hunger > maxHunger) {
			hunger = maxHunger;
		}
	}
	
	public void decreaseHunger(int amount) {
		hunger -= amount;
		if (hunger < 0) {
			hunger = 0;
		}
	}
	
	public void increaseFatigue(int amount) {
		fatigue += amount;
		if (fatigue > maxFatigue) {
			fatigue = maxFatigue;
		}
	}
	
	public void decreaseFatigue(int amount) {
		fatigue -= amount;
		if (fatigue < 0) {
			fatigue = 0;
		}
	}
	
	
	/**
	 * Creates a string representation of the crew member.
	 * @return A string representation of the crew member.
	 */
	public String toString() {
		return name;
	}
	
	/**
	 * Gets the name of the crew member.
	 * @return the name of the crew member.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the crew member.
	 * @param name   A string name of the crew member.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the type of the crew member.
	 * @return the type of the crew member.
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the type of the crew member.
	 * @param type   A string type of the crew member.
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Gets the amount of actions left.
	 * @return the int number of actions left.
	 */
	public int getActionsLeft() {
		return actionsLeft;
	}
	
	/**
	 * Sets the amount of actions left.
	 * @param actionsLeft   An int number of the actions left.
	 */
	public void setActionsLeft(int actionsLeft) {
		this.actionsLeft = actionsLeft;
	}

	/**
	 * Gets the health level.
	 * @return health level.
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * Sets the health level.
	 * @param health  An int of the health level.  
	 */
	public void setHealth(int health) {
		this.health = health;
	}

	/**
	 * Gets the maximum health level.
	 * @return the maximum health level.
	 */
	public int getMaxHealth() {
		return maxHealth;
	}

	/**
	 * Sets the maximum health level.
	 * @param maxHealth   An int of the maximum health level.
	 */
	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	/**
	 * Gets the hunger level.
	 * @return the hunger level.
	 */
	public int getHunger() {
		return hunger;
	}

	/**
	 * Sets the hunger level.
	 * @param hunger   An int of the hunger level.
	 */
	public void setHunger(int hunger) {
		this.hunger = hunger;
	}

	/**
	 * Gets the maximum hunger level.
	 * @return the maximum hunger level.
	 */
	public int getMaxHunger() {
		return maxHunger;
	}

	/**
	 * Sets the maximum hunger level.
	 * @param maxHunger   An int of the maximum hunger level.
	 */
	public void setMaxHunger(int maxHunger) {
		this.maxHunger = maxHunger;
	}

	/**
	 * Gets the fatigue level.
	 * @return the fatigue level.
	 */
	public int getFatigue() {
		return fatigue;
	}

	/**
	 * Sets the fatigue level.
	 * @param fatigue   An int of the fatigue level.
	 */
	public void setFatigue(int fatigue) {
		this.fatigue = fatigue;
	}

	/**
	 * Gets the maximum fatigue level.
	 * @return the maximum fatigue level.
	 */
	public int getMaxFatigue() {
		return maxFatigue;
	}

	/**
	 * Sets the maximum fatigue level.
	 * @param maxFatigue   An int of the maximum fatigue level.
	 */
	public void setMaxFatigue(int maxFatigue) {
		this.maxFatigue = maxFatigue;
	}

	/**
	 * Gets the maximum actions available.
	 * @return the maximum actions available.
	 */
	public int getMaxActions() {
		return maxActions;
	}

	/**
	 * Sets the maximum actions available.
	 * @param maxActions   An int of the maximum actions available.
	 */
	public void setMaxActions(int maxActions) {
		this.maxActions = maxActions;
	}
	
	/**
	 * Checks if the crew member is infected by space plague.
	 * @return true if the crew member is infected, false otherwise.
	 */
	public boolean isInfected() {
		return infected;
	}
	
	/**
	 * Sets the crew member as infected by space plague.
	 * @param infected   A boolean expression on whether crew member is infected.
	 */
	public void setInfected(boolean infected) {
		this.infected = infected;
	}

	/**
	 * Checks if the crew member is dead.
	 * @return true if the crew member is dead, false otherwise.
	 */
	public boolean isDead() {
		return dead;
	}

	/**
	 * Sets the crew member to be dead.
	 * @param dead   A boolean expression on whether the crew member is dead.
	 */
	public void setDead(boolean dead) {
		this.dead = dead;
	}
	
	/**
	 * Gets the status of the crew member.
	 * @return the status of the crew member.
	 */
	public String getStatus() {
		return status;
	}
	
	/**
	 * Sets the status of the crew member.
	 * @param status   The status of the crew member.
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	public int getRepairFatigueCost() {
		return repairFatigueCost;
	}

	public void setRepairFatigueCost(int repairFatigueCost) {
		this.repairFatigueCost = repairFatigueCost;
	}

	public int getRepairHungerCost() {
		return repairHungerCost;
	}

	public void setRepairHungerCost(int repairHungerCost) {
		this.repairHungerCost = repairHungerCost;
	}

	public int getPilotFatigueCost() {
		return pilotFatigueCost;
	}

	public void setPilotFatigueCost(int pilotFatigueCost) {
		this.pilotFatigueCost = pilotFatigueCost;
	}

	public int getPilotHungerCost() {
		return pilotHungerCost;
	}

	public void setPilotHungerCost(int pilotHungerCost) {
		this.pilotHungerCost = pilotHungerCost;
	}

	public int getSearchFatigueCost() {
		return searchFatigueCost;
	}

	public void setSearchFatigueCost(int searchFatigueCost) {
		this.searchFatigueCost = searchFatigueCost;
	}

	public int getSearchHungerCost() {
		return searchHungerCost;
	}

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
