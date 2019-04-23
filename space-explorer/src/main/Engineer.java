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
		super(name, "Engineer", 100, 100, 100, 2);
	}
	
	/**
	 * Repairs the ship.
	 * @param ship   A ship object.
	 */
	public void repair(Ship ship) {
		int shieldLevel = ship.getShieldLevel();
		int maxShieldLevel = ship.getMaxShieldLevel();
		shieldLevel += 15;
		if (shieldLevel > maxShieldLevel) {
			shieldLevel = maxShieldLevel;
		}
		int actionsLeft = super.getActionsLeft();
		super.setFatigue(super.getFatigue()+5);
		actionsLeft -= 1;
		System.out.println("The ship's shield is now " + shieldLevel + "/" +maxShieldLevel);
	}

	/**
	 * Prints a description of the engineer.
	 */
	public static void description() {
		System.out.println("The Engineer is a master at building, designing and maintaining machines."
				+ "\nThe Engineer is more skilled at reparining the spaceship.");
		
	}

}

