package rooms;

import java.util.ArrayList;

import reservation.*;

public abstract class Room {
	protected ArrayList < String > basicAmenities;
	protected ArrayList < String > specialAmenities;
	protected int capacity;
	protected boolean isAvailable;
	protected ArrayList < Reservation > waitlist;
	
	public Room ( ) {
		basicAmenities = new ArrayList < String > ( );
		specialAmenities = new ArrayList < String > ( );
		capacity = 0;
		isAvailable = false;
		waitlist = new ArrayList < Reservation > ( );
	}
	
	public Room ( ArrayList < String > basicAmenities, ArrayList < String > specialAmenities, int capacity, boolean isAvailable ) {
		this.basicAmenities = basicAmenities;
		this.specialAmenities = specialAmenities;
		this.capacity = capacity;
		this.isAvailable = isAvailable;
	}
	
	// setters
	public void setBasicAmenities ( ArrayList < String > basicAmenities ) {
		this.basicAmenities = basicAmenities;
	}
	
	public void setSpecialAmenities ( ArrayList < String > specialAmenities ) {
		this.specialAmenities = specialAmenities;
	}
	
	public void setCapacity ( int capacity ) {
		this.capacity = capacity;
	}
	
	public void setIsAvailable ( boolean isAvailable ) {
		this.isAvailable = isAvailable;
	}
	
	// getters
	public ArrayList < String > getBasicAmenities ( ) {
		return basicAmenities;
	}
	
	public ArrayList < String > getSpecialAmenities ( ) {
		return specialAmenities;
	}
	
	public int getCapacity ( ) {
		return capacity;
	}
	
	public boolean getIsAvailable ( ) {
		return isAvailable;
	}
	
	public void upgradeAmenities ( String upgrade ) {
		specialAmenities.add ( upgrade );
	}
	
	public boolean reserve ( ) {
		return true;
	}
	
	public void makeAvailable ( ) {
		
	}
	
	// observer pattern methods
	public void addToWaitlist ( Reservation reservation ) {
		waitlist.add ( reservation );
	}
	
	public void removeFromWaitlist ( Reservation reservation ) {
		waitlist.remove ( reservation );
	}
	
	public void contactGuest ( ) {
		
	}
	
	public boolean isAvailable ( Date date ) {
		return true;
	}
	
	public abstract double getCost ( );
}
 