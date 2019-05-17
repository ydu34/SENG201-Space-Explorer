package main;
import java.util.ArrayList;


/**
 * Represents a space outpost.
 */
public class SpaceOutpost {
	
	private ArrayList<MedicalItem> medicalItems = new ArrayList<MedicalItem>();
	private ArrayList<FoodItem> foodItems = new ArrayList<FoodItem>();

	
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
