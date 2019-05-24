package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Crew;
import main.FoodItem;
import main.MedicalItem;
import main.SpaceOutpost;

class SpaceOutpostTest {
	private SpaceOutpost spaceOutpost;
	private MedicalItem antiplague;
	private FoodItem galaxySteak;
	private Crew crew;
	
	@BeforeEach 
	void setUp() {
		crew = new Crew();
		spaceOutpost = new SpaceOutpost();
		antiplague = new MedicalItem("Antiplague", 50, "Cures space plague, heals 20 health.", 20, true);
		spaceOutpost.getMedicalItems().add(antiplague);
		galaxySteak = new FoodItem("Galaxy steak", 70, "Restore 80 hunger", 80);
		spaceOutpost.getFoodItems().add(galaxySteak);
	}
	
	@Test
	void testPurchaseMedicalItem() {
		spaceOutpost.purchaseMedicalItem(antiplague, crew);
		assertEquals(150, crew.getMoney());
		assertEquals(0, spaceOutpost.getMedicalItems().size());
	}
	
	@Test
	void testPurchaseFoodItem() {
		spaceOutpost.purchaseFoodItem(galaxySteak, crew);
		assertEquals(130, crew.getMoney());
		assertEquals(0, spaceOutpost.getFoodItems().size());
	}

}
