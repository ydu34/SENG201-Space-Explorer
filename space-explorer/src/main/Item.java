package main;

/**
 * Represents an item.
 * 
 * @author Yu Duan
 * @author Joyce Cheah
 */
public class Item implements Comparable<Item> {

	private String name;
	private int price;
	private String description;

	/**
	 * Creates an item.
	 * 
	 * @param name        A string name of the item.
	 * @param price       An int of the item price.
	 * @param description A string description of the item.
	 */
	public Item(String name, int price, String description) {
		this.name = name;
		this.price = price;
		this.description = description;
	}

	/**
	 * Creates a string representation of the item.
	 * 
	 * @return A string representation of the item.
	 */
	public String toString() {
		String returnString = name;
		// changed string to name only
		return returnString;
	}

	/**
	 * Gets the name of the item.
	 * 
	 * @return the name of the item.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the item.
	 * 
	 * @param name A string name of the item.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the price of the item.
	 * 
	 * @return An int number of the item price.
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * Sets the price of the item.
	 * 
	 * @param price An int of the item price.
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * Gets the description of the item.
	 * 
	 * @return A string description of the item.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description of the item.
	 * 
	 * @param description A string description of the item.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	/**
	 * Compares this item with the specified item.
	 * 
	 * @return A negative int, zero, or a positive int as this item is less than,
	 *         equal to, or greater than the specified item.
	 */
	public int compareTo(Item o) {
		return (this.name).compareTo(o.name);
	}

}
