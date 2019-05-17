package main;
/**
 * Represents a Nibbler type crew member.
 */
public class Nibbler extends CrewMember{
	/**
	 * Creates a Nibbler type crew member.
	 * @param name   A string name of the crew member.
	 */
	public Nibbler(String name) {
		super(name, "Nibbler", "Normal", 100, 100, 100, 2,
				10,10,10,10,20,20);
	}
	
	/**
	 * Consumes food items.
	 * @param item   A FoodItem object.
	 * @param crew   A Crew object.
	 */
	public void eat(FoodItem item, Crew crew) {
		super.eat(item, crew);
		super.setHunger(super.getHunger()-10);
	}
	
}
