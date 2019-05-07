package roomfactories;
import rooms.*;

public class SmallPartyRoomFactory extends RoomFactory {
	/**
	 * creates an instance of small party room
	 * @return room that was created
	 */
	public Room createRoom ( ) {
		if ( small_count < MAX_SMALL ) {
			small_count++;
			return new SmallPartyRoom ( );
		} else { 
			System.out.println ( "Maximum number of Small Party Rooms created." );
			return null;
		}
		
	}
}
