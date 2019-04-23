package main;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.Collections;

/**
 * Represents a space outpost.
 */
public class SpaceOutpost {
	
	private ArrayList<MedicalItem> medicalItems = new ArrayList<MedicalItem>();
	private ArrayList<FoodItem> foodItems = new ArrayList<FoodItem>();
	
<<<<<<< HEAD
	/**
	 * Generates the items available for sale.
	 */
	public void generateItems(ArrayList<MedicalItem> medItems, ArrayList<FoodItem> foodItems) {
		
		for (MedicalItem medItem: medItems) {
			int randomNum = ThreadLocalRandom.current().nextInt(0,3);
			if (randomNum == 1) {
				int itemAmount = ThreadLocalRandom.current().nextInt(0, 4);
				for (int i = 0; i <= itemAmount; i++) {
					itemsForSale.add(medItem);
				}
			}
=======
	public void purchaseItem(MedicalItem item, Crew crew) {
		if (crew.getMoney() >= item.getPrice()) {
			crew.decreaseMoney(item.getPrice());
			crew.getMedicalItems().add(item);
			medicalItems.remove(item);
			System.out.println(item.getName() + " has been purchased!");
		} else {
			System.out.println("Not enough money!");
>>>>>>> 1c1ed1b57f01f671e256ed7d1bd5929d4af23a8c
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
<<<<<<< HEAD

	/**
	 * Gets the items for sale.
	 * @return the items for sale.
	 */
	public ArrayList<Item> getItemsForSale() {
		return itemsForSale;
	}

	/**
	 * Sets the items for sale.
	 * @param itemsForSale   An ArrayList of the items for sale.
	 */
	public void setItemsForSale(ArrayList<Item> itemsForSale) {
		this.itemsForSale = itemsForSale;
=======
	
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
>>>>>>> 1c1ed1b57f01f671e256ed7d1bd5929d4af23a8c
	}
	

	
}
