package main;
/**
 * Represents a Protected type crew member.
 */
public class Protected extends CrewMember{
	/**
	 * Creates a Protected type crew member.
	 * @param name   A string name of the crew member.
	 */
	public Protected(String name) {
		super(name, "Protected", "Normal", 100, 100, 100, 2);
	}
	
	/**
	 * Sets the crew member as infected by space plague.
	 * @param infected   A boolean expression on whether crew member is infected.
	 */
	public void setInfected(boolean infected) {
		super.setInfected(false);
	}
	
	/**
	 * Prints a description of Protected.
	 */
	public static void description() {
		System.out.println("Protected has a good immune system."
				+ "/nProtected can not be infected by to space plague");
	}

}
