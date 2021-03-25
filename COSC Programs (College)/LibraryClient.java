/*
 * COSC 237 Section 001
 * Skylar Gayhart
 * Due: Wednesday Septemeber 21st
 * Lab7
 * Client for Item and subclasses
 */ 

package Lab7;

public class LibraryClient {

	public static void main(String[] args) {
	
		Book b = new Book(3841, "The Great Gatsby", 7, "Francis Scott Key Fitzgerald");
		
		System.out.println(b);
		b.checkOut();
		b.checkOut();
		System.out.println("After two people checked out the book, the new number of copies is " + b.getCopies());
		b.checkIn();
		System.out.println("After checking in a book, the new number of copies is " + b.getCopies());
		System.out.println();
		
		JournalPaper j = new JournalPaper(4192, "A New World", 2, "Lisa Sinton", 2020);
		System.out.println(j);
		for(int i = 0; i < 2; i++)
			j.checkOut();
		System.out.println("\nAfter two check outs:");
		System.out.println(j);
		System.out.println();
		
		Video v = new Video(8274, "Scoob!", 20, "Tony Cervone", "Adventure", 2020);
		System.out.println(v);
		v.setYear();
		v.setGenre("Horror");
		for(int i = 1; i <= 15; i++) 
			v.checkOut();
		for(int i = 1; i <= 5; i++)
			v.checkIn();
		System.out.println("\nAfter adjustments, the new information is: ");
		System.out.println(v);
		System.out.println();
		
		CD c = new CD(2341, "Trilogy", 3, "The Weeknd", "R&B");
		System.out.println(c);
		c.setCopies();
		c.setGenre("Hip-Hop");
		System.out.println("\nAfter some adjustments, the new information for the CD is: ");
		System.out.println(c);
		System.out.println();
		
		System.out.println("The items we have in are the following:");
		System.out.println();
		System.out.println(b);
		System.out.println();
		System.out.println(j);
		System.out.println();
		System.out.println(v);
		System.out.println();
		System.out.println(c);
	}
	
}
