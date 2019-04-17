package main;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class SpaceOutpost {
	
	private ArrayList<Item> itemsForSale = new ArrayList<Item>();
	
	public void generateItems(MedicalItem[] medItems, FoodItem[] foodItems) {
		
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

	public ArrayList<Item> getItemsForSale() {
		return itemsForSale;
	}

	public void setItemsForSale(ArrayList<Item> itemsForSale) {
		this.itemsForSale = itemsForSale;
	}
	

	
}
