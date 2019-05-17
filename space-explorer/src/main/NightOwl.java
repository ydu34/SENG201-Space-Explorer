package main;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Represents a NightOwl type crew member.
 */
public class NightOwl extends CrewMember{
	
	/**
	 * Creates a NightOwl type crew member.
	 * @param name   A string name of the crew member.
	 */
	public NightOwl(String name) {
		super(name, "Night Owl", "Normal", 100, 100, 100, 2,
				8,8,8,8,16,16);
	}
	
}
