package main;
/**
 * Represents a HealthNut type crew member.
 */
public class HealthNut extends CrewMember{
	/**
	 * Creates a HealthNut type crew member.
	 * @param name   A string name of the crew member.
	 */
	public HealthNut(String name) {
		super(name, "Health Nut", "Normal", 100, 100, 100, 2);
	}
	
	/**
	 * Applies medical items.
	 * @param item   A MedicalItem object.
	 * @param crew   A Crew object.
	 */
	public String useMedicalItem(MedicalItem item, Crew crew) {
		String returnString = "";
		returnString += super.useMedicalItem(item, crew);
		super.setHealth(super.getHealth() + 10);
		returnString += "\n" + super.getName() +" recovers extra health from their trait Health Nut.";
		returnString += "\n" + super.getName() +" now has " + super.getHealth() + "/" + super.getMaxHealth() + " health.";
		return returnString;
	}

}
