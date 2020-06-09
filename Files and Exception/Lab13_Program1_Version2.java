//Write a Java program that reads the file "input.txt" and calculates and prints the average of all integer numbers in this file.
//Try catch

import java.io.*;
import java.util.Scanner;

public class Lab13_Program1_Version2 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in); //Scanner for input
		Scanner inputFile = null; //Declares another Scanner object for later
		boolean fileOpened = true; //To later check if it is closed when error
		
		System.out.println("Please input the name of the file to be opened: "); //User input for the file name
		String file = scan.nextLine();
		
		try 
		{
			inputFile = new Scanner(new File(file)); //Tries to find the file in the directory
		}
		
		catch (Exception e) //If cannot find the file or any other error
		{
		    System.out.println("--- File Not Found! ---");
		    fileOpened = false; //closes so the rest of the code does not run
		}
		
		if(fileOpened) //Executes if file was found
		{
			int total = 0, count = 0; //Instatiations of variables
			double average;

			while(inputFile.hasNext()) //Reads the file space by space
			{
				if(inputFile.hasNextInt())  //If token is an integer value
				{
				count++; //Add to the count
				int num = inputFile.nextInt(); //Assign the token to num
				System.out.println("Number # " + count + " is: " + num); //Outprint the number
				total+= num; //Add num to the total
				}
				
				else
				{
					inputFile.next(); //Skips token if not an int
				}
			}

			average = (double)total/count; //Caculates the average
			average = Math.ceil(average*100)/100; //Rounds the average
			
			if(count>=1) //If a int is found and accounted for
			System.out.println("\nThe average of " + count + " numbers/file = " + average); //Prints average
			
			else
				System.out.println("The file doesn't contain any integers. Exit Program!"); //If not ints are found
			
			inputFile.close(); //Close file for security
		}
		
	}

}
