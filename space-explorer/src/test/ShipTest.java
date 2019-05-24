package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Ship;

class ShipTest {
	private Ship ship;
	@BeforeEach
	void setUp() {
		ship = new Ship();
	}
	
	@Test
	void testPartFoundTest() {
		ship.foundPart();
		assertEquals(1, ship.getPartsFound());
	}
	
	@Test
	void testIncreaseShieldLevel() {
		ship.increaseShieldLevel(10);
		assertEquals(100, ship.getShieldLevel());
	}
	
	@Test
	void testDecreaseShieldLevelShipDestroyed1() {
		ship.setShieldLevel(1);
		ship.decreaseShieldLevel(10);
		assertEquals(0, ship.getShieldLevel());
		assertTrue(ship.isDestroyed());
	}
	
	@Test
	void testDecreaseShieldLevelShipDestryoed2() {
		ship.setShieldLevel(10);
		ship.decreaseShieldLevel(10);
		assertEquals(0, ship.getShieldLevel());
		assertTrue(ship.isDestroyed());
	}

}
