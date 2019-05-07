package rooms;

import reservation.*;

public class AquaWorld extends Room {
	/**
	 * single instance of aqua world
	 */
	private static AquaWorld aquaWorld;
	
	/**
	 * restrictions of aquaworld
	 */
	private String restrictions;
	
	/**
	 * private default consturctor only allowed by the class
	 */
	private AquaWorld ( ) {
		restrictions = "Bathing Suits Must be Worn at All Times in Water Facilities";
		basicAmenities.add ( "Olympic-Sized Pool with Water Slide" );
		basicAmenities.add ( "Kiddie Pool" );
		basicAmenities.add ( "Large Jacuzzi" );
		basicAmenities.add ( "Showers & Lockers" );
		basicAmenities.add ( "Life Guards" );
		basicAmenities.add ( "DJ" );
		basicAmenities.add ( "Tables & Chairs" );
		basicAmenities.add ( "Basic Meal Plan" );
	}
	
	/**
	 * makes it so that only one instance of aqua world is able to exist
	 * either creates an instance if one hasnt been created yet, or returns it
	 * @return the instnace of aquaworld
	 */
	public static AquaWorld getInstance ( ) {
		if ( aquaWorld == null ) {
			aquaWorld = new AquaWorld ( );
		}
		return aquaWorld;
	}
	
	/**
	 * returns the restrictions 
	 * @return restriction
	 */
	public String getRestrictions ( ) {
		return restrictions;
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
				
				// 1 hour cleanup, 1 hour setip. 2hour gap total
				
				// if the given start time is in between any reservation, then its not available
				if ( ( res.getStartTime ( ).compareTo ( startTime ) - 60 ) < 0 ) {
					// check to make sure there's at least a 2 hour gap in between this.end and that.start
					if ( ( res.getEndTime ( ).compareTo ( startTime ) + 120 ) > 0 ) {
						return false;
					}
				}
				
				
				// if the given end time is in between any reservation, then its not available
				if ( ( res.getStartTime ( ).compareTo ( endTime ) - 120 ) < 0 ) {
					if ( ( res.getEndTime ( ).compareTo ( endTime ) + 60 ) > 0 ) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	/**
	 * returns the cost of the aqua world party room
	 * @return cost of the room
	 */
	public double getCost ( ) {
		double cost = 0;
		
		return cost;
	}
}
