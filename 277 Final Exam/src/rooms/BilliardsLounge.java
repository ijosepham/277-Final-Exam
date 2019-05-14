package rooms;

import roomfactories.RoomFactory;

public class BilliardsLounge extends Room {
	/**
	 * represents restrictions of the billiards lounge1
	 */
	private String restrictions;
	
	public static String DESCRIPTION = "billiards lounge";
	public static int CAPACITY = 10;
	
	/**
	 * default consturctor
	 */
	public BilliardsLounge ( ) {
		prepTime = 15;
		capacity = 10;
		name = "Billiards Lounge, Room #" + RoomFactory.billiards_count;
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
		double cost = 0;
		
		return cost;
	}
}
