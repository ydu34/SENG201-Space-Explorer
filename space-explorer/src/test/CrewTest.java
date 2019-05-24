package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Crew;

class CrewTest {
	
	private Crew crew;
	
	@BeforeEach
	void setup() { 
		crew = new Crew();
	}
	
	@Test
	void testIncreaseMoney() {
		crew.increaseMoney(100);
		assertEquals(300, crew.getMoney());
	}
	
	@Test
	void testDecreaseMoney() {
		crew.setMoney(0);
		crew.decreaseMoney(100);
		assertEquals(0, crew.getMoney());
		crew.increaseMoney(1000);
		crew.decreaseMoney(100);
		assertEquals(900, crew.getMoney());
	}

}
