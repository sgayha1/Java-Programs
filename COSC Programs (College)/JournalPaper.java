/*
 * COSC 237 Section 001
 * Skylar Gayhart
 * Due: Wednesday Septemeber 21st
 * Lab7
 * JournalPaper, subclass of WrittenItem
 */ 

package Lab7;

import java.util.Scanner;

public class JournalPaper extends WrittenItem{
	private int year;
	private Scanner scan = new Scanner(System.in);
	
	public JournalPaper() {
		super();
		year = 0;
	}
	
	public JournalPaper(int id, String t, int cop, String a, int y) {
		super(id, t, cop, a);
		year = y;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear() {
		year = getInt(scan, "What is the year: ");
	}
	
	public boolean equals(Object obj) {
		if(super.equals(obj)) {
			JournalPaper j = (JournalPaper) obj;
			return year == j.year;
		}
		else
			return false;
	}
	
	public String toString() {
		return super.toString() + String.format("\nYear: %d", year);
	}
	
	public void print() {
		System.out.println(this.toString());
	}
	
	public void addItem() {
		JournalPaper j = new JournalPaper();
	}
}
