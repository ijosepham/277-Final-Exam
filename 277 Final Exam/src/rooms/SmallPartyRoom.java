package rooms;

import roomfactories.RoomFactory;

public class SmallPartyRoom extends Room {
	public static String DESCRIPTION = "Number of Rooms: 10" + "\n" + 
			"Description:   Room wuth Party Tables and Chairs, Adjacent to Arcade" + "\n" + 
			"Capacity:   30 People" + "\n" +
			"Cost:   $150/hr" + "\n" + 
			"Included:   Table and Chair Set-Up, Basic Meal Plan" + "\n" +
			"Upgrades   Available: Meal Plan, Party Favor Bags,  Projector, Party Decorations and Set-up w/ Themes";
	
	public static int CAPACITY = 30;
	
	/**
	 * default consturctor
	 */
	public SmallPartyRoom ( ) {
		prepTime = 30;
		capacity = 30;
		name = "Small Party Room";
		roomNumber = RoomFactory.small_count;
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
		return 150.0;
	}
}
