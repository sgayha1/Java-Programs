/*
 * COSC 237 Section 001
 * Skylar Gayhart
 * Due: Wednesday Septemeber 21st
 * Lab7
 * WrittenItem class, parent of Book and JournalPaper
 */ 

package Lab7;

public abstract class WrittenItem extends Item {
	private String author;
	
	public WrittenItem() {
		super();
		author = "";
	}
	
	public WrittenItem(int id, String t, int cop, String a) {
		super(id, t, cop);
		author = a;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String a) {
		author = a;
	}
	
	public boolean equals(Object obj) {
		if(super.equals(obj)) {
			WrittenItem w = (WrittenItem) obj;
			return author == w.author;
		}
		else
			return false;
	}
	
	public String toString() {
		return super.toString() + String.format("Author: %s", author);
	}
	
	public void print() {
		System.out.println(this.toString());
	}
	
	public abstract void addItem();
	
}
