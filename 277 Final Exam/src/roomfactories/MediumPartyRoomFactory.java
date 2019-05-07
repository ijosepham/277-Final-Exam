package roomfactories;
import rooms.*;

public class MediumPartyRoomFactory extends RoomFactory {
	/**
	 * creates an instance of medium party room
	 * @return room that was created
	 */
	public Room createRoom ( ) {
		if ( medium_count < MAX_MEDIUM ) {
			medium_count++;
			return new MediumPartyRoom ( );
		} else { 
			System.out.println ( "Maximum number of Medium Party Rooms created." );
			return null;
		}
	}
}
