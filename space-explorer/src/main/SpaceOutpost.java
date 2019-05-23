package main;

import java.util.ArrayList;

/**
 * Represents a space outpost, which contains medical items and food items to sell to the player. 
 * 
 * @author Yu Duan
 * @author Joyce Cheah
 */
public class SpaceOutpost {

	private ArrayList<MedicalItem> medicalItems = new ArrayList<MedicalItem>();
	private ArrayList<FoodItem> foodItems = new ArrayList<FoodItem>();

	/**
	 * Purchases a medical item.
	 * 
	 * @param item The MedicalItem that is being purchased.
	 * @param crew The player's Crew.
	 */
	public void purchaseMedicalItem(MedicalItem item, Crew crew) {
		crew.decreaseMoney(item.getPrice());
		crew.getMedicalItems().add(item);
		medicalItems.remove(item);
	}

	/**
	 * Purchases a food item.
	 * 
	 * @param item A FoodItem object.
	 * @param crew A Crew object.
	 */
	public void purchaseFoodItem(FoodItem item, Crew crew) {
		crew.decreaseMoney(item.getPrice());
		crew.getFoodItems().add(item);
		foodItems.remove(item);
	}

	/**
	 * Gets the medical items available.
	 * 
	 * @return An ArrayList of the medical items.
	 */
	public ArrayList<MedicalItem> getMedicalItems() {
		return medicalItems;
	}

	/**
	 * Sets the medical items.
	 * 
	 * @param medicalItems An ArrayList of the medical items.
	 */
	public void setMedicalItems(ArrayList<MedicalItem> medicalItems) {
		this.medicalItems = medicalItems;
	}

	/**
	 * Gets the food items available.
	 * 
	 * @return An ArrayList of the food items.
	 */
	public ArrayList<FoodItem> getFoodItems() {
		return foodItems;
	}

	/**
	 * Sets the food items.
	 * 
	 * @param foodItems An ArrayList of the food items.
	 */
	public void setFoodItems(ArrayList<FoodItem> foodItems) {
		this.foodItems = foodItems;
	}

}
