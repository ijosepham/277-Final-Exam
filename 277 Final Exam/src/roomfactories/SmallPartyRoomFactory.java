package roomfactories;
import rooms.*;

public class SmallPartyRoomFactory extends RoomFactory {
	/**
	 * creates an instance of small party room
	 * @return room that was created
	 */
	public SmallPartyRoom createRoom ( ) {
		small_count++;
		return new SmallPartyRoom ( );
	}
}
