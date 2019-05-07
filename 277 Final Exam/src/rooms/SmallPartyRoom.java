package rooms;

import reservation.*;

public class SmallPartyRoom extends Room {
	/**
	 * default consturctor
	 */
	public SmallPartyRoom ( ) {
		basicAmenities.add ( "Room with Tables & Chairs" );
		basicAmenities.add ( "Adjacent to Arcade" );
		basicAmenities.add ( "Basic Meal Plan" );
	}
	
	/**
	 * returns whether or not the given date and time is available for registration
	 * @param date - date of wanted reservation
	 * @param startTime - start time of wanted reservation
	 * @param endTime - end time of wanted reservation
	 * @return whether the date is available for reservation
	 */
	@Override
	public boolean isAvailable ( Date date, Time startTime, Time endTime ) {
		Reservation res;
		
		// go through each reservation in the waitlist
		for ( int i = 0; i < waitlist.size ( ); i++ ) {
			// get the reservation
			res = waitlist.get ( i );
			
			// if the dates are the same, then check the times
			if ( res.getDate ( ) == date ) {
				
				// 1/2 hour cleanup, 1/2 hour setip. 1hour gap total
				
				// if the given start time is in between any reservation, then its not available
				if ( ( res.getStartTime ( ).compareTo ( startTime ) - 30 ) < 0 ) {
					// check to make sure there's at least a 1 hour gap in between this.end and that.start
					if ( ( res.getEndTime ( ).compareTo ( startTime ) + 60 ) > 0 ) {
						return false;
					}
				}
				
				
				// if the given end time is in between any reservation, then its not available
				if ( ( res.getStartTime ( ).compareTo ( endTime ) - 60 ) < 0 ) {
					if ( ( res.getEndTime ( ).compareTo ( endTime ) + 30 ) > 0 ) {
						return false;
					}
				}
			}
		}
		return true;
	}

	/**
	 * returns the cost of the small party room
	 * @return cost of the room
	 */
	@Override
	public double getCost ( ) {
		double cost = 0;
		
		return cost;
	}
}
