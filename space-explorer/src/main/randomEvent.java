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
		if (randomNum >= 0 && randomNum < 35) {
			asteroidBelt(crew);
		}
	}
	
	public static void alienPirates(Crew crew) {
		if (crew.getFoodItems().size() + crew.getMedicalItems().size() > 0) {
			randomNum = ThreadLocalRandom.current().nextInt(0, crew.getFoodItems().size()+crew.getMedicalItems().size());
			if (randomNum < crew.getFoodItems().size()) {
				System.out.println("Alien pirates boarded the ship and stole " + crew.getFoodItems().get(randomNum) + ".");
				System.out.println("\n");
				crew.getFoodItems().remove(randomNum);
			} else {
				int index = randomNum - crew.getFoodItems().size();
				System.out.println("Alien pirates boarded the ship and stole " + crew.getMedicalItems().get(index) + ".");
				System.out.println("\n");
				crew.getMedicalItems().remove(index);
			}
		}
	}
	
	public static void spacePlague(Crew crew) {
		if (crew.getCrewMembers().size() > 0) {
			randomNum = ThreadLocalRandom.current().nextInt(0, crew.getCrewMembers().size());
			CrewMember infectedMember = crew.getCrewMembers().get(randomNum);
			if (!infectedMember.isInfected()) {
				infectedMember.setInfected(true);
				System.out.println(infectedMember.getName() + " has been infected with space plague!");
				
				infectedMember.setHealth(infectedMember.getHealth()-15);
				if (infectedMember.isDead()) {
					System.out.println(infectedMember.getName() + " has died to the space plague and has been removed from the crew.");
					crew.getCrewMembers().remove(infectedMember);
				} else {
					System.out.println(infectedMember.getName() + " will lose 15 health each day until he gets cured.");
					System.out.println(infectedMember.getName() + " now has " + infectedMember.getHealth() + "/" + infectedMember.getMaxHealth() + " health.");
				}
				
			} 
		}
	}
	
	public static void asteroidBelt(Crew crew) {
		int amount = crew.getShip().getShieldLevel() / 4;
		crew.getShip().decreaseShieldLevel(amount);
		System.out.println("This ship went through an asteroid belt and took " + amount + " damage to the shield level.");
		System.out.println("The ship now has " + crew.getShip().getShieldLevel() + "/" + crew.getShip().getMaxShieldLevel() + " shield level.");
	}
}
