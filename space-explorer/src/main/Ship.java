package main;

/**
 * Represents a ship, which has a name, shield level, maximum shield level,
 * pieces needed, pieces found, and if the ship is destroyed.
 * 
 * @author Yu Duan
 * @author Joyce Cheah
 */
public class Ship {
	private String name;
	private int shieldLevel;
	private int maxShieldLevel;
	private int partsNeeded;
	private int partsFound;
	private boolean destroyed;

	/**
	 * Creates a ship.
	 */
	public Ship() {
		maxShieldLevel = 100;
		shieldLevel = maxShieldLevel;
		partsFound = 0;
		partsNeeded = 0;
		destroyed = false;
	}

	/**
	 * Creates a string representation of the ship.
	 * 
	 * @return A string representation of the ship.
	 */
	public String toString() {
		return name;
	}

	/**
	 * Updates the count of ship pieces found.
	 */
	public void foundPiece() {
		partsFound += 1;
	}

	/**
	 * Increases the ship's shield level by the given amount.
	 * 
	 * @param amount An int of the increase in shield level.
	 */
	public void increaseShieldLevel(int amount) {
		shieldLevel += amount;
		if (shieldLevel > maxShieldLevel) {
			shieldLevel = maxShieldLevel;
		}
	}

	/**
	 * Decreases the ship's shield level by the given amount.
	 * 
	 * @param amount An int of the decrease in shield level.
	 */
	public void decreaseShieldLevel(int amount) {
		shieldLevel -= amount;
		if (shieldLevel <= 0) {
			shieldLevel = 0;
			destroyed = true;
		}
	}

	/**
	 * Gets the ship's shield level.
	 * 
	 * @return the ship's shield level.
	 */
	public int getShieldLevel() {
		return shieldLevel;
	}

	/**
	 * Sets the ship's shield level.
	 * 
	 * @param shieldLevel An int of the ship's shield level.
	 */
	public void setShieldLevel(int shieldLevel) {
		this.shieldLevel = shieldLevel;
	}

	/**
	 * Gets the ship's maximum shield level.
	 * 
	 * @return the ship's maximum shield level.
	 */
	public int getMaxShieldLevel() {
		return maxShieldLevel;
	}

	/**
	 * Sets the ship's maximum shield level.
	 * 
	 * @param maxShieldLevel An int of the ship's maximum shield level.
	 */
	public void setMaxShieldLevel(int maxShieldLevel) {
		this.maxShieldLevel = maxShieldLevel;
	}

	/**
	 * Gets the number of ship pieces the crew needs to find.
	 * 
	 * @return the number of ship parts the crew needs to find.
	 */
	public int getPartsNeeded() {
		return partsNeeded;
	}

	/**
	 * Sets the number of ship parts the crew need to find.
	 * 
	 * @param partsNeeded An int of the number pieces needed.
	 */
	public void setPartsNeeded(int piecesNeeded) {
		this.partsNeeded = piecesNeeded;
	}

	/**
	 * Gets the number of ship parts already found.
	 * 
	 * @return An int of the ship parts already found.
	 */
	public int getPartsFound() {
		return partsFound;
	}

	/**
	 * Sets the number of ship parts already found.
	 * 
	 * @param partsFound An int of the ship parts already found.
	 */
	public void setPartsFound(int piecesFound) {
		this.partsFound = piecesFound;
	}

	/**
	 * Checks if the ship is destroyed.
	 * 
	 * @return true if the ship's shield level is zero, false otherwise.
	 */
	public boolean isDestroyed() {
		return destroyed;
	}

	/**
	 * Sets if the ship is destroyed.
	 * 
	 * @param destroyed A boolean expression of whether the ship is destroyed.
	 */
	public void setDestroyed(boolean destroyed) {
		this.destroyed = destroyed;
	}

	/**
	 * Gets the name of the ship.
	 * 
	 * @return the name of the ship.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the ship.
	 * 
	 * @param name A string name of the ship.
	 */
	public void setName(String name) {
		this.name = name;
	}

}
