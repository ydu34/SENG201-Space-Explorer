package main;

/**
 * Represents an Explorer type of crew member.
 * 
 * @author Yu Duan
 * @author Joyce Cheah
 */
public class Explorer extends CrewMember {

	/**
	 * Creates an Explorer with the given name and the given image.
	 * 
	 * @param name  A string name of the crew member.
	 * @param image A string image of the crew member.
	 */
	public Explorer(String name, String image) {
		super(name, "Explorer", image, 100, 100, 100, 10, 10, 5, 5, 15, 15);
	}
}
