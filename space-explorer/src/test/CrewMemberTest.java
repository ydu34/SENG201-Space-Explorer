package test;

import main.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CrewMemberTest {
	private Engineer testEngineer;
	private Ship ship;

	@BeforeEach
	public void init() {
		ship = new Ship();
		ship.setShieldLevel(0);
		testEngineer = new Engineer("Dan");
	}

	@Test
	void test() {
		testEngineer.repair(ship);
		assertEquals(20, ship.getShieldLevel());
	}

}
