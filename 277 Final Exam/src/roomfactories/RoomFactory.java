package roomfactories;

import rooms.*;

public abstract class RoomFactory {
	public static final int MAX_AQUA = 1;
	public static final int MAX_SMALL = 10;
	public static final int MAX_MEDIUM = 2;
	public static final int MAX_KARAOKE = 10;
	public static final int MAX_BILLIARDS = 5;
	
	private static int aqua_count = 0;
	private static int small_count = 0;
	private static int medium_count = 0;
	private static int karaoke_count = 0;
	private static int billiards_count = 0;
	
	public Room createRoom ( RoomFactory roomFactory ) {
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
}
