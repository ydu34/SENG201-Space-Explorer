package main;

/**
 * Represents a food item.
 */
public class FoodItem extends Item {
	private int restoreHungerAmount;
	
	/**
	 * Creates a food item.
	 * @param name                 A string name of the food.
	 * @param price                An int number of the food price.
	 * @param description          A string description of the food.
	 * @param restoreHungerAmount  An int number of the restore hunger amount when the food is consumed.
	 */
	public FoodItem(String name, int price, String description, int restoreHungerAmount) {
		super(name, price, description);
		this.restoreHungerAmount = restoreHungerAmount;
	}
	
	/**
	 * Gets the restore hunger amount of the food.
	 * @return An int representing the restore hunger amount of the food.
	 */
	public int getRestoreHungerAmount() {
		return restoreHungerAmount;
	}
	
	/**
	 * Sets the restore hunger amount of the food.
	 * @param restoreHungerAmount  An int number of the restore hunger amount when the food is consumed.
	 */
	public void setRestoreHungerAmount(int restoreHungerAmount) {
		this.restoreHungerAmount = restoreHungerAmount;
	}

}
