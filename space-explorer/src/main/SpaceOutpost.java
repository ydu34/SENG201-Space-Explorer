package main;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Represents a space outpost.
 */
public class SpaceOutpost {
	
	private ArrayList<Item> itemsForSale = new ArrayList<Item>();
	
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
		}
		for (FoodItem foodItem: foodItems) {
			int randomNum = ThreadLocalRandom.current().nextInt(0,2);
			if (randomNum == 1) {
				int itemAmount = ThreadLocalRandom.current().nextInt(0, 4);
				for (int i = 0; i <= itemAmount; i++) {
					itemsForSale.add(foodItem);
				}
			}
		}
	}

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
	}
	

	
}
