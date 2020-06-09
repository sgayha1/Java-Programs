//Skylar Gayhart April 2020

//Will create a file in the directory the given project is in

import java.io.*;
import java.lang.*;
import java.util.*;

public class createFile {

	private Formatter x; //Creates
	
	public void openFile() { //Opens the file and creates it if not there
		try {
			x = new Formatter ("input.txt");
			System.out.println("File has been opened"); //Lets the user know that the file was opened
		}
		catch(Exception e) { //Catches an error 
			System.out.println("You have an error");
		}
	}
	
	public void addRecords() { //Adds strings to the file/Can be modified
		
		x.format("%s", "xxxxx \n"); //String value
		x.format("%s", "x ");
		x.format("%d", 23); //A number
		x.format("%s", "x ");
		x.format("%s", "hi ");
		x.format("%s", "xx ");
		x.format("%s", "x ");
		x.format("%s", "x ");
		x.format("%s", "x ");
		x.format("%s", "x");
		
	
	}
	
	public void closeFile() { //Closes file in case the compiler does not automaticlaly close it (For security)
		x.close();
	}
	
}
