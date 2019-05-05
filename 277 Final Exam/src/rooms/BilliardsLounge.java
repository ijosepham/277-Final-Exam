package rooms;

public class BilliardsLounge extends Room {
	/**
	 * default consturctor
	 */
	public BilliardsLounge ( ) {
		basicAmenities.add ( "Lounge with Pool Table" );
		basicAmenities.add ( "Access to Pool Table & Cues" );
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
