//Write a Java Program that reads the file "input.txt" and writes all even values from this file into a new file called "output.txt"

import java.util.*; //Scanner
import java.io.*; //Files, FileNotFoundException

public class Lab13_Program2_Version1 {

	public static void main(String[] args) throws FileNotFoundException{ //Throw the FileNotFoundException error
		
		Scanner inputFile = new Scanner(new File("input.txt")); //Creates an object for the already created input.txt file
		
		PrintStream outputFile = new PrintStream(new File("output.txt")); //Creates a text file to write to
		
		int count = 0; //Initialize the count
		
		while(inputFile.hasNext()) //Reads the file
		{
			if(inputFile.hasNextInt()) //Checks if next token is an int
			{
				count++;
				
				int num = inputFile.nextInt(); //Assigns the value of the token to num
			
				if(num%2 == 0) //Checks if number is even
				{
					outputFile.print(num + " "); //Writes to the output file if it is even
				}
			}
			
			else
			{
				inputFile.next(); //Skips token if not an int
			}
		}
		
		Scanner output_File = new Scanner(new File("output.txt"));
		
		if(count>=1) //Checks to see if any integers were found
		{ 
			System.out.println("\nFound " + count + " numbers/file."); //Outputs how many ints in total were found
			System.out.println("\nOpen the file output.txt to get the output.");
			System.out.print("\noutput.txt: ");
			
			while(output_File.hasNext()) //Reads the file 
			{
				int x = output_File.nextInt(); //Assigns the token to x
				System.out.print(x + " "); //Prints the token
			}
		}
			
			else
				System.out.println("The file doesn't contain any integers. Exit Program!"); //Prints if there were no integers
		
		//Closes both files for security 
		outputFile.close();
		inputFile.close(); 
		

		
		
		


	}

}
