//Write a Java program that reads the file "input.txt" and calculates and prints the average of all integer numbers in this file
//Throw

import java.io.*;
import java.text.DecimalFormat; //For the rounding
import java.util.*;


public class Lab13_Program1_Version1 {

	public static void main(String[] args) 
				throws FileNotFoundException{ //Throw the FileNotFoundException
		
		Scanner inputFile = new Scanner(new File("input.txt")); //Create an input for the new file and create an object as the specific file
		
		int total = 0, count = 0;
		double average;

		while(inputFile.hasNext()) //Reads the file
		{			
			if(inputFile.hasNextInt()) //Checks if next token is an int
			{
			count++; //Adds to the count
			int num = inputFile.nextInt(); //Assigns the value of the token to num
			System.out.println("Number # " + count + " is: " + num); //Outputs the number
			total+= num; //Adds the number to the total
			}
			
			else
			{
				inputFile.next(); //Skips token if not an int
			}
		}

		average = (double)total/count; //Caclculates the average
		average = Math.ceil(average*100)/100; //Makes sure it rounds up two decimal places
		
		if(count>=1) //Checks to see if any integers were found
		System.out.println("\nThe average of " + count + " numbers/file = " + average); //Outputs the average if integers were in the file
		
		else
			System.out.println("The file doesn't contain any integers. Exit Program!"); //Prints if there were no integers
		
		inputFile.close(); //Closes the file for security

	}

}
