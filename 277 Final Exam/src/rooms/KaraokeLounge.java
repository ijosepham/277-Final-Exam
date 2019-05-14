package rooms;

import roomfactories.RoomFactory;

public class KaraokeLounge extends Room {
	public static String DESCRIPTION = "karoake lounge";
	public static int CAPACITY = 10;
	
	/**
	 * default constructor
	 */
	public KaraokeLounge ( ) {
		prepTime = 15;
		capacity = 10;
		name = "Karaoke Lounge, Room #" + RoomFactory.karaoke_count;
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
