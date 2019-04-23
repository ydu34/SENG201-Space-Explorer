package main;
import java.util.concurrent.ThreadLocalRandom;

public class randomEvent {
	private static int randomNum;
	
	public static void occurDay(Crew crew) {
		randomNum = ThreadLocalRandom.current().nextInt(0, 100);
		if (randomNum >= 0 && randomNum < 20) {
			alienPirates(crew);
		} else if (randomNum >= 20 && randomNum < 40) {
			spacePlague(crew);
		} 
	}
	
	
	public static void occurPlanet(Crew crew) {
		randomNum = ThreadLocalRandom.current().nextInt(0, 100);
		if (randomNum >= 0 && randomNum < 20) {
			asteroidBelt(crew);
		}
	}
	
	public static void alienPirates(Crew crew) {
		randomNum = ThreadLocalRandom.current().nextInt(0, crew.getFoodItems().size()+crew.getMedicalItems().size());
		if (randomNum < crew.getFoodItems().size()) {
			System.out.println("Alien pirates boarded the ship and stole " + crew.getFoodItems().get(randomNum) + ".");
			crew.getFoodItems().remove(randomNum);
		} else {
			int index = randomNum - crew.getFoodItems().size();
			System.out.println("Alien pirates boarded the ship and stole " + crew.getMedicalItems().get(index) + ".");
			crew.getMedicalItems().remove(index);
		}
	}
	
	public static void spacePlague(Crew crew) {
		randomNum = ThreadLocalRandom.current().nextInt(0, crew.getCrewMembers().size());
		if (!crew.getCrewMembers().get(randomNum).isInfected()) {
			crew.getCrewMembers().get(randomNum).setInfected(true);
			System.out.println(crew.getCrewMembers().get(randomNum) + " has been infected with space plageu!");
		} 
	}
	
	public static void asteroidBelt(Crew crew) {
		int amount = crew.getShip().getShieldLevel() / 4;
		crew.getShip().decreaseShieldLevel(amount);
		System.out.println("This ship went through an asteroid belt and took " + amount + " damage to the shield level.");
		System.out.println("The ship now has " + crew.getShip().getShieldLevel() + "/" + crew.getShip().getShieldLevel() + "shield level.");
	}
}
