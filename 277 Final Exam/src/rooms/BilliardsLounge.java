package rooms;

import roomfactories.RoomFactory;

public class BilliardsLounge extends Room {
	/**
	 * represents restrictions of the billiards lounge1
	 */
	private String restrictions;
	
	public static String DESCRIPTION = "Number of Rooms: 5" + "\n" + 
			"Description:   Enclosed Loung with Pool Table" + "\n" + 
			"Capacity:   10 People" + "\n" +
			"Cost:   $25/hr" + "\n" + 
			"Included:   Access to Pool Tables and Cues" + "\n" +
			"Upgrades   Available: Meal Plan" + "\n" +
			"Restrictions:   Must be 21 years or older.";
	
	public static int CAPACITY = 10;
	
	/**
	 * default consturctor
	 */
	public BilliardsLounge ( ) {
		prepTime = 15;
		capacity = 10;
		name = "Billiards Lounge";
		roomNumber = RoomFactory.billiards_count;
		restrictions = "21 and Older Only";
		basicAmenities.add ( "Lounge with Pool Table" );
		basicAmenities.add ( "Access to Pool Table & Cues" );
	}
	
	/**
	 * returns the restrictions 
	 * @return restrictions
	 */
	public String getRestrictions ( ) {
		return restrictions;
	}
	
	/**
	 * returns the cost of the small party room
	 * @return cost of the room
	 */
	@Override
	public double getCost ( ) {
		return 25.0;
	}
}
