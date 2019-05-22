package main;
import java.util.concurrent.ThreadLocalRandom;

public class RandomEvent {
	private static int randomNum;
	
	public static String occurDay(Crew crew) {
		String returnString = ""
;		randomNum = ThreadLocalRandom.current().nextInt(0, 100);
		if (randomNum >= 0 && randomNum < 30) {
			returnString += alienPirates(crew);
		} else if (randomNum >= 30 && randomNum < 60) {
			returnString += spacePlague(crew);
		} 
		return returnString;
	}
	
	
	public static String occurPlanet(Crew crew) {
		randomNum = ThreadLocalRandom.current().nextInt(0, 100);
		if (randomNum >= 0 && randomNum < 40) {
			return asteroidBelt(crew);
		}
		return null;
	}
	
	public static String alienPirates(Crew crew) {
		String returnString = "";
		if (crew.getFoodItems().size() + crew.getMedicalItems().size() > 0) {
			randomNum = ThreadLocalRandom.current().nextInt(0, crew.getFoodItems().size()+crew.getMedicalItems().size());
			if (randomNum < crew.getFoodItems().size()) {
				returnString += "Alien pirates boarded the ship and stole " + crew.getFoodItems().get(randomNum) + ".\n";
				crew.getFoodItems().remove(randomNum);
			} else {
				int index = randomNum - crew.getFoodItems().size();
				returnString += "Alien pirates boarded the ship and stole " + crew.getMedicalItems().get(index) + ".\n";
				crew.getMedicalItems().remove(index);
			}
		}
		return returnString;
	}
	
	public static String spacePlague(Crew crew) {
		String returnString = "";
		if (crew.getCrewMembers().size() > 0) {
			randomNum = ThreadLocalRandom.current().nextInt(0, crew.getCrewMembers().size());
			CrewMember infectedMember = crew.getCrewMembers().get(randomNum);
			if (!infectedMember.isInfected()) {
				infectedMember.setInfected(true);
				returnString += infectedMember.getName() + " has been infected with space plague! \n";
				infectedMember.setStatus("Infected");
				infectedMember.decreaseHealth(20);
				if (infectedMember.isDead()) {
					returnString += infectedMember.getName() + " has died to the space plague and has been removed from the crew.";
					crew.getCrewMembers().remove(infectedMember);
				} else {
					returnString += infectedMember.getName() + " will lose 20 health each day until he gets cured. \n";
					returnString += infectedMember.getName() + " now has " + infectedMember.getHealth() + "/" + infectedMember.getMaxHealth() + " health.";
				}
				
			} 
		}
		return returnString;
	}
	
	public static String asteroidBelt(Crew crew) {
		String returnString = "";
		int amount = crew.getShip().getShieldLevel() / 5 + 10;
		crew.getShip().decreaseShieldLevel(amount);
		returnString += "This ship went through an asteroid belt and took " + amount + " damage to the shield level.\n";
		returnString += "The ship now has " + crew.getShip().getShieldLevel() + "/" + crew.getShip().getMaxShieldLevel() + " shield level.";
		return returnString;
	}
}
