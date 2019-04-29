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
		super(name, "HealthNut", "Normal", 100, 100, 100, 2);
	}
	
	/**
	 * Applies medical items.
	 * @param item   A MedicalItem object.
	 * @param crew   A Crew object.
	 */
	public void useMedicalItem(MedicalItem item, Crew crew) {
		health += 10;
		health += item.getRestoreHealthAmount();
		if (health > maxHealth) {
			health = maxHealth;
		}
		System.out.println(name + " now has " + health + ".");
		if (item.isRemovePlague()) {
			infected = false;
			status = "Normal";
		}
		crew.getMedicalItems().remove(item);
		super.setActionsLeft(super.getActionsLeft()-1);
		
	}
	
	/**
	 * Prints a description of HealthNut.
	 */
	public static void description() {
		System.out.println("HealthNut has a very healthy lifestyle." 
				+ "/nHealthNut's health level increases by more when consuming medical items");
	}
}
