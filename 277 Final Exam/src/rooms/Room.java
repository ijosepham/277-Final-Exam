package rooms;

import java.util.ArrayList;

import reservation.*;

public abstract class Room {
	/**
	 * room type
	 */
	protected String name;
	
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
	 * current reservations
	 */
	protected ArrayList < Reservation > reservations;
	
	/**
	 * represents the prep time the room needs to setup/cleanup
	 */
	protected int prepTime;
	
	/**
	 * default constructor
	 */
	public Room ( ) {
		basicAmenities = new ArrayList < String > ( );
		specialAmenities = new ArrayList < String > ( );
		capacity = 0;
		isAvailable = false;
		status = "Reserved";
		reservations = new ArrayList < Reservation > ( );
		waitlist = new ArrayList < Reservation > ( );
		prepTime = 0;
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
	 * returns the room type
	 * @return room type
	 */
	public String getName ( ) {
		return name;
	}
	
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
		System.out.println ( "Hello, " + nextReservation.getGuest ( ) + ". The room is now available." );
		nextReservation.finalizeReservation ( );
		removeFromWaitlist ( nextReservation );
	}
	
	/**
	 * returns whether or not the given date and time is available for registration
	 * @param date - date of wanted reservation
	 * @param startTime - start time of wanted reservation
	 * @param endTime - end time of wanted reservation
	 * @return whether the date is available for reservation
	 */
	public boolean isAvailable ( Reservation r ) {
		if ( isAvailable ) {
			System.out.println ( "Your room is available at the given date and time." );
			isAvailable = false;
			status = "Reserved for Party.";
			reservations.add ( r );
			return true;
		} else {
			Reservation r1;
			
			// go through reservations
			for ( int i = 0; i < reservations.size ( ); i++ ) {
				r1 = reservations.get ( i );
				
				// if the dates are the same, then check the times
				if ( r1.getDate ( ) == r.getDate ( ) ) {
					
					// 1/2 hour cleanup, 1/2 hour setip. 1hour gap total
					
					// if the given start time is in between any reservation, then its not available
					boolean a = ( r1.getStartTime ( ).compareTo ( r.getStartTime ( ) ) - prepTime ) < 0;
					boolean b = ( r1.getEndTime ( ).compareTo ( r.getStartTime ( ) ) +  ( prepTime * 2 ) ) > 0;
					boolean c = ( r1.getStartTime ( ).compareTo ( r.getEndTime ( ) ) - ( prepTime * 2 ) ) < 0;
					boolean d = ( r1.getEndTime ( ).compareTo ( r.getEndTime ( ) ) + prepTime ) > 0;
					
					if ( ( a && b ) || ( c && d ) ) {
						System.out.println ( "Your room is not available at the given date and time." );
						System.out.println ( "Would you  like to be waitlisted? " );
						waitlist.add ( r );
						System.out.println ( "Waitlisted." );
						return false;
					}
				}
			}
			
			// go through each reservation in the waitlist
			for ( int i = 0; i < waitlist.size ( ); i++ ) {
				// get the reservation
				r1 = waitlist.get ( i );
				
				// if the dates are the same, then check the times
				if ( r1.getDate ( ) == r.getDate ( ) ) {
					
					// 1/2 hour cleanup, 1/2 hour setip. 1hour gap total
					
					// if the given start time is in between any reservation, then its not available
					boolean a = ( r1.getStartTime ( ).compareTo ( r.getStartTime ( ) ) - prepTime ) < 0;
					boolean b = ( r1.getEndTime ( ).compareTo ( r.getStartTime ( ) ) +  ( prepTime * 2 ) ) > 0;
					boolean c = ( r1.getStartTime ( ).compareTo ( r.getEndTime ( ) ) - ( prepTime * 2 ) ) < 0;
					boolean d = ( r1.getEndTime ( ).compareTo ( r.getEndTime ( ) ) + prepTime ) > 0;
					
					if ( ( a && b ) || ( c && d ) ) {
						System.out.println ( "Your room is not available at the given date and time." );
						System.out.println ( "Would you  like to be waitlisted? " );
						waitlist.add ( r );
						System.out.println ( "Waitlisted." );
						return false;
					}
				}
			}
			System.out.println ( "Your room is available at the given date and time." );
			reservations.add ( r );
			return true;
		}
	}
	
	/**
	 * abstract method that returns the cost of the room
	 * @return cost of the room
	 */
	public abstract double getCost ( );
}
 