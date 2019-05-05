package rooms;

import java.util.ArrayList;

import reservation.*;

public abstract class Room {
	/**
	 * basic amenities of the room
	 */
	protected ArrayList < String > basicAmenities;
	
	/**
	 * special upgraded amenities of the room
	 */
	protected ArrayList < String > specialAmenities;
	
	/**
	 * capacity of the room
	 */
	protected int capacity;
	
	/**
	 * if the room is available or not
	 */
	protected boolean isAvailable;
	
	/**
	 * waitlist of reservations to the room
	 */
	protected ArrayList < Reservation > waitlist;
	
	/**
	 * default constructor
	 */
	public Room ( ) {
		basicAmenities = new ArrayList < String > ( );
		specialAmenities = new ArrayList < String > ( );
		capacity = 0;
		isAvailable = false;
		waitlist = new ArrayList < Reservation > ( );
	}
	
	/**
	 * overloaded constructor
	 * @param basicAmenities - basic amenities of the room
	 * @param specialAmenities - any upgraded amenities
	 * @param capacity - capacity of the room
	 * @param isAvailable - whether the room is available
	 */
	public Room ( ArrayList < String > basicAmenities, ArrayList < String > specialAmenities, int capacity, boolean isAvailable ) {
		this.basicAmenities = basicAmenities;
		this.specialAmenities = specialAmenities;
		this.capacity = capacity;
		this.isAvailable = isAvailable;
	}
	
	// setters
	/**
	 * sets the basic amenities of the room
	 * @param basicAmenities - default amenities
	 */
	public void setBasicAmenities ( ArrayList < String > basicAmenities ) {
		this.basicAmenities = basicAmenities;
	}
	
	/**
	 * sets the special amenities of the room
	 * @param specialAmenities - special amenities
	 */
	public void setSpecialAmenities ( ArrayList < String > specialAmenities ) {
		this.specialAmenities = specialAmenities;
	}
	
	/**
	 * sets the capacity of the room
	 * @param capacity - capacity of the room
	 */
	public void setCapacity ( int capacity ) {
		this.capacity = capacity;
	}
	
	/**
	 * sets whether or not the room is available
	 * @param isAvailable - availability of the room
	 */
	public void setIsAvailable ( boolean isAvailable ) {
		this.isAvailable = isAvailable;
	}
	
	// getters
	/**
	 * gets the basic amenities of the room
	 * @return basic amenities
	 */
	public ArrayList < String > getBasicAmenities ( ) {
		return basicAmenities;
	}
	
	/**
	 * gets the special amenities of the room
	 * @return special amenities
	 */
	public ArrayList < String > getSpecialAmenities ( ) {
		return specialAmenities;
	}
	
	/**
	 * gets the capacity of the room
	 * @return capacity
	 */
	public int getCapacity ( ) {
		return capacity;
	}
	
	/**
	 * gets the current availability of the room
	 * @return current room availability
	 */
	public boolean getIsAvailable ( ) {
		return isAvailable;
	}
	
	/**
	 * upgrades the special amenities to the room
	 * @param upgrade - new special amenity
	 */
	public void upgradeAmenities ( String upgrade ) {
		specialAmenities.add ( upgrade );
	}
	
	/**
	 * tries to reserve the room, and returns whether it was successful or not
	 * @return if reserving was successful
	 */
	public boolean reserve ( ) {
		return true;
	}
	
	/**
	 * makes the room available
	 */
	public void makeAvailable ( ) {
		
	}
	
	// observer pattern methods
	/**
	 * adds a person to the waitlist
	 * @param reservation - person to be added 
	 */
	public void addToWaitlist ( Reservation reservation ) {
		waitlist.add ( reservation );
	}
	
	/**
	 * removes a person from the waitlist
	 * @param reservation - person to be removed
	 */
	public void removeFromWaitlist ( Reservation reservation ) {
		waitlist.remove ( reservation );
	}
	
	/**
	 * lets the guest know when the room is available
	 */
	public void contactGuest ( ) {
		
	}
	
	/**
	 * returns whether the room is available is open at the given dat
	 * @param date - date to see if the room is available
	 * @return whether or not the room is available at the given date
	 */
	public boolean isAvailable ( Date date ) {
		return true;
	}
	
	/**
	 * abstract method that returns the cost of the room
	 * @return cost of the room
	 */
	public abstract double getCost ( );
}
 