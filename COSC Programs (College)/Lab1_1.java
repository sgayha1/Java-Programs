/*
 * COSC 237 Section 001
 * Skylar Gayhart
 * Due: Wednesday Septemeber 9th
 * Lab1_1
 * Two Digit Game Play. Number has to be between 10-99 and has to be of type int and different digits
 */ 

import java.util.Scanner;

public class Lab1_1 {
	
	public static Scanner input = new Scanner (System.in);
	public static String promptGet = "Enter a 2-digit number (different digits). Zero to stop: ";
	
	//Input validation
	public static int getInt(Scanner input, String prompt) {
		System.out.print(prompt);
		//Will continue to loop until input is valid; Checks token
		while (!input.hasNextInt()) {
			input.next();
			System.out.print("Not an integer, try again: ");
		}
		return input.nextInt();
	}
	
	//Sees if digit entered is in the given range (10-99)
	public static int checkRange(int digits, String prompt) {
		while((digits < 10 || digits > 99) && digits != 0){
			System.out.println(prompt);
			digits = getInt(input, promptGet);
		}
		return digits;
	}
		
	
	public static void main(String[] args) {
		
	//Instantiations and declarations
	int digits = -1;
	String promptRange = "NOT good for your game!";
	
	//Loops until 0 is entered 
	while(digits != 0) {	
		digits = getInt(input, promptGet);
		digits = checkRange(digits, promptRange);
		
		//Checks if the digits are the same
		if(digits%11 != 0)
			System.out.println("Good for your game! Play!");
		else if(digits != 0)
			System.out.println(promptRange);
		}
	
	}

	
	
}
	

