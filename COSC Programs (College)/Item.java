/*
 * COSC 237 Section 001
 * Skylar Gayhart
 * Due: Wednesday Septemeber 21st
 * Lab7
 * Master class for the library/parent of all
 */ 

package Lab7;

import java.util.Scanner;

public abstract class Item {
	private int identNum;
	private String title;
	private int copies;
	private Scanner input = new Scanner(System.in);
	
	public Item() {
		identNum = 0;
		title = "";
		copies = 0;
	}
	
	public Item(int id, String t, int cop) {
		identNum = id;
		title = t;
		copies = cop;
	}
	
	public int getIdentNum() {
		return identNum;
	}
	
	public String getTitle() {
		return title;
	}
	
	public int getCopies() {
		return copies;
	}
	
	public void setCopies() {
		copies = getInt(input, "Number of copies: ");
	}
	
	public void setIdentNum() {
		identNum = getInt(input, "New Idenitification Number: ");
	}
	
	public void setTitle(String t) {
		title = t;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Item) {
			Item i = (Item) obj;
			return identNum == i.identNum && title.equals(((Item) obj).title) && copies == i.copies;
		}
		else
			return false;
	}
	
	public static int getInt(Scanner input, String prompt) {
		System.out.print(prompt);
		//Will continue to loop until input is valid; Checks token
		while (!input.hasNextInt()) {
			input.next();
			System.out.print("WRONG TYPE! Not an integer! REENTER: \n");
			System.out.print(prompt);
		}
		return input.nextInt();
		
	}
	
	public void print() {
		System.out.println(toString());
	}
	
	public String toString() {
		return String.format("ID: %d\nTitle: %s\nCopies: %d\n", identNum, title, copies);
	}
	
	public void checkIn() {
		copies++;
	}
	
	public void checkOut() {
		if(copies <= 0) {
			System.out.println("No copies avaliable to check out");
		}
		else
			copies--;
	}
	
	public abstract void addItem();
}
