package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Crew;
import main.CrewMember;
import main.FoodItem;
import main.MedicalItem;
import main.RandomEvent;

class RandomEventTest {
	private Crew crew;
	private CrewMember crewMember1;
	private MedicalItem medicalItem;
	private FoodItem foodItem;
	
	@BeforeEach 
	void setUp() {
		crew = new Crew();
		crewMember1 = new CrewMember("Tester1", "None", "");
		crew.getCrewMembers().add(crewMember1);
	}
	
	@Test
	void testSpacePlagueInfectsCrewMember() {
		RandomEvent.spacePlague(crew);
		assertTrue(crew.getCrewMembers().get(0).isInfected());
		assertEquals(80, crew.getCrewMembers().get(0).getHealth());
	}
	
	@Test
	void testSpacePlagueKillsCrewMember() {
		crew.getCrewMembers().get(0).setHealth(1);
		RandomEvent.spacePlague(crew);
		assertTrue(crew.getCrewMembers().isEmpty());	
	}
	
	@Test
	void testSpacePlagueDoesntInfectInfectedCrewMember() {
		crew.getCrewMembers().get(0).setHealth(80);
		crew.getCrewMembers().get(0).setInfected(true);
		RandomEvent.spacePlague(crew);
		assertEquals(80, crew.getCrewMembers().get(0).getHealth());
	}
	
	@Test 
	void testAlienPirateStealsMedicalItem() {
		medicalItem = new MedicalItem("Space Bandages", 20, "Heals 45 health", 45, false);
		crew.getMedicalItems().add(medicalItem);
		RandomEvent.alienPirates(crew);
		assertTrue(crew.getMedicalItems().isEmpty());
	}
	
	@Test 
	void testAlienPirateStealsFoodItem() {
		foodItem = new FoodItem("Space soup", 10, "Restore 20 hunger", 20);
		crew.getFoodItems().add(foodItem);
		RandomEvent.alienPirates(crew);
		assertTrue(crew.getFoodItems().isEmpty());
	}
	
	@Test
	void testAsteroidBeltDamagesShip() {
		RandomEvent.asteroidBelt(crew);
		assertTrue(crew.getShip().getShieldLevel()<crew.getShip().getMaxShieldLevel());
	}
}
