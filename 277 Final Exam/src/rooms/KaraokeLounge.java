package rooms;

public class KaraokeLounge extends Room {
	public static String DESCRIPTION = "karoake lounge";
	/**
	 * default constructor
	 */
	public KaraokeLounge ( ) {
		prepTime = 15;
		capacity = 10;
		name = "Karaoke Lounge";
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
