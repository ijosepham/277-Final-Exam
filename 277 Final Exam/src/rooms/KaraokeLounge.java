package rooms;

import roomfactories.RoomFactory;

public class KaraokeLounge extends Room {
	/**
	 * description of karaoke lounge for panel
	 */
	public static String DESCRIPTION = "Number of Rooms: 10" + "\n" + 
			"Description:   : Enclosed Lounge with Karaoke Machine" + "\n" + 
			"Capacity:   10 People" + "\n" +
			"Cost:   $30/hr" + "\n" + 
			"Included:   Access to Karaoke Machine" + "\n" +
			"Upgrades   Available: Meal Plan";
	
	/**
	 * max capacity of karaoke lounge
	 */
	public static int CAPACITY = 10;
	
	/**
	 * default constructor
	 */
	public KaraokeLounge ( ) {
		prepTime = 15;
		name = "Karaoke Lounge";
		roomNumber = RoomFactory.karaoke_count;
		basicAmenities.add ( "Lounge with Karaoke Machine" );
		basicAmenities.add ( "Access to Karaoke Machine" );
	}
	
	/**
	 * returns the cost of the small party room
	 * @return cost of the room
	 */
	@Override
	public double getCost ( ) {
		double cost = 30.0;
		
		return cost;
	}
}
