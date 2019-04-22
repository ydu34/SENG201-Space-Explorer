package main;
import java.util.*;

/**
 * Represents a crew.
 */
public class Crew {
	private String name;
	private Ship ship;
	private ArrayList<CrewMember> crewMembers = new ArrayList<CrewMember>();
	private ArrayList<Item> Inventory = new ArrayList<Item>();
	private int money = 100;
	private Planet currentLocation;
	
	/**
	 * Creates an inventory details string
	 * @return A string representation of the inventory with their frequency.
	 */
	public String inventoryDetails() {
		TreeSet<Item> InventorySet = new TreeSet<Item>();
		InventorySet.addAll(Inventory);
		String inventoryString = "";
		for (Item item: InventorySet) {
			inventoryString += item +"(" + Collections.frequency(Inventory, item) + ")";
			inventoryString += ", ";
		}
		return inventoryString;
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
	 * Gets the inventory.
	 * @returns An ArrayList of the inventory.
	 */
	public ArrayList<Item> getInventory() {
		return Inventory;
	}
	
	/**
	 * Sets the inventory.
	 * @param inventory   An ArrayList of the inventory.
	 */
	public void setInventory(ArrayList<Item> inventory) {
		Inventory = inventory;
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
	 * @param money  An int number of money the crew has.
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
