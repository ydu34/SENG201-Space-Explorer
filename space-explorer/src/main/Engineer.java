package main;

/**
 * Represents an engineer type of crew member.
 * @author Yu Duan
 * @author Joyce Cheah
 */
public class Engineer extends CrewMember{
	
	
	public Engineer(String name) {
		super(name, "Engineer", "", 100, 100, 100, 2, 
				5,5,10,10,20,20);
	}
	/**
	 * Creates an engineer with the given name.
	 * @param name   A string name of the crew member.
	 * @param image  A string image of the crew member.
	 */
	public Engineer(String name, String image) {
		super(name, "Engineer", image, 100, 100, 100, 2, 
				5,5,10,10,20,20);
	}
	
	/**
	 * Repairs the ship to increase its shield level.
	 * @param ship   A Ship object.
	 * @return A string message of the ship's updated shield level. 
	 */
	public String repair(Ship ship) {
		String returnString = "";
		returnString += super.repair(ship);
		ship.increaseShieldLevel(10);
		returnString += "\n" + super.getName() +" repairs extra shields from their trait Engineer.";
		returnString += "\n" + ship.getName() +"'s shields is at " + ship.getShieldLevel() + "/" + ship.getMaxShieldLevel() + " shields.";
		return returnString;
	}
	

}

