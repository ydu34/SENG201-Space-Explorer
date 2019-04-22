package main;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public abstract class CrewMember {
	private String name;
	private String type;
	private int health;
	private int maxHealth;
	private int hunger;
	private int maxHunger;
	private int fatigue;
	private int maxFatigue;
	private int actionsLeft;
	private int maxActions;
	private boolean isInfected = false;
	
	public CrewMember(String name, String type, int maxHealth, int maxHunger, int maxFatigue, int maxActions) {
		this.name = name;
		this.type = type;
		this.maxHealth = maxHealth;
		this.health = maxHealth;
		this.maxHunger = maxHunger;
		this.hunger = 0;
		this.maxFatigue = maxFatigue;
		this.fatigue = 0;
		this.maxActions = maxActions;
		this.actionsLeft = maxActions;
	}

	public boolean hasActionsLeft() {
		return actionsLeft > 0;
	}
	
	public void eat(FoodItem item, Crew crew) {
		hunger -= item.getRestoreHungerAmount();
		if (hunger < 0) {
			hunger = 0;
		}
		crew.getFoodItems().remove(item);
		actionsLeft -= 1;
		System.out.println(name + " now has " + hunger + ".");
	}
	
	public void useMedicalItem(MedicalItem item, Crew crew) {
		health += item.getRestoreHealthAmount();
		if (health > maxHealth) {
			health = maxHealth;
		}
		crew.getMedicalItems().remove(item);
		actionsLeft -= 1;
		System.out.println(name + " now has " + health + ".");
	}
	
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
	
	public void repair(Ship ship) {
		int shieldLevel = ship.getShieldLevel();
		int maxShieldLevel = ship.getMaxShieldLevel();
		shieldLevel += 10;
		if (shieldLevel > maxShieldLevel) {
			shieldLevel = maxShieldLevel;
		}
		actionsLeft-=1;
		fatigue += 10;
		System.out.println("The ship's shield is now " + shieldLevel + "/" +maxShieldLevel);
	}
	
	public void pilot(Planet planet, CrewMember other, Crew crew) {
		fatigue += 5;
		other.fatigue += 5;
		actionsLeft -= 1;
		other.actionsLeft -=1;
		crew.setCurrentLocation(planet);
		System.out.println("The crew is now on Planet " + crew.getCurrentLocation() + ".");
	}
	
	public void search(ArrayList<MedicalItem> medicalItems, ArrayList<FoodItem> foodItems, Crew crew, Ship ship) {
		int randomNum = ThreadLocalRandom.current().nextInt(0, 100);
		if (randomNum >= 0 && randomNum < 15 && !crew.getCurrentLocation().isShipPieceFound()) {
			System.out.println(name + " has found a ship piece!");
			crew.getCurrentLocation().setShipPieceFound(true);
			ship.foundPiece();
		} else if (randomNum >= 15 && randomNum < 35) {
			randomNum = ThreadLocalRandom.current().nextInt(0, medicalItems.size());
			crew.getMedicalItems().add(medicalItems.get(randomNum));
			System.out.println(name + " has found a medical item " + medicalItems.get(randomNum) + "!");
		} else if (randomNum >= 35 && randomNum < 55) {
			randomNum = ThreadLocalRandom.current().nextInt(0, foodItems.size());
			crew.getFoodItems().add(foodItems.get(randomNum));
			System.out.println(name + " has found a food item " + foodItems.get(randomNum) + "!");
		} else if (randomNum >= 55 && randomNum < 75) {
			int amount = 50;
			crew.increaseMoney(amount);
			System.out.println(name + "has found " + amount + "Coins.");
		} else {
			System.out.println(name + " has found nothing.");
		}
		fatigue += 20;
		hunger += 10;
		actionsLeft -= 1;
	}
	
	public String toString() {
		String returnString = 
				"Name: " + name + 
				"\nType: " + type +
				"\nHealth: " + health + "/" + maxHealth +
				"\nHunger: " + hunger + "/" + maxHunger + 
				"\nFatigue: " + fatigue + "/" + maxFatigue +
				"\nActions Left: " + actionsLeft;
		return returnString;
	}
	

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public int getActionsLeft() {
		return actionsLeft;
	}

	public void setActionsLeft(int actionsLeft) {
		this.actionsLeft = actionsLeft;
	}


	public int getHealth() {
		return health;
	}


	public void setHealth(int health) {
		this.health = health;
	}


	public int getMaxHealth() {
		return maxHealth;
	}


	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}


	public int getHunger() {
		return hunger;
	}


	public void setHunger(int hunger) {
		this.hunger = hunger;
	}


	public int getMaxHunger() {
		return maxHunger;
	}


	public void setMaxHunger(int maxHunger) {
		this.maxHunger = maxHunger;
	}


	public int getFatigue() {
		return fatigue;
	}


	public void setFatigue(int fatigue) {
		this.fatigue = fatigue;
	}


	public int getMaxFatigue() {
		return maxFatigue;
	}


	public void setMaxFatigue(int maxFatigue) {
		this.maxFatigue = maxFatigue;
	}


	public int getMaxActions() {
		return maxActions;
	}


	public void setMaxActions(int maxActions) {
		this.maxActions = maxActions;
	}
	

	
}
