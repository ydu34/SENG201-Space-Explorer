package main;
import java.util.*;

public class Crew {
	private String name;
	private Ship ship;
	private ArrayList<CrewMember> crewMembers = new ArrayList<CrewMember>();
	private ArrayList<Item> Inventory;
	private int money;
	private String currentLocation;

	public ArrayList<CrewMember> getCrewMembers() {
		return crewMembers;
	}
	public void setCrewMembers(ArrayList<CrewMember> crewMembers) {
		this.crewMembers = crewMembers;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
