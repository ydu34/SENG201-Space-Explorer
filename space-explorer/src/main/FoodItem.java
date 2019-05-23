package main;

/**
 * Represents a food item, which restores hunger of crew members.
 * 
 * @author Yu Duan
 * @author Joyce Cheah
 */
public class FoodItem extends Item {
	private int restoreHungerAmount;

	/**
	 * Creates a food item.
	 * 
	 * @param name                A string name of the food item.
	 * @param price               An int of the food price.
	 * @param description         A string description of the food.
	 * @param restoreHungerAmount An int of the restore hunger amount when the food
	 *                            is consumed.
	 */
	public FoodItem(String name, int price, String description, int restoreHungerAmount) {
		super(name, price, description);
		this.restoreHungerAmount = restoreHungerAmount;
	}

	/**
	 * Gets the restore hunger amount of the food item.
	 * 
	 * @return An int representing the restore hunger amount of the food item.
	 */
	public int getRestoreHungerAmount() {
		return restoreHungerAmount;
	}

	/**
	 * Sets the restore hunger amount of the food item.
	 * 
	 * @param restoreHungerAmount An int of the restore hunger amount when the food
	 *                            is consumed.
	 */
	public void setRestoreHungerAmount(int restoreHungerAmount) {
		this.restoreHungerAmount = restoreHungerAmount;
	}

}
