package main;
/**
 * Represents a Regular type crew member.
 */
public class Regular extends CrewMember{
	/**
	 * Creates a Regular type crew member.
	 * @param name   A string name of the crew member.
	 */
	public Regular(String name) {
		super(name, "Regular", "Normal", 100, 130, 130, 2);
	}
	
	/**
	 * Prints a description of Regular.
	 */
	public static void description() {
		System.out.println("Regular does not have any special powers."
				+ "\nRegular has higher hunger and fatigue tolerance levels.");
	}

}
