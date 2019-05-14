package rooms;

import roomfactories.RoomFactory;

public class MediumPartyRoom extends Room {
	public static String DESCRIPTION = "Medium Party Room";
	public static int CAPACITY = 45;
	
	/**
	 * default constructor
	 */
	public MediumPartyRoom ( ) {
		prepTime = 60;
		capacity = 45;
		name = "Medium Party Room, Room #" + RoomFactory.medium_count;
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
