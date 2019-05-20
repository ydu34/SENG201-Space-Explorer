package test;

import main.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CrewMemberTest {
	private Engineer engineer;
	private Ship ship;
	private CrewMember crewMember1;
	private CrewMember crewMember2;
	private Crew crew;
	private MedicalItem medicalItem;
	private FoodItem foodItem;

	@BeforeEach
	public void init() {
		crew = new Crew();
		crewMember1 = new CrewMember("Tester1", "TestCrewMember");
		crewMember2 = new CrewMember("Tester2", "TestCrewmember");
		crew.getCrewMembers().add(crewMember1);
		crew.getCrewMembers().add(crewMember2);
		medicalItem = new MedicalItem("Space Bandages", 20, "Heals 45 health", 45, false);
		crew.getMedicalItems().add(medicalItem);
		foodItem = new FoodItem("Space soup", 10, "Restore 20 hunger", 20);
		crew.getFoodItems().add(foodItem);
	}
	
	@Test
	public void canPilotTest() {
		assertTrue(crewMember1.canPilot());
		crewMember1.setFatigue(91);
		assertFalse(crewMember1.canPilot());
		crewMember1.setFatigue(0);
		crewMember1.setHunger(91);
		assertFalse(crewMember1.canPilot());
		crewMember1.setHunger(0);
		crewMember1.setActionsLeft(0);
		assertFalse(crewMember1.canPilot());
	}
	
	@Test
	public void isAvailableTest() {
		assertTrue(crewMember1.isAvailable());
		crewMember1.setActionsLeft(1);
		assertTrue(crewMember1.isAvailable());
		crewMember1.setActionsLeft(0);
		assertFalse(crewMember1.isAvailable());
	}
	@Test
	public void eatTest1() {
		
	}
	@Test
	public void useMedicalItemTest1() {
		crewMember1.setHealth(10);
		crewMember1.useMedicalItem(medicalItem, crew);
		assertEquals(55, crewMember1.getHealth());
	}
	
	//Test the upper boundary when health is at maximum.
	@Test
	public void useMedicalItemTest2() {
		crewMember1.useMedicalItem(medicalItem, crew);
		assertEquals(100, crewMember1.getHealth());
	}

	@Test
	void engineerTest() {
		
	}
	
	@Test
	void healthNutTest() {
		
	}
	
	@Test
	void nibblerTest() {
		
	}
	
	@Test 
	void nightOwlTest() {
		
	}
	

}