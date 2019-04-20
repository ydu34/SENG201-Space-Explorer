package main;

public class Engineer extends CrewMember{
	

	public Engineer(String name) {
		super(name, "Engineer", 100, 100, 100, 2);
	}
	
	public void repair(Ship ship) {
		int shieldLevel = ship.getShieldLevel();
		int maxShieldLevel = ship.getMaxShieldLevel();
		shieldLevel += 20;
		if (shieldLevel > maxShieldLevel) {
			shieldLevel = maxShieldLevel;
		}
		int actionsLeft = super.getActionsLeft();
		actionsLeft -= 1;
		System.out.println("The ship's shield is now " + shieldLevel + "/" +maxShieldLevel);
	}


	public static void description() {
		System.out.println("The Engineer is a master at building, designing and maintaining machines."
				+ "\nThe Engineer is more skilled at reparining the spaceship.");
		
	}

}
