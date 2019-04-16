package main;
import java.util.Scanner;

public class GameEnvironment {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		
		
		System.out.println("Welcome to Space Explorers!");
		System.out.println("Your spaceship has been broken and its pieces are scattered throughout the surrounding planets."
				+ "\nYou will need to find the missing pieces of your spaceship so that you can repair it and get home.");
		System.out.println("How many days (between 3 and 10) do you want to play for?");
		String input = in.nextLine();
		int gameDuration = Integer.parseInt(input);
		int partsToBeFound = gameDuration * 2 / 3;
		System.out.println(partsToBeFound + " missing pieces are scattered throughout the surrounding planets.");
		
		boolean crewCreation = true;
		int parsedInput = Integer.parseInt(input);
		System.out.println("How many crew members (between 2 and 4) would you like?");
		input = in.nextLine();
		parsedInput = Integer.parseInt(input);
		int crewMemberNeeded = parsedInput; 
		/* Shows the player the types of crew and ask them to select crew members until they have 4 */
		int crewMemberCount = 0; /* the number of crew member that has been created */
		CREWCREATION:
		while (crewCreation) {
			
			System.out.println("There are 6 different types of potential crew members: ");
			System.out.println("\t1. Engineer");
			System.out.println("\t2. place holder"); /* Placeholder crew members, need to decide on them */
			System.out.println("\t3. place holder");
			System.out.println("\t4. place holder");
			System.out.println("\t5. place holder");
			System.out.println("\t6. place holder");
			System.out.println("Please select a crew member.");
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
			System.out.println("Do you want to create an " + selectedCrewMember + "? (Y/N)");
			input = in.nextLine();
			if (input == "Y") {
				System.out.println("What is the crew member's name?");
				input = in.nextLine();
				
			}
			crewMemberCount++;
			if (crewMemberCount == crewMemberNeeded) {
				crewCreation = false;
			}
		}
			
		
		
	}
}
