package rooms;

import java.util.ArrayList;

import reservation.*;

public abstract class Room {
	private String amenities;
	private int capacity;
	private boolean isAvailable;
	private ArrayList < Reservation > waitlist;
	
	public Room ( String amenities, int capacity, boolean isAvailable ) {
		
	}
	
	public String getAmenities ( ) {
		return amenities;
	}
	
	public void upgradeAmenities ( String amenities ) {
		
	}
	
	public void setCapacity ( int capacity ) {
		
	}
	
	public int getCapacity ( ) {
		return capacity;
	}
	
	public boolean reserve ( ) {
		return true;
	}
	
	public void makeAvailable ( ) {
		
	}
	
	public abstract double getCost ( );
	
	
	// observer pattern methods
	public void addToWaitlist ( Reservation reservation ) {
		
	}
	
	public void removeFromWaitlist ( Reservation reservation ) {
		
	}
	
	public void contactGuest ( ) {
		
	}
	
	public boolean isAvailable ( Date date ) {
		return true;
	}
}
 