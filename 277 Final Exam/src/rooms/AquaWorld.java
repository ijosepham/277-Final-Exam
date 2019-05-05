package rooms;

public class AquaWorld extends Room {
	/**
	 * single instance of aqua world
	 */
	private static AquaWorld aquaWorld;
	
	/**
	 * private default consturctor only allowed by the class
	 */
	private AquaWorld ( ) {
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
	 * returns the cost of the aqua world party room
	 * @return cost of the room
	 */
	public double getCost ( ) {
		double cost = 0;
		
		return cost;
	}
}
