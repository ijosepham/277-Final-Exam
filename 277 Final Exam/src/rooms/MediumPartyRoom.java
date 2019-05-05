package rooms;

public class MediumPartyRoom extends Room {
	/**
	 * default constructor
	 */
	public MediumPartyRoom ( ) {
		basicAmenities.add ( "Room with Tables & Chairs" );
		basicAmenities.add ( "Quick Access to Arcade" );
		basicAmenities.add ( "DJ" );
		basicAmenities.add ( "Basic Meal Plan" );
	}

	/**
	 * returns the cost of the medium party room
	 * @return cost of the room
	 */
	@Override
	public double getCost ( ) {
		double cost = 0;
		
		return cost;
	}
}
