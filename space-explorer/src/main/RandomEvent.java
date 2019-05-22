package main;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Generates random events that can occur when piloting ship to a new planet or moving on to the next day.
 * @author Yu Duan
 * @author Joyce Cheah
 */
public class RandomEvent {
	private static int randomNum;
	
	/**
	 * Decides by chance if any events occur when moving on to the next day.
	 * @param crew   A Crew object.
	 * @return A string message of the event occurred.
	 */
	public static String occurDay(Crew crew) {

		String returnString = "";		
		randomNum = ThreadLocalRandom.current().nextInt(0, 100);
		if (randomNum >= 0 && randomNum < 30) {

			returnString += alienPirates(crew);
		} else if (randomNum >= 30 && randomNum < 60) {
			returnString += spacePlague(crew);
		} 
		return returnString;
	}
	
	/**
	 * Decides by chance if the ship goes through an asteroid belt when piloting ship to a new planet.
	 * @param crew   A Crew object.
	 * @return A string message of the damage caused by the asteroid belt.
	 */
	public static String occurPlanet(Crew crew) {
		randomNum = ThreadLocalRandom.current().nextInt(0, 100);
		if (randomNum >= 0 && randomNum < 40) {
			return asteroidBelt(crew);
		}
		return null;
	}
	
	/**
	 * Encounters alien pirates who steal items on ship.
	 * @param crew   A Crew object
	 * @return A string message of the items stolen by the alien pirates.
	 */
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
	
	/**
	 * Encounters space plague, which decreases the health level of a chosen crew member.
	 * @param crew   A Crew object.
	 * @return A string message of the damage on the chosen crew member caused by the space plague.
	 */
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
	
	/**
	 * Encounters an asteroid belt, which decreases the ship's shield level.
	 * @param crew   A Crew object.
	 * @return A string message of the damage caused by the asteriod belt.
	 */
	public static String asteroidBelt(Crew crew) {
		String returnString = "";
		int amount = crew.getShip().getShieldLevel() / 5 + 10;
		crew.getShip().decreaseShieldLevel(amount);
		returnString += "This ship went through an asteroid belt and took " + amount + " damage to the shield level.\n";
		returnString += "The ship now has " + crew.getShip().getShieldLevel() + "/" + crew.getShip().getMaxShieldLevel() + " shield level.";
		return returnString;
	}
}
