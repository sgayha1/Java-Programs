/*
 * COSC 237 Section 001
 * Skylar Gayhart
 * Due: Wednesday Septemeber 21st
 * Lab7
 * CD, child of MediaItem
 */ 

package Lab7;

public class CD extends MediaItem {
	private String artist;
	private String genre;
	
	public CD() {
		super();
		artist = "";
		genre = "";
	}
	
	public CD(int id, String t, int cop, String a, String g) {
		super(id, t, cop);
		artist = a;
		genre = g;		
	}
	
	public String getArtist() {
		return artist;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public void setDirector(String a) {
		artist = a;
	}
	
	public void setGenre(String g) {
		genre = g;
	}
	
	public boolean equals(Object obj) {
		if(super.equals(obj)) {
			CD c = (CD) obj;
			return artist.equals(c.artist) && genre.equals(c.genre);
		}
		else
			return false;
	}
	
	public String toString() {
		return super.toString() + String.format("Artist: %s\nGenre: %s\n", artist, genre);
	}
	
	public void print() {
		System.out.println(this.toString());
	}
	
	public void addItem() {
		CD c = new CD();
	}
	
	
	
}
