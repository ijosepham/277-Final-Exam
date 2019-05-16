package rooms;

public class AquaWorld extends Room {
	/**
	 * single instance of aqua world
	 */
	private static AquaWorld aquaWorld;
	
	/**
	 * description of the room for the panel
	 */
	public static String DESCRIPTION = "Number of Rooms: 1" + "\n" + 
			"Description:   Olympic-Sized Pool with Water Slide, Kiddie Pool, Large Jacuzzi" + "\n" + 
			"Capacity:   75 People" + "\n" +
			"Cost:   $700/hr" + "\n" + 
			"Included:   Access to Showers and Lockers, Life Guards on Duty, DJ, Table and Chair Set-Up, Basic Meal Plan" + "\n" +
			"Upgrades   Available: Meal Plan, Party Favor Bags,  Projector, Party Decorations and Set-up w/ Themes" + "\n" +
			"Restrictions:   Bathing suits must be worn to access water facilities.";
	
	/**
	 * max capacity of aquaworld
	 */
	public static int CAPACITY = 75;
	
	/**
	 * restrictions of aquaworld
	 */
	private String restrictions;
	
	/**
	 * private default consturctor only allowed by the class
	 */
	private AquaWorld ( ) {
		prepTime = 60;
		name = "Aqua World";
		roomNumber = 1;
		restrictions = "Bathing Suits Must be Worn at All Times in Water Facilities";
		basicAmenities.add ( "Olympic-Sized Pool with Water Slide" );
		basicAmenities.add ( "Kiddie Pool" );
		basicAmenities.add ( "Large Jacuzzi" );
		basicAmenities.add ( "Showers & Lockers" );
		basicAmenities.add ( "Life Guards" );
		basicAmenities.add ( "DJ" );
		basicAmenities.add ( "Tables & Chairs" );
		basicAmenities.add ( "Basic Meal Plan" );
	}
	
	/**
	 * makes it so that only one instance of aqua world is able to exist
	 * either creates an instance if one hasnt been created yet, or returns it
	 * @return the instnace of aquaworld
	 */
	public static AquaWorld getInstance ( ) {
		if ( aquaWorld == null ) {
			aquaWorld = new AquaWorld ( );
		}
		return aquaWorld;
	}
	
	/**
	 * returns the restrictions 
	 * @return restriction
	 */
	public String getRestrictions ( ) {
		return restrictions;
	}
	
	/**
	 * returns the cost of the aqua world party room
	 * @return cost of the room
	 */
	public double getCost ( ) {
		return 700.0;
	}
}
