package main;

import java.util.ArrayList;

/**
 * Represents a space outpost.
 */
public class SpaceOutpost {

	private ArrayList<MedicalItem> medicalItems = new ArrayList<MedicalItem>();
	private ArrayList<FoodItem> foodItems = new ArrayList<FoodItem>();

	public void purchaseMedicalItem(MedicalItem item, Crew crew) {
		crew.decreaseMoney(item.getPrice());
		crew.getMedicalItems().add(item);
		medicalItems.remove(item);
	}

	public void purchaseFoodItem(FoodItem item, Crew crew) {
		crew.decreaseMoney(item.getPrice());
		crew.getFoodItems().add(item);
		foodItems.remove(item);
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
