/*
 * COSC 237 Section 001
 * Skylar Gayhart
 * Due: Wednesday Septemeber 23rd
 * Lab3_1
 * Write a Java program to solve the following problem using 1-dim arrays. Given a 1-dim array, create
 * a second array that holds two copies of each value in the original array.
 */ 

import java.util.Random;
import java.util.Scanner;

public class Lab3_1 {

	//Class constants
	private static final int MAX_RANGE = 100; 
	private static final int MIN_RANGE = 1;
	private static Scanner scan = new Scanner(System.in);
	
	//used to test for type errors in input
	public static int getInt(Scanner input, String prompt) {
		System.out.print(prompt);
		//Will continue to loop until input is valid; Checks token
		while (!input.hasNextInt()) {
			input.next();
			System.out.print("Not an integer, try again: \n");
			System.out.print(prompt);
		}
		return input.nextInt();
	}
		
	//fill the array with random values between 1 and 100 (declared as class constants).
	public static void initRand(int[] list, int size, int lower, int upper) { 
		Random rand = new Random(); //Initialize rand object
		for (int i = 0; i < size; i++) 
			list[i] = rand.nextInt(upper - lower + 1) + lower; //Assign each element with a random int.
	}
	
	//Use printf to print elements
	public static void print(int[] list, int size) { 
		for (int i = 0; i < size; i++) {
			System.out.printf(list[i] + " "); }
		System.out.println();
	}
	
	//returns the second array holding two copies of each value in the original array
	public static int[] twice(int[] list, int size) {
		
		int[] twice = new int[size*2];
		
		for (int i = 0; i<size; i++){			
			twice[i*2]=list[i];
			twice[i*2 + 1]=list[i];
		}
			
			
		return twice;
	}
	
	public static void main(String[] args) {
		char start;
		int size;
		int[] list;		
		
		System.out.println("Start? (y/n)\n");
		start = scan.next().charAt(0);
		
		while (start == 'y' || start == 'Y') {	
			size = getInt(scan, "How many elements/array: ");
			
			list = new int [size];
			
			initRand(list, size, MIN_RANGE, MAX_RANGE);
			
			System.out.println("\nThe original array is: ");
			print(list, size);
				
			System.out.println("\nThe second array is: ");		
			
			print(twice(list, size), size*2);
			
			System.out.println("\nDo you want to continue?");
			start = scan.next().charAt(0);
		}

	}

}
