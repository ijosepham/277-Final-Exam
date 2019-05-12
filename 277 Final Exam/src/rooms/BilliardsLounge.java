package rooms;
public class BilliardsLounge extends Room {
	/**
	 * represents restrictions of the billiards lounge1
	 */
	private String restrictions;
	
	/**
	 * default consturctor
	 */
	public BilliardsLounge ( ) {
		prepTime = 15;
		name = "Billiards Lounge";
		capacity = 10;
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
