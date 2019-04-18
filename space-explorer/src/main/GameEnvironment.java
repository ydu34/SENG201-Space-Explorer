package main;
import java.util.ArrayList;
import java.util.Scanner;

public class GameEnvironment {
	private Scanner in = new Scanner(System.in);
	private Scanner enter = new Scanner(System.in);
	private Ship ship = new Ship();
	private String input;
	private int parsedInput;
	private Crew crew = new Crew();
	
	
	public static void main(String[] args) {
		GameEnvironment game = new GameEnvironment();
		game.gameSetUp();
		game.createCrew();
	}
	
	public void gameSetUp() {
		/* Setting up the game */
		System.out.println("Welcome to Space Explorers!");
		System.out.println("Your spaceship has been broken and its pieces are scattered throughout the surrounding planets."
				+ "\nYou will need to find the missing pieces of your spaceship so that you can repair it and get home.");
		System.out.println("How many days (between 3 and 10) do you want to play for?");
		input = in.nextLine();
		int gameDuration = Integer.parseInt(input);
		ship.setPiecesNeeded(gameDuration * 2 / 3);
		int partsToBeFound = ship.getPiecesNeeded();
		System.out.println(partsToBeFound + " missing pieces are scattered throughout the surrounding planets.");
	}
	
	public void createCrew() {
		System.out.println("How many crew members (between 2 and 4) would you like?");
		input = in.nextLine();
		parsedInput = Integer.parseInt(input);
		int crewMemberNeeded = parsedInput; 
		while (crewMemberNeeded != 0) {
			chooseCrewMember();
			crewMemberNeeded-=1;
		}
		System.out.println(crew.getCrewMembers());
	}
	public void chooseCrewMember() {
		ArrayList<CrewMember> crewMembers = crew.getCrewMembers();
		System.out.println("There are 6 different types of crew members: ");
		System.out.println("\t1. Engineer");
		System.out.println("\t2. place holder"); /* Placeholder crew members, need to decide on them */
		System.out.println("\t3. place holder");
		System.out.println("\t4. place holder");
		System.out.println("\t5. place holder");
		System.out.println("\t6. place holder");
		System.out.println("Please select a crew member to recruit to your crew.");
		input = in.nextLine();
		parsedInput = Integer.parseInt(input);
		String selectedCrewMember = "";
		switch(parsedInput) {
		case 1:
			selectedCrewMember = "Engineer";
			Engineer.description();
			break;
		case 2:
			selectedCrewMember = "Placeholder";
			System.out.println("Placeholder");
			break;
		case 3:
			selectedCrewMember = "Placeholder";
			System.out.println("Placeholder");
			break;
		case 4:
			selectedCrewMember = "Placeholder";
			System.out.println("Placeholder");
			break;
		case 5:
			selectedCrewMember = "Placeholder";
			System.out.println("Placeholder");
			break;
		case 6:
			selectedCrewMember = "Placeholder";
			System.out.println("Placeholder");
			break;	
		}
		
		System.out.println("Recruit " + selectedCrewMember + "? (Y/N)");
		input = in.nextLine();
		switch(input) {
		case("Y"):
			System.out.println("Name your crew: ");
			input = in.nextLine();
			String name = input;
			if (selectedCrewMember == "Engineer") {
				crewMembers.add(new Engineer(name));
			}
			break;
		case("N"):
			chooseCrewMember();
			break;
		}
	}
	
}
