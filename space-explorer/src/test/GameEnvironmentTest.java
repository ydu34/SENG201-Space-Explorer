package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.CrewMember;
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
		game.setGameDuration(10);
		game.getCrew().getCrewMembers().add(new Engineer("Bill", ""));
		game.getCrew().getCrewMembers().add(new HealthNut("Carole", ""));
		game.getCrew().getCrewMembers().add(new Nibbler("Noah", ""));
		game.getCrew().getCrewMembers().add(new NightOwl("Kim", ""));
		game.getShip().setPiecesNeeded(6);
	}

	@Test
	void nextDayTest() {
		game.nextDay();
		assertEquals(2, game.getCurrentDay());
	}
	
	@Test 
	void gameOverTest1() {
		game.setCurrentDay(10);
		assertEquals(true, game.gameOver());
		game.setCurrentDay(9);
		assertEquals(false, game.gameOver());
		game.setCurrentDay(11);
		assertEquals(true, game.gameOver());
	}
	
	@Test
	void gameOverTest2() {
		game.getShip().setPiecesFound(6);
		assertEquals(true, game.gameOver());
		game.getShip().setPiecesFound(5);
		assertEquals(false, game.gameOver());
	}
	
	@Test
	void gameOverTest3() {
		game.getCrew().setCrewMembers(new ArrayList<CrewMember>());
		assertEquals(true, game.gameOver());
	}
	
	@Test
	void gameOverTest4() {
		game.getShip().setDestroyed(true);
		assertEquals(true, game.gameOver());
	}

}
