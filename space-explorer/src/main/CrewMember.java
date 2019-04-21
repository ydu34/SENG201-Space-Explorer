package main;

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
		crew.getFoodItems().remove(item);
		actionsLeft -= 1;
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
