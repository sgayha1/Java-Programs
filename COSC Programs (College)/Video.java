/*
 * COSC 237 Section 001
 * Skylar Gayhart
 * Due: Wednesday Septemeber 21st
 * Lab7
 * Video, child of MediaItem
 */ 

package Lab7;

import java.util.Scanner;

public class Video extends MediaItem{
	private String director;
	private String genre;
	private int year;
	private Scanner scan = new Scanner(System.in);
	
	public Video() {
		super();
		director = "";
		genre = "";
		year = 0;
	}
	
	public Video(int id, String t, int cop, String d, String g, int y) {
		super(id, t, cop);
		director = d;
		genre = g;
		year = y;
		
	}
	
	public String getDirector() {
		return director;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setDirector(String d) {
		director = d;
	}
	
	public void setGenre(String g) {
		genre = g;
	}
	
	public void setYear() {
		year = getInt(scan, "What is the year released? ");
	}
	
	public boolean equals(Object obj) {
		if(super.equals(obj)) {
			Video v = (Video) obj;
			return director.equals(v.director) && genre.equals(v.genre) && year == v.year;
		}
		else
			return false;
	}
	
	public String toString() {
		return super.toString() + String.format("Director: %s\nGenre: %s\nYear: %d\n", director, genre, year);
	}
	
	public void print() {
		System.out.println(this.toString());
	}
	
	public void addItem() {
		Video v = new Video();
	}
	
}
	

