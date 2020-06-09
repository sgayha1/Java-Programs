//Will create a file

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
	
	public void addRecords() { //Adds strings to the file
		
		x.format("%s", "xxxxx \n");
		x.format("%s", "x ");
		x.format("%d", 23);
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
