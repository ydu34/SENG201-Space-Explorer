package test;

import main.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CrewMemberTest {
	private Ship ship;
	private Planet planet;
	private CrewMember crewMember1;
	private CrewMember crewMember2;
	private Crew crew;
	private MedicalItem medicalItem;
	private FoodItem foodItem;
	private MedicalItem antiplague;
	private GameEnvironment game;
	@BeforeEach
	public void init() {
		crew = new Crew();
		ship = crew.getShip();
		planet = new Planet("TestPlanet", "");
		crewMember1 = new CrewMember("Tester1", "None", null);
		crewMember2 = new CrewMember("Tester2", "None", null);
		crew.getCrewMembers().add(crewMember1);
		crew.getCrewMembers().add(crewMember2);
		medicalItem = new MedicalItem("Space Bandages", 20, "Heals 45 health", 45, false);
		crew.getMedicalItems().add(medicalItem);
		antiplague = new MedicalItem("Antiplague", 50, "Cures space plague, heals 20 health.", 20, true);
		crew.getMedicalItems().add(antiplague);
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
	public void testEatFoodRestoreHunger() {
		crewMember1.setHunger(100);
		crewMember1.eat(foodItem, crew);
		assertEquals(80, crewMember1.getHunger());
		assertEquals(1, crewMember1.getActionsLeft());
	}
	
	
	@Test
	public void testEatFoodAt0Hunger() {
		crewMember1.eat(foodItem, crew);
		assertEquals(0, crewMember1.getHunger());
	}
	
	@Test
	public void testUseMedicalItemRestoreHealth() {
		crewMember1.setHealth(10);
		crewMember1.useMedicalItem(medicalItem, crew);
		assertEquals(55, crewMember1.getHealth());
		assertEquals(1, crewMember1.getActionsLeft());
	}
	
	//Test the upper boundary when health is at maximum.
	@Test
	public void testUseMedicalItemAtMaxHealth() {
		crewMember1.useMedicalItem(medicalItem, crew);
		assertEquals(100, crewMember1.getHealth());
	}
	
	@Test
	public void testUseMedicalItemRestorePlague() {
		crewMember1.setInfected(true);
		crewMember1.setStatus("Infected");
		crewMember1.useMedicalItem(antiplague, crew);
		assertFalse(crewMember1.isInfected());
		assertEquals("Normal", crewMember1.getStatus());
	}
	
	@Test
	public void sleepTest1() {
		crewMember1.setFatigue(100);
		crewMember1.sleep();
		assertEquals(70, crewMember1.getFatigue());
	}
	
	@Test
	public void sleepTest2() {
		crewMember1.setFatigue(29);
		crewMember1.sleep();
		assertEquals(0, crewMember1.getFatigue());
	}
	
	@Test 
	public void repairTest1() {
		ship.setShieldLevel(10);
		crewMember1.repair(ship);
		assertEquals(20, ship.getShieldLevel());
		assertEquals(10, crewMember1.getFatigue());
		assertEquals(10, crewMember1.getHunger());
	}
	
	@Test
	public void repairTest2() {
		ship.setShieldLevel(10);
		crewMember1.setFatigue(91);
		crewMember1.setHunger(91);
		crewMember1.repair(ship);
		assertEquals(10, ship.getShieldLevel());
		assertEquals(91, crewMember1.getFatigue());
		assertEquals(91, crewMember1.getHunger());
	}
	
	@Test 
	public void repairTest3() {
		ship.setShieldLevel(10);
		crewMember1.setFatigue(91);
		crewMember1.repair(ship);
		assertEquals(91, crewMember1.getFatigue());
		assertEquals(10, ship.getShieldLevel());
	}
	
	@Test
	public void pilotTest() {
		crewMember1.pilot(planet, crewMember2, crew);
		assertEquals(10, crewMember1.getFatigue());
		assertEquals(10, crewMember1.getHunger());
		assertEquals(10, crewMember2.getFatigue());
		assertEquals(10, crewMember2.getHunger());
		assertEquals(planet, crew.getCurrentLocation());
		assertEquals(1, crewMember1.getActionsLeft());
		assertEquals(1, crewMember2.getActionsLeft());
	}
	
	@Test
	public void testSearchHappens() {
		game = new GameEnvironment();
		game.initFoodItems();
		game.initMedItems();
		crewMember1.search(game.getGameMedicalItems(), game.getGameFoodItems(), crew);
		assertEquals(20, crewMember1.getFatigue());
		assertEquals(20, crewMember1.getHunger());
		assertEquals(1, crewMember1.getActionsLeft());
	}
	
	@Test
	public void testSerachFatigueTooHigh() {
		game = new GameEnvironment();
		game.initFoodItems();
		game.initMedItems();
		crewMember1.setFatigue(81);
		crewMember1.search(game.getGameMedicalItems(), game.getGameFoodItems(), crew);
		assertEquals(2, crewMember1.getActionsLeft());
	}
	
	@Test
	public void testSearchHungerTooHigh() {
		game = new GameEnvironment();
		game.initFoodItems();
		game.initMedItems();
		crewMember1.setHunger(81);
		crewMember1.search(game.getGameMedicalItems(), game.getGameFoodItems(), crew);
		assertEquals(2, crewMember1.getActionsLeft());
	}
	
	
	@Test
	public void engineerSubClassTest() {
		ship.setShieldLevel(10);
		Engineer engineer = new Engineer("Engineer");
		engineer.repair(ship);
		assertEquals(30, ship.getShieldLevel());		
	}
	
	@Test
	public void nibblerSubClassTest() {
		Nibbler nibbler = new Nibbler("Nibbler", null);
		nibbler.setHunger(100);
		nibbler.eat(foodItem, crew);
		assertEquals(70, nibbler.getHunger());
	}
	
	@Test
	public void healthNutsubClassTest() {
		HealthNut healthNut = new HealthNut("Health Nut", null);
		healthNut.setHealth(10);
		healthNut.useMedicalItem(medicalItem, crew);
		assertEquals(65, healthNut.getHealth());
	}
	
}
