package main;

/**
 * Represents a ship.
 */
public class Ship {
	private int shieldLevel; 
	private int maxShieldLevel;
	private int piecesNeeded;
	
	/**
	 * Creates a ship.
	 */
	public Ship() {
		maxShieldLevel = 100;
		shieldLevel = maxShieldLevel;
		piecesNeeded = 0;
	}
	
	/**
	 * Creates a string representation of the ship.
	 * @return A string representation of the ship.
	 */
	public String toString() {
		String returnString =
				"Ship Status: " + 
				"\nShields: " + shieldLevel + "/" + maxShieldLevel +
				"\nPieces needed: " + piecesNeeded;
		return returnString;
	}
	
	/**
	 * Gets the shield level.
	 * @return the shield level.
	 */
	public int getShieldLevel() {
		return shieldLevel;
	}
	
	/**
	 * Sets the shield level.
	 * @param shieldLevel   An int number of the shield level.
	 */
	public void setShieldLevel(int shieldLevel) {
		this.shieldLevel = shieldLevel;
	}
	
	/**
	 * Gets the maximum shield level.
	 * @return the maximum shield level.
	 */
	public int getMaxShieldLevel() {
		return maxShieldLevel;
	}
	
	/**
	 * Sets the maximum shield level.
	 * @param maxShieldLevel   An int number of the maximum shield level.
	 */
	public void setMaxShieldLevel(int maxShieldLevel) {
		this.maxShieldLevel = maxShieldLevel;
	}
	
	/**
	 * Gets the number of pieces players need to find.
	 * @return the number of pieces players need to find.
	 */
	public int getPiecesNeeded() {
		return piecesNeeded;
	}
	
	/**
	 * Sets the number of pieces players need to find.
	 * @return the number of pieces players need to find.
	 */
	public void setPiecesNeeded(int piecesNeeded) {
		this.piecesNeeded = piecesNeeded;
	}
	
	
	
	
}
