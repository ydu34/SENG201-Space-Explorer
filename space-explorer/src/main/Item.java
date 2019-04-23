package main;

<<<<<<< HEAD
/**
 * Represents an item.
 */
public class Item {
=======

public class Item implements  Comparable<Item>{
>>>>>>> 1c1ed1b57f01f671e256ed7d1bd5929d4af23a8c
	private String name;
	private int price;
	private String description;
	
	/**
	 * Creates an item.
	 * @param name          A string name of the item.
	 * @param price         An int number of the item price.
	 * @param description  A string description of the item.
	 */
	public Item(String name, int price, String description) {
		this.name = name;
		this.price = price;
		this.description = description;
	}
	
	/**
	 * Creates a string representation of the item.
	 * @return A string representation of the item.
	 */
	public String toString() {
		String returnString = "Name: " + name +
				"\nPrice: " + price + 
				"\n" + description;
		return returnString;
	}
	
	/**
	 * Gets the name of the item.
	 * @return the name of the item.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the item.
	 * @param name   A string name of the item.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the price of the item.
	 * @return An int number of the item price.
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * Sets the price of the item.
	 * @param price   An int number of the item price.
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * Gets the description of the item.
	 * @return A string description of the item.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description of the item.
	 * @param description   A string description of the item.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int compareTo(Item o) {
		return (this.name).compareTo(o.name);
	}


	
}
