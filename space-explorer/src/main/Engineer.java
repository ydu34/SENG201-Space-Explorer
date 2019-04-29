package main;

/**
 * Represents an engineer.
 */
public class Engineer extends CrewMember{
	
	/**
	 * Creates an engineer.
	 * @param name   A string name of the crew member.
	 */
	public Engineer(String name) {
		super(name, "Engineer", "Normal", 100, 100, 100, 2);
	}
	
	/**
	 * Repairs the ship.
	 * @param ship   A Ship object.
	 */
	public void repair(Ship ship) {
		int fatigueCost = 5;
		if (super.getFatigue() + fatigueCost > super.getMaxFatigue()) {
			System.out.println(super.getName() + " is too tired to repair the ship.");
		} else { 
			int shieldLevel = ship.getShieldLevel();
			int maxShieldLevel = ship.getMaxShieldLevel();
			shieldLevel += 15;
			if (shieldLevel > maxShieldLevel) {
				shieldLevel = maxShieldLevel;
			}
			super.setActionsLeft(super.getActionsLeft()-1);
			super.setFatigue(super.getFatigue()+fatigueCost);
			System.out.println("The ship's shield is now " + shieldLevel + "/" +maxShieldLevel);
		}
	}
	

	/**
	 * Prints a description of Engineer.
	 */
	public static void description() {
		System.out.println("The Engineer is a master at building, designing and maintaining machines."
				+ "\nThe Engineer is more skilled at reparining the spaceship.");
		
	}

}

