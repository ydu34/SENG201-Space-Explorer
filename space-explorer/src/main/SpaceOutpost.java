package main;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.Collections;

public class SpaceOutpost {
	
	private ArrayList<MedicalItem> medicalItems = new ArrayList<MedicalItem>();
	private ArrayList<FoodItem> foodItems = new ArrayList<FoodItem>();
	
	
	public String medicalItemsDetails() {
		TreeSet<MedicalItem> medicalItemsSet = new TreeSet<MedicalItem>(medicalItems);
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
		TreeSet<FoodItem> foodItemsSet = new TreeSet<FoodItem>(foodItems);
		String returnString = "";
		for (FoodItem item: foodItemsSet) {
			returnString += item.getName() + "(" + Collections.frequency(foodItems, item) + ")";
			returnString += "\n"+ item.getDescription();
			returnString += "\nPrice: " + item.getPrice();
			returnString += "\n";
		}
		return returnString;	
	}
	
	public ArrayList<MedicalItem> getMedicalItems() {
		return medicalItems;
	}
	public void setMedicalItems(ArrayList<MedicalItem> medicalItems) {
		this.medicalItems = medicalItems;
	}
	public ArrayList<FoodItem> getFoodItems() {
		return foodItems;
	}
	public void setFoodItems(ArrayList<FoodItem> foodItems) {
		this.foodItems = foodItems;
	}
	

	
}
