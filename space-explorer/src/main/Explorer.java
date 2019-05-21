package main;

public class Explorer extends CrewMember{
	
	public Explorer(String name) {
		super(name, "Explorer", "", 100, 100, 100, 2,
				10,10,5,5,15,15);
	}
	
	public Explorer(String name, String image) {
		super(name, "Explorer", image, 100, 100, 100, 2,
				10,10,5,5,15,15);
	}
}
