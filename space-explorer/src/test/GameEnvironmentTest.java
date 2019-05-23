package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Engineer;
import main.GameEnvironment;
import main.HealthNut;
import main.Nibbler;
import main.NightOwl;

class GameEnvironmentTest {
	private GameEnvironment game;
	
	@BeforeEach 
	void setUp() {
		game = new GameEnvironment();
		game.initialize();
		game.setGameDuration(5);
		game.getCrew().getCrewMembers().add(new Engineer("Bill", ""));
		game.getCrew().getCrewMembers().add(new HealthNut("Carole", ""));
		game.getCrew().getCrewMembers().add(new Nibbler("Noah", ""));
		game.getCrew().getCrewMembers().add(new NightOwl("Kim", ""));
	}

	@Test
	void nextDayTest() {
		game.nextDay();
		assertEquals(2, game.getCurrentDay());

	}

}
