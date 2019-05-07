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
	 * status of the room
	 */
	protected String status;
	
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
		status = "Reserved";
		waitlist = new ArrayList < Reservation > ( );
	}
	
	/**
	 * overloaded constructor
	 * @param specialAmenities - any upgraded amenities
	 * @param capacity - capacity of the room
	 * @param status - status of the room
	 */
	public Room ( ArrayList < String > specialAmenities, boolean isAvailable, String status ) {
		basicAmenities = new ArrayList < String > ( );
		capacity = 0;
		this.specialAmenities = specialAmenities;
		this.isAvailable = isAvailable;
		this.status = status;
		waitlist = new ArrayList < Reservation > ( );
	}
	
	// setters
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
	
	/**
	 * sets the status of the room
	 * @param status - status of the room
	 */
	public void setStatus ( String status ) {
		this.status = status;
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
	 * gets the status of the room
	 * @return status of the room
	 */
	public String getStatus ( ) {
		return status;
	}
	
	/**
	 * returns the waitlist of reservations
	 * @return waitlist
	 */
	public ArrayList < Reservation > getWaitlist ( ) {
		return waitlist;
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
		isAvailable = true;
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
		Reservation nextReservation = waitlist.get ( 0 );
		nextReservation.finalizeReservation ( );
		removeFromWaitlist ( nextReservation );
	}
	
	/**
	 * returns whether the room is available is open at the given date
	 * abstract because each room has a different cleanup/setup time
	 * @param date - date to see if the room is available
	 * @param startTime - start time of the reservation
	 * @param endTime - end time of the reservation
	 * @return whether or not the room is available at the given date
	 */
	public abstract boolean isAvailable ( Date date, Time startTime, Time endTime );
	
	/**
	 * abstract method that returns the cost of the room
	 * @return cost of the room
	 */
	public abstract double getCost ( );
}
 