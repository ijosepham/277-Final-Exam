package rooms;

public class SmallPartyRoom extends Room {
	public static String DESCRIPTION = "Small Party Room";
	public static int CAPACITY = 30;
	/**
	 * default consturctor
	 */
	public SmallPartyRoom ( ) {
		prepTime = 30;
		capacity = 30;
		name = "Small Party Room";
		basicAmenities.add ( "Room with Tables & Chairs" );
		basicAmenities.add ( "Adjacent to Arcade" );
		basicAmenities.add ( "Basic Meal Plan" );
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
