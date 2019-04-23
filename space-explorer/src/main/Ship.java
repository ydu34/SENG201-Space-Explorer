package main;

public class Ship {
	private int shieldLevel; 
	private int maxShieldLevel;
	private int piecesNeeded;
	private int piecesFound;
	private boolean destroyed; 
	
	public Ship() {
		maxShieldLevel = 100;
		shieldLevel = maxShieldLevel;
		piecesFound = 0;
		piecesNeeded = 0;
		destroyed = false;
	}
	public String toString() {
		String returnString =
				"Ship Status: " + 
				"\nShields: " + shieldLevel + "/" + maxShieldLevel +
				"\nPieces needed: " + piecesNeeded;
		return returnString;
	}
	
	public void foundPiece() {
		piecesFound +=1;
		System.out.println("Found " + piecesFound + "/" + piecesNeeded + " pieces needed!");
	}
	
	public void increaseShieldLevel(int amount) {
		shieldLevel += amount;
		if (shieldLevel > maxShieldLevel) {
			shieldLevel = maxShieldLevel;
		}
	}
	
	public void decreaseShieldLevel(int amount) {
		shieldLevel -= amount;
		if (shieldLevel < 0) {
			destroyed = true;
		}
	}
	public int getShieldLevel() {
		return shieldLevel;
	}
	public void setShieldLevel(int shieldLevel) {
		this.shieldLevel = shieldLevel;
	}
	public int getMaxShieldLevel() {
		return maxShieldLevel;
	}
	public void setMaxShieldLevel(int maxShieldLevel) {
		this.maxShieldLevel = maxShieldLevel;
	}
	public int getPiecesNeeded() {
		return piecesNeeded;
	}
	public void setPiecesNeeded(int piecesNeeded) {
		this.piecesNeeded = piecesNeeded;
	}
	public int getPiecesFound() {
		return piecesFound;
	}
	public void setPiecesFound(int piecesFound) {
		this.piecesFound = piecesFound;
	}
	public boolean isDestroyed() {
		return destroyed;
	}
	public void setDestroyed(boolean destroyed) {
		this.destroyed = destroyed;
	}
	
	
	
	
}
