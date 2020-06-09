//Write a Java Program that reads the file "input.txt" and writes all even values from this file into a new file called "output.txt"

import java.io.*; //File class
import java.util.Scanner; //Scanner

public class Lab13_Program2_Version2 {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in); //Scanner for input
		Scanner inputFile = null; //Declares another Scanner object for later
		Scanner output_File = null;
		boolean fileOpened = true; //To later check if it is closed when error
		PrintStream outputFile = null;
		
		System.out.println("Please input the name of the file to be opened: "); //User input for the file name
		String file = scan.next();
		
		int count = 0; //Initialize the count
		
		//Try/catch to make sure the user inputted file exists
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
		
			try //Making sure the file exists
			{
				outputFile= new PrintStream(new File("output.txt"));
			}
		
			catch(FileNotFoundException e)
			{
				System.out.println("Error opening the file output.txt");
				System.exit(0);
			}
		
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
		
			try {
				output_File = new Scanner(new File("output.txt"));
			} 
			catch (Exception e) {
				System.out.print("Error!");
			}
		
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
			
			output_File.close();
			inputFile.close(); 
			
			}
		
		

	}

}
