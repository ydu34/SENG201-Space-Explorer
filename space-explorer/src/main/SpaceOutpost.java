package main;
import java.util.ArrayList;

/**
 * Represents a space outpost.
 * @author Yu Duan
 * @author Joyce Cheah
 */
public class SpaceOutpost {
	
	private ArrayList<MedicalItem> medicalItems = new ArrayList<MedicalItem>();
	private ArrayList<FoodItem> foodItems = new ArrayList<FoodItem>();

	/**
	 * Purchases a medical item.
	 * @param item   A MedicalItem object.
	 * @param crew   A Crew object.
	 */
	public void purchaseItem(MedicalItem item, Crew crew) {
		if (crew.getMoney() >= item.getPrice()) {
			crew.decreaseMoney(item.getPrice());
			crew.getMedicalItems().add(item);
			medicalItems.remove(item);
			System.out.println(item.getName() + " has been purchased!");
		} else {
			System.out.println("Not enough money!");
		}
	}
	
	/**
	 * Purchases a food item.
	 * @param item   A FoodItem object.
	 * @param crew   A Crew object.
	 */
	public void purchaseItem(FoodItem item, Crew crew) {
		if (crew.getMoney() >= item.getPrice()) {
			crew.decreaseMoney(item.getPrice());
			crew.getFoodItems().add(item);
			foodItems.remove(item);
			System.out.println(item.getName() + " has been purchased!");
		} else {
			System.out.println("Not enough money!");
		}
	}

	/**
	 * Gets the medical items.
	 * @return An ArrayList of the medical items.
	 */
	public ArrayList<MedicalItem> getMedicalItems() {
		return medicalItems;
	}
	
	/**
	 * Sets the medical items.
	 * @param medicalItems   An ArrayList of the medical items.
	 */
	public void setMedicalItems(ArrayList<MedicalItem> medicalItems) {
		this.medicalItems = medicalItems;
	}
	
	/**
	 * Gets the food items.
	 * @return An ArrayList of the food items.
	 */
	public ArrayList<FoodItem> getFoodItems() {
		return foodItems;
	}
	
	/**
	 * Sets the food items.
	 * @param foodItems   An ArrayList of the food items.
	 */
	public void setFoodItems(ArrayList<FoodItem> foodItems) {
		this.foodItems = foodItems;
	}
	

	
}
