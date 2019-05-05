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
		super(name, "NightOwl", "Normal", 100, 100, 100, 2);
	}
	
	/**
	 * Repairs the ship.
	 * @param ship   A Ship object.
	 */
	public void repair(Ship ship) {
		int fatigueCost = 8;
		if (super.getFatigue() + fatigueCost > super.getMaxFatigue()) {
			System.out.println(super.getName() + " is too tired to repair the ship.");
		} else { 
			int shieldLevel = ship.getShieldLevel();
			int maxShieldLevel = ship.getMaxShieldLevel();
			shieldLevel += 10;
			if (shieldLevel > maxShieldLevel) {
				shieldLevel = maxShieldLevel;
			}
			super.setActionsLeft(super.getActionsLeft()-1);
			super.setFatigue(super.getFatigue()+fatigueCost);
			System.out.println("The ship's shield is now " + shieldLevel + "/" +maxShieldLevel);
		}
	}
	
	/**
	 * Searches the planet for items.
	 * @param medicalItems   An ArrayList of medical items.
	 * @param foodItems      An ArrayList of food items.
	 * @param crew           A Crew object.
	 * @param ship           A Ship object.
	 * 
	 */
	public void search(ArrayList<MedicalItem> medicalItems, ArrayList<FoodItem> foodItems, Crew crew, Ship ship) {
		int fatigueCost = 16;
		int hungerCost = 20;
		if (super.getFatigue() + fatigueCost > super.getMaxFatigue()) {
			System.out.println(super.getName() + " is too tired to search the planet.");
		}
		if (super.getHunger() + hungerCost > super.getMaxHunger()) {
			System.out.println(super.getName() + " is too hungry to search the planet.");
		}
		if (super.getFatigue() + fatigueCost <= super.getMaxFatigue() && super.getHunger() + hungerCost <= super.getMaxHunger()) {
			int randomNum = ThreadLocalRandom.current().nextInt(0, 100);
			if (randomNum >= 0 && randomNum < 20 && !crew.getCurrentLocation().isShipPieceFound()) {
				System.out.println(super.getName() + " has found a ship piece!");
				crew.getCurrentLocation().setShipPieceFound(true);
				ship.foundPiece();
			} else if (randomNum >= 20 && randomNum < 35) {
				randomNum = ThreadLocalRandom.current().nextInt(0, medicalItems.size());
				crew.getMedicalItems().add(medicalItems.get(randomNum));
				System.out.println(super.getName() + " has found a medical item " + medicalItems.get(randomNum) + "!");
			} else if (randomNum >= 35 && randomNum < 50) {
				randomNum = ThreadLocalRandom.current().nextInt(0, foodItems.size());
				crew.getFoodItems().add(foodItems.get(randomNum));
				System.out.println(super.getName() + " has found a food item " + foodItems.get(randomNum) + "!");
			} else if (randomNum >= 50 && randomNum < 65) {
				int amount = 50;
				crew.increaseMoney(amount);
				System.out.println(super.getName() + "has found " + amount + " Coins.");
			} else {
				System.out.println(super.getName() + " has found nothing.");
			}
			super.setActionsLeft(super.getActionsLeft()-1);
			super.setFatigue(super.getFatigue()+fatigueCost);
			super.setHunger(super.getHunger()+hungerCost);
		}
	}
	
	
	/**
	 * Prints a description of NightOwl.
	 */
	public static void description() {
		System.out.println("NightOwl does not like sleeping." 
				+ "/nNightOwl's fatigue level increases by a slower rate when repairing ships and searching on planets.");
		
	}

}
