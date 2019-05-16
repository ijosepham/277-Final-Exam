package rooms;

import roomfactories.RoomFactory;

public class MediumPartyRoom extends Room {
	/**
	 * dscripton of med room for panel
	 */
	public static String DESCRIPTION = "Number of Rooms: 2" + "\n" + 
			"Description:   Room with Party Tables and Chairs, Quick Access to Arcade" + "\n" + 
			"Capacity:   45 People" + "\n" +
			"Cost:   $250/hr" + "\n" + 
			"Included:   Table and Chair Set-Up, DJ, Basic Meal Plan" + "\n" +
			"Upgrades   Available: Meal Plan, Party Favor Bags,  Projector, Party Decorations and Set-up w/ Themes";
	
	/**
	 * max capacity of the room
	 */
	public static int CAPACITY = 45;
	
	/**
	 * default constructor
	 */
	public MediumPartyRoom ( ) {
		prepTime = 60;
		name = "Medium Party Room";
		roomNumber = RoomFactory.medium_count;
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
		return 250.0;
	}
}
