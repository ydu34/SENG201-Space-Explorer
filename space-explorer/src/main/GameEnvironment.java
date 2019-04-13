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
		int numberOfCrewMembers;
		System.out.println("How many crew members (between 2 and 4) would you like?");
		input = in.nextLine();
		parsedInput = Integer.parseInt(input);
		numberOfCrewMembers = parsedInput;
		CREWCREATION:
		while (crewCreation) {
			
			System.out.println("There are 6 different types of potential crew members: ");
			System.out.println("\t1. Engineer");
			System.out.println("\t2. place holder");
			System.out.println("\t3. place holder");
			System.out.println("\t4. place holder");
			System.out.println("\t5. place holder");
			System.out.println("\t6. place holder");
			System.out.println("Enter a number to learn more about the crew member.");
			input = in.nextLine();
			parsedInput = Integer.parseInt(input);
			switch(parsedInput) {
			case 1:
				Engineer.description();
				break;
			}
			System.out.println("\t1. Learn about other crew members.");
			System.out.println("\t2. Choose crew members.");
			input = in.nextLine();
			parsedInput = Integer.parseInt(input);
			switch(parsedInput) {
			case 1:
				continue CREWCREATION;
			}

						
		}
		
		
	}
}
