package rooms;

import java.util.ArrayList;

import reservation.*;

public abstract class Room {
	/**
	 * room type
	 */
	protected String name;
	
	/**
	 * room number
	 */
	protected int roomNumber;
	
	/**
	 * basic amenities of the room
	 */
	protected ArrayList < String > basicAmenities;
	
	/**
	 * if the room is available or not
	 */
	protected boolean isAvailable;
	
	/**
	 * current reservations
	 */
	protected ArrayList < Reservation > reservations;
	
	/**
	 * waitlist of reservations to the room
	 */
	protected ArrayList < Reservation > waitlist;

	/**
	 * represents the prep time the room needs to setup/cleanup
	 */
	protected int prepTime;
	
	/**
	 * default constructor
	 */
	public Room ( ) {
		basicAmenities = new ArrayList < String > ( );
		isAvailable = true;
		reservations = new ArrayList < Reservation > ( );
		waitlist = new ArrayList < Reservation > ( );
		prepTime = 0;
	}
	
	/**
	 * sets whether or not the room is available
	 * @param isAvailable - availability of the room
	 */
	public void setIsAvailable ( boolean isAvailable ) {
		this.isAvailable = isAvailable;
	}
	
	/**
	 * returns the room type
	 * @return room type
	 */
	public String getName ( ) {
		return name;
	}
	
	/**
	 * gets the room number
	 * @return room number
	 */
	public int getRoomNumber ( ) {
		return roomNumber;
	}
	
	/**
	 * returns the list of confirmed reservations
	 * @return confiremd reservbations
	 */
	public ArrayList < Reservation > getReservations ( ) {
		return reservations;
	}
	
	/**
	 * returns the waitlist of reservations
	 * @return waitlist
	 */
	public ArrayList < Reservation > getWaitlist ( ) {
		return waitlist;
	}
	
	/**
	 * reserves a room
	 */
	public void reserve ( Reservation reservation ) {
		reservations.add ( reservation );
	}
	
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
	 * remove a reservation from the confirmed resrevaitons
	 * @param reservation - reservation tob e remobed
	 */
	public void removeFromReservations ( Reservation reservation ) {
		reservations.remove ( reservation );
	}
	
	/**
	 * adds a reservation to the confiremd list
	 * @param resrvation -res to add
	 */
	public void addToReservations ( Reservation r ) {
		reservations.add ( r );
	}
	
	/**
	 * removes all waitlists that have passed
	 * @param r - reservation that just finished
	 */
	public void removeUnavailableWaitlists ( Reservation r ) {
		Reservation w;
		
		// need this because if you used the actual one, it would mess up the positons of the items
		ArrayList < Reservation > waitlist = this.waitlist; 
		
		// go through waitlist
		for ( int i = 0; i < waitlist.size ( ); i++ ) {
			w = waitlist.get ( i );
			
			// if the dates are the same, then check the times
			if ( w.getDate ( ).equals ( r.getDate ( ) ) ) {
				
				// if the given start time is in between any reservation, then its not available
				boolean a = ( w.getStartTime ( ).compareTo ( r.getStartTime ( ) ) - prepTime ) < 0;
				boolean b = ( w.getEndTime ( ).compareTo ( r.getStartTime ( ) ) + ( prepTime * 2 ) ) > 0;
				boolean c = ( w.getStartTime ( ).compareTo ( r.getEndTime ( ) ) - ( prepTime * 2 ) ) < 0;
				boolean d = ( w.getEndTime ( ).compareTo ( r.getEndTime ( ) ) + prepTime ) > 0;
				
				
				// remove any waitlisted res's that dont fit anymore
				if ( ( a && b ) || ( c && d ) ) {
					this.waitlist.remove ( w );
				}
			}
		}
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
			isAvailable = false;
			return true;
		} else {
			Reservation r1;
			
			// go through reservations
			for ( int i = 0; i < reservations.size ( ); i++ ) {
				r1 = reservations.get ( i );
				
				// if the dates are the same, then check the times
				if ( r1.getDate ( ).equals ( r.getDate ( ) ) ) {
					
					// if the given start time is in between any reservation, then its not available
					boolean a = ( r1.getStartTime ( ).compareTo ( r.getStartTime ( ) ) - prepTime ) < 0;
					boolean b = ( r1.getEndTime ( ).compareTo ( r.getStartTime ( ) ) + ( prepTime * 2 ) ) > 0;
					boolean c = ( r1.getStartTime ( ).compareTo ( r.getEndTime ( ) ) - ( prepTime * 2 ) ) < 0;
					boolean d = ( r1.getEndTime ( ).compareTo ( r.getEndTime ( ) ) + prepTime ) > 0;
					
					
					
					if ( ( a && b ) || ( c && d ) ) {
						return false;
					}
				}
			}
			return true;
		}
	}
	
	/**
	 * abstract method that returns the cost of the room
	 * @return cost of the room
	 */
	public abstract double getCost ( );
}
 