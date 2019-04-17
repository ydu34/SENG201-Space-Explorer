package main;

public class FoodItem extends Item {
	private int restoreHungerAmount;

	public FoodItem(String name, int price, String description, int restoreHungerAmount) {
		super(name, price, description);
		this.restoreHungerAmount = restoreHungerAmount;
	}

	public int getRestoreHungerAmount() {
		return restoreHungerAmount;
	}

	public void setRestoreHungerAmount(int restoreHungerAmount) {
		this.restoreHungerAmount = restoreHungerAmount;
	}

}
