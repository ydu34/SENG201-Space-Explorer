package main;

/**
 * Represents a NightOwl type crew member.
 * @author Yu Duan
 * @author Joyce Cheah
 */
public class NightOwl extends CrewMember{
	
	public NightOwl(String name) {
		super(name, "Night Owl", "", 100, 100, 100, 2,
				5,10,5,10,10,20);
	}
	/**
	 * Creates a NightOwl type crew member.
	 * @param name   A string name of the crew member.
	 * @param image  A string image of the crew member
	 */
	public NightOwl(String name, String image) {
		super(name, "Night Owl", image, 100, 100, 100, 2,
				5,10,5,10,10,20);
	}
	
}
