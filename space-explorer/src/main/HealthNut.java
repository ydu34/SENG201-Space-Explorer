package main;

/**
 * Represents a HealthNut type crew member.
 * 
 * @author Yu Duan
 * @author Joyce Cheah
 */
public class HealthNut extends CrewMember {

	/**
	 * Creates a HealthNut type crew member.
	 * 
	 * @param name  A string name of the crew member.
	 * @param image A string image of the crew member.
	 */
	public HealthNut(String name, String image) {
		super(name, "Health Nut", image, 100, 100, 100);
	}

	/**
	 * Applies medical items, restore an additional 10 health for Health Nut.
	 * 
	 * @param item A MedicalItem object.
	 * @param crew A Crew object.
	 */
	public String useMedicalItem(MedicalItem item, Crew crew) {
		String returnString = "";
		returnString += super.useMedicalItem(item, crew);
		super.increaseHealth(10);
		returnString += "\n" + super.getName() + " recovers extra health from their Health Nut ability.";
		returnString += "\n" + super.getName() + " now has " + super.getHealth() + "/" + super.getMaxHealth()
				+ " health.";
		return returnString;
	}

}
