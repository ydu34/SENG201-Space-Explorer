package main;

public class Ship {
	private int shieldLevel; 
	private int maxShieldLevel;
	
	public Ship() {
		maxShieldLevel = 100;
		shieldLevel = maxShieldLevel;
	}
	public String toString() {
		String returnString =
				"Ship Status: " + 
				"\nShields: " + shieldLevel + "/" + maxShieldLevel;
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
	
	
}
