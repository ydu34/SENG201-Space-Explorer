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
