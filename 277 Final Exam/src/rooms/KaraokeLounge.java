package rooms;

public class KaraokeLounge extends Room {
	/**
	 * default constructor
	 */
	public KaraokeLounge ( ) {
		basicAmenities.add ( "Lounge with Karaoke Machine" );
		basicAmenities.add ( "Access to Karaoke Machine" );
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
