package rooms;

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
	 * returns the cost of the small party room
	 * @return cost of the room
	 */
	@Override
	public double getCost ( ) {
		double cost = 0;
		
		return cost;
	}
}
