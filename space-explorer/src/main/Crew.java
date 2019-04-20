package main;
import java.util.*;

public class Crew {
	private String name;
	private Ship ship;
	private ArrayList<CrewMember> crewMembers = new ArrayList<CrewMember>();
	private ArrayList<Item> Inventory = new ArrayList<Item>();
	private int money = 100;
	private Planet currentLocation;
	
	
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
	public ArrayList<CrewMember> getCrewMembers() {
		return crewMembers;
	}
	public void setCrewMembers(ArrayList<CrewMember> crewMembers) {
		this.crewMembers = crewMembers;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Ship getShip() {
		return ship;
	}
	public void setShip(Ship ship) {
		this.ship = ship;
	}
	public ArrayList<Item> getInventory() {
		return Inventory;
	}
	public void setInventory(ArrayList<Item> inventory) {
		Inventory = inventory;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public Planet getCurrentLocation() {
		return currentLocation;
	}
	public void setCurrentLocation(Planet currentLocation) {
		this.currentLocation = currentLocation;
	}
	
	
}
