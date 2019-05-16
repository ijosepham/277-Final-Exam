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
	public static int aqua_count = 0;
	
	/** 
	 * represents the current number of small party rooms created
	 */
	public static int small_count = 0;
	
	/** 
	 * represents the current number of medium party rooms created
	 */
	public static int medium_count = 0;
	
	/** 
	 * represents the current number of karaoke lounges created
	 */
	public static int karaoke_count = 0;
	
	/** 
	 * represents the current number of billiard lounges created
	 */
	public static int billiards_count = 0;
	
	/**
	 * creates a room of the given factory
	 * @param roomFactory - factory to create the room from
	 * @return room tha twas created
	 */
	public static Room createRoom ( RoomFactory roomFactory ) {
		return roomFactory.createRoom ( );
	}
	
	/**
	 * abstract create calss
	 * @return rooom htat was created
	 */
	public abstract Room createRoom ( );
}
