package rooms;

public class AquaWorld extends Room {
	private static AquaWorld aquaWorld;
	
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
	
	public static AquaWorld getInstance ( ) {
		if ( aquaWorld == null ) {
			aquaWorld = new AquaWorld ( );
		}
		return aquaWorld;
	}

	public double getCost ( ) {
		double cost = 0;
		
		return cost;
	}
}
