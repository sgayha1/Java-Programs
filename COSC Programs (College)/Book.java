/*
 * COSC 237 Section 001
 * Skylar Gayhart
 * Due: Wednesday Septemeber 21st
 * Lab7
 * Book, subclass of WrittenItem
 */ 

package Lab7;

public class Book extends WrittenItem {

	public Book() {
		super();
	}
	
	public Book(int id, String t, int cop, String a) {
		super(id, t, cop, a);
	}
	
	
	public boolean equals(Object obj) {
		return(super.equals(obj));
	}
	
	public void addItem() {		
		Book b = new Book();
	}
	
}
