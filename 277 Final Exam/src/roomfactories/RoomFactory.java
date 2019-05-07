package roomfactories;

import rooms.*;

public abstract class RoomFactory {
	/** 
	 * represents the maximum number of aqua rooms creatable
	 */
	public static final int MAX_AQUA = 1;
	
	/** 
	 * represents the maximum number of small party rooms creatable
	 */
	public static final int MAX_SMALL = 10;
	
	/** 
	 * represents the maximum number of medium party rooms creatable
	 */
	public static final int MAX_MEDIUM = 2;
	
	/** 
	 * represents the maximum number of karaoke rooms creatable
	 */
	public static final int MAX_KARAOKE = 10;
	
	/** 
	 * represents the maximum number of billiard lounges creatable
	 */
	public static final int MAX_BILLIARDS = 5;
	
	
	/** 
	 * represents the current number of aqua worlds created
	 */
	protected static int aqua_count = 0;
	
	/** 
	 * represents the current number of small party rooms created
	 */
	protected static int small_count = 0;
	
	/** 
	 * represents the current number of medium party rooms created
	 */
	protected static int medium_count = 0;
	
	/** 
	 * represents the current number of karaoke lounges created
	 */
	protected static int karaoke_count = 0;
	
	/** 
	 * represents the current number of billiard lounges created
	 */
	protected static int billiards_count = 0;
	
	/**
	 * constructor
	 * @param roomFactory - specific roomfactory to create a room
	 * @return room that was create with the given factory
	 */
	/**
	public Room createRoom ( AbstractRoomFactory roomFactory ) {
		Room room = null;
		
		// create a room of give roomfactory, and make sure that it's less than the max
		if ( roomFactory instanceof BilliardsLoungeFactory ) {
			if ( billiards_count < MAX_BILLIARDS ) {
				room = ( ( BilliardsLoungeFactory ) roomFactory ).createRoom ( );
				billiards_count++;
			}
			
		} else if ( roomFactory instanceof AquaWorldFactory ) {
			if ( aqua_count < MAX_AQUA ) {
				room = ( ( AquaWorldFactory ) roomFactory ).createRoom ( );
				aqua_count++;
			}
			
		} else if ( roomFactory instanceof KaraokeLoungeFactory ) {
			if ( karaoke_count < MAX_KARAOKE ) {
				room = ( ( KaraokeLoungeFactory ) roomFactory ).createRoom ( );
				karaoke_count++;
			}
				
		} else if ( roomFactory instanceof MediumPartyRoomFactory ) {
			if ( medium_count < MAX_MEDIUM ) {
				room = ( ( MediumPartyRoomFactory ) roomFactory ).createRoom ( );
				medium_count++;
			}
			
		} else {
			if ( small_count < MAX_SMALL ) {
				room = ( ( SmallPartyRoomFactory ) roomFactory ).createRoom ( );
				small_count++;
			}
		}
		
		return room;
	}
	*/
	
	public static Room createRoom ( RoomFactory roomFactory ) {
		return roomFactory.createRoom ( );
	}
	
	public abstract Room createRoom ( );
}
