/*
 * COSC 237 Section 001
 * Skylar Gayhart
 * Due: Wednesday Septemeber 21st
 * Lab7
 * MediaItem, parent of Video and CD
 */ 

package Lab7;

public abstract class MediaItem extends Item {
	
	public MediaItem() {
		super();
	}
	
	public MediaItem(int id, String t, int cop) {
		super(id, t, cop);
	}
	
	public boolean equals(Object obj) {
		if(super.equals(obj)) {
			return true;
		}
		else
			return false;
	}
	
	public abstract void addItem();
	
}
