package main;

public class Ship {
	private int shieldLevel; 
	private int maxShieldLevel;
	private int piecesNeeded;
	
	public Ship() {
		maxShieldLevel = 100;
		shieldLevel = maxShieldLevel;
		piecesNeeded = 0;
	}
	public String toString() {
		String returnString =
				"Ship Status: " + 
				"\nShields: " + shieldLevel + "/" + maxShieldLevel +
				"\nPieces needed: " + piecesNeeded;
		return returnString;
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
	
	
	
	
}
