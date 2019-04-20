package main;
import java.util.*;

public class Crew {
	private String name;
	private Ship ship;
	private ArrayList<CrewMember> crewMembers = new ArrayList<CrewMember>();
	private ArrayList<MedicalItem> medicalItems = new ArrayList<MedicalItem>();
	private ArrayList<FoodItem> foodItems = new ArrayList<FoodItem>();
	private int money = 200;
	private Planet currentLocation;
	
	
	public String medicalItemsDetails() {
		TreeSet<MedicalItem> medicalItemsSet = new TreeSet<MedicalItem>(medicalItems);
		String returnString = "";
		for (MedicalItem item: medicalItemsSet) {
			returnString += item.getName() + "(" + Collections.frequency(medicalItems, item) + ")";
			returnString += "\n"+ item.getDescription();
			returnString += "\n";
		}
		return returnString;
	}
	
	public String foodItemsDetails() {
		TreeSet<FoodItem> foodItemsSet = new TreeSet<FoodItem>(foodItems);
		String returnString = "";
		for (FoodItem item: foodItemsSet) {
			returnString += item.getName() + "(" + Collections.frequency(foodItems, item) + ")";
			returnString += "\n"+ item.getDescription();
			returnString += "\n";
		}
		return returnString;	
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
