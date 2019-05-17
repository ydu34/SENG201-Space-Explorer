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
		super(name, "Engineer", "Normal", 100, 100, 100, 2, 
				5,5,10,10,20,20);
	}
	
	/**
	 * Repairs the ship.
	 * @param ship   A Ship object.
	 */
	public void repair(Ship ship) {
		super.repair(ship);
		ship.setShieldLevel(ship.getShieldLevel()+10);
	}
	

}

