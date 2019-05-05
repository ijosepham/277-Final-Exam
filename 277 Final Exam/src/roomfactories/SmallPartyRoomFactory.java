package roomfactories;
import rooms.*;

public class SmallPartyRoomFactory extends RoomFactory {
	/**
	 * creates an instance of small party room
	 * @return room that was created
	 */
	public Room createRoom ( ) {
		return new SmallPartyRoom ( );
	}
}
