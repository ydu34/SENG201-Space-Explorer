package main;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class CrewMember {
	private String name;
	private String type;
	private String status = "Normal";
	private int health = 100;
	private int maxHealth = 100;
	private int hunger = 100;
	private int maxHunger = 100;
	private int fatigue = 0;
	private int maxFatigue = 100;
	private int actionsLeft = 2;
	private int maxActions = 2;
	private boolean infected = false;
	private boolean dead = false; 
	private int repairFatigueCost;
	private int repairHungerCost;
	private int pilotFatigueCost;
	private int pilotHungerCost;
	private int searchFatigueCost;
	private int searchHungerCost;
	
	
	
	public CrewMember(String name, String type) {
		this.name = name;
		this.type = type;
		this.status = "";
		this.maxHealth = 100;
		this.health = 100;
		this.maxHunger = 100;
		this.hunger = 0;
		this.maxFatigue = 100;
		this.fatigue = 0;
		this.maxActions = 2;
		this.actionsLeft = 2;
		this.infected = false;
		this.dead = false;
		this.repairFatigueCost = 10;
		this.repairHungerCost = 10;
		this.pilotFatigueCost = 10;
		this.pilotHungerCost = 10;	
		this.searchFatigueCost = 20;
		this.searchHungerCost = 20;
	}
	
	public CrewMember(String name, String type, String status, int maxHealth, int maxHunger, int maxFatigue, int maxActions) {
		this.name = name;
		this.type = type;
		this.status = status;
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
	public CrewMember(String name, String type, String status, int maxHealth, int maxHunger, int maxFatigue, int maxActions, 
			int repairFatigueCost, int repairHungerCost, int pilotFatigueCost, int pilotHungerCost, int searchFatigueCost, int searchHungerCost) {
		this.name = name;
		this.type = type;
		this.status = status;
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
	public void eat(FoodItem item, Crew crew) {
		hunger -= item.getRestoreHungerAmount();
		if (hunger < 0) {
			hunger = 0;
		}
		crew.getFoodItems().remove(item);
		actionsLeft -= 1;
		System.out.println(name + " now has " + hunger + ".");
	}
	
	/**
	 * Applies medical items.
	 * @param item   A MedicalItem object.
	 * @param crew   A Crew object.
	 */
	public void useMedicalItem(MedicalItem item, Crew crew) {
		health += item.getRestoreHealthAmount();
		if (health > maxHealth) {
			health = maxHealth;
		}
		System.out.println(name + " now has " + health + ".");
		if (item.isRemovePlague()) {
			infected = false;
			status = "Normal";
		}
		crew.getMedicalItems().remove(item);
		actionsLeft -= 1;
		
	}
	

	/**
	 * Lets crew members sleep.
	 */	
	public void sleep() {
		int previousFatigue = fatigue;
		fatigue -= 10;
		if (fatigue < 0) {
			fatigue = 0;
		}
		int fatigueRecovered = previousFatigue - fatigue;
		actionsLeft-=1;
		System.out.println(name + " has recovered " + fatigueRecovered + " fatigue and now has " + fatigue + " fatigue.");
	}
	
	/**
	 * Repairs the ship.
	 * @param ship   A Ship object.
	 */
	public void repair(Ship ship) {
		if (fatigue + repairFatigueCost> maxFatigue) {
			System.out.println(this.name + " is too tired to repair the ship.");
		} else {
			int shieldLevel = ship.getShieldLevel();
			int maxShieldLevel = ship.getMaxShieldLevel();
			shieldLevel += 10;
			if (shieldLevel > maxShieldLevel) {
				shieldLevel = maxShieldLevel;
			}
			actionsLeft-=1;
			fatigue += repairFatigueCost;
			System.out.println("The ship's shield is now " + shieldLevel + "/" +maxShieldLevel);
		}
	}
	
	/**
	 * Pilots the ship with another chosen crew member.
	 * @param planet   A Planet object.
	 * @param other    A CrewMember object.
	 * @param crew     A Crew object.
	 */
	public String pilot(Planet planet, CrewMember other, Crew crew) {
		if (fatigue + pilotFatigueCost> maxFatigue) {
			System.out.println(name + " is too tired to pilot the ship.");
		} 
		if (other.fatigue + pilotFatigueCost > other.maxFatigue) {
			System.out.println(other.name + " is too tired to pilot the ship.");
		} 
		if (fatigue <= maxFatigue - pilotFatigueCost && other.fatigue <= other.maxFatigue - pilotFatigueCost) {
			fatigue += pilotFatigueCost;
			other.fatigue += pilotFatigueCost;
			actionsLeft -= 1;
			other.actionsLeft -=1;
			crew.setCurrentLocation(planet);
			return RandomEvent.occurPlanet(crew);
		}
		return null;
	}
	
	/**
	 * Searches the planet for items.
	 * @param medicalItems   An ArrayList of medical items.
	 * @param foodItems      An ArrayList of food items.
	 * @param crew           A Crew object.
	 * @param ship           A Ship object.
	 * 
	 */
	public void search(ArrayList<MedicalItem> medicalItems, ArrayList<FoodItem> foodItems, Crew crew, Ship ship) {
		if (fatigue + searchFatigueCost  > maxFatigue) {
			System.out.println(name + " is too tired to search the planet.");
		}
		if (hunger + searchHungerCost > maxHunger) {
			System.out.println(name + " is too hungry to search the planet.");
		}
		if (fatigue + searchFatigueCost  <= maxFatigue && hunger + searchHungerCost <= maxHunger) {
			int randomNum = ThreadLocalRandom.current().nextInt(0, 100);
			if (randomNum >= 0 && randomNum < 20 && !crew.getCurrentLocation().isShipPieceFound()) {
				System.out.println(name + " has found a ship piece!");
				crew.getCurrentLocation().setShipPieceFound(true);
				ship.foundPiece();
			} else if (randomNum >= 20 && randomNum < 35) {
				randomNum = ThreadLocalRandom.current().nextInt(0, medicalItems.size());
				crew.getMedicalItems().add(medicalItems.get(randomNum));
				System.out.println(name + " has found a medical item " + medicalItems.get(randomNum) + "!");
			} else if (randomNum >= 35 && randomNum < 50) {
				randomNum = ThreadLocalRandom.current().nextInt(0, foodItems.size());
				crew.getFoodItems().add(foodItems.get(randomNum));
				System.out.println(name + " has found a food item " + foodItems.get(randomNum) + "!");
			} else if (randomNum >= 50 && randomNum < 65) {
				int amount = 50;
				crew.increaseMoney(amount);
				System.out.println(name + "has found " + amount + " Coins.");
			} else {
				System.out.println(name + " has found nothing.");
			}
			fatigue += searchFatigueCost;
			hunger += searchHungerCost;
			actionsLeft -= 1;
		}
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
					+ "Night Owl's fatigue level increases by a slower rate when repairing ships and searching on planets.";
			break;
		case "Protected":
			returnString = "Protected has a good immune system. "
					+ "Protected can not be infected by to space plague";
			break;
		case "Regular":
			returnString = "Regular does not have any special powers. "
					+ "Regular has higher hunger and fatigue tolerance levels.";
			break; 
		}
		return returnString;
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
		if (health <= 0) {
			dead = true; 
		}
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
	

	
}
