package main;
import java.util.*;

/**
 * Represents a crew.
 */
public class Crew {
	private String name;
	private Ship ship = new Ship();
	private ArrayList<CrewMember> crewMembers = new ArrayList<CrewMember>();
	private ArrayList<MedicalItem> medicalItems = new ArrayList<MedicalItem>();
	private ArrayList<FoodItem> foodItems = new ArrayList<FoodItem>();
	private int money = 200;
	private Planet currentLocation;
	
	public String medicalItemsDetails() {
		ArrayList<MedicalItem> medicalItemsSet = new ArrayList<MedicalItem>(new TreeSet<MedicalItem>(medicalItems));
		String returnString = "";
		for (MedicalItem item: medicalItemsSet) {
			returnString += item.getName() + "(" + Collections.frequency(medicalItems, item) + ")";
			returnString += "\n"+ item.getDescription();
			returnString += "\nPrice: " + item.getPrice();
			returnString += "\n";
		} 
		return returnString;
	}
	
	public String foodItemsDetails() {
		ArrayList<FoodItem> foodItemsSet = new ArrayList<FoodItem>(new TreeSet<FoodItem>(foodItems));
		String returnString = "";
		for (FoodItem item: foodItemsSet) {
			returnString += item.getName() + "(" + Collections.frequency(foodItems, item) + ")";
			returnString += "\n"+ item.getDescription();
			returnString += "\nPrice: " + item.getPrice();
			returnString += "\n";
		}
		return returnString;	
	}
	
	public void increaseMoney(int amount) {
		money += amount;
	}
	
	public void decreaseMoney(int amount) {
		money -= amount;
		if (money < 0) {
			money = 0;
		}
	}
	
	public ArrayList<MedicalItem> getMedicalItems() {
		return medicalItems;
	}
	public ArrayList<FoodItem> getFoodItems() {
		return foodItems;
	}
	
	/**
	 * Gets the crew members.
	 * @return An ArrayList of the crew members.
	 */
	public ArrayList<CrewMember> getCrewMembers() {
		return crewMembers;
	}
	
	/**
	 * Sets the crew members.
	 * @param crewMembers   An ArrayList of the crew members.
	 */
	public void setCrewMembers(ArrayList<CrewMember> crewMembers) {
		this.crewMembers = crewMembers;
	}
	
	/**
	 * Gets the crew name.
	 * @return the name of the crew.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name of the crew.
	 * @param name  A string name of the crew.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the crew ship.
	 * @return the ship of the crew.
	 */
	public Ship getShip() {
		return ship;
	}
	
	/**
	 * Sets the ship of the crew.
	 * @param ship  A ship.
	 */
	public void setShip(Ship ship) {
		this.ship = ship;
	}

	
	/**
	 * Gets the amount of money the crew has.
	 * @return The amount of money the crew has.
	 */

	public int getMoney() {
		return money;
	}
	
	/**
	 * Sets the amount of money the crew has.
	 * @param money An int number of money the crew has.
	 */
	public void setMoney(int money) {
		this.money = money;
	}
	
	/**
	 * Gets the current location of the crew.
	 * @return the current location of the crew.
	 */
	public Planet getCurrentLocation() {
		return currentLocation;
	}
	
	/**
	 * Sets the current location of the crew.
	 * @param currentLocation  The planet the crew is currently on.
	 */
	public void setCurrentLocation(Planet currentLocation) {
		this.currentLocation = currentLocation;
	}
	
	
}
