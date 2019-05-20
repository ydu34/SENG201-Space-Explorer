package main;
/**
 * Represents a Regular type crew member.
 * @author Yu Duan
 * @author Joyce Cheah
 */
public class Regular extends CrewMember{
	/**
	 * Creates a Regular type crew member.
	 * @param name   A string name of the crew member.
	 */
	public Regular(String name) {
		super(name, "Regular", "Normal", 100, 130, 130, 2);
	}
	
}
