package roomfactories;
import rooms.*;

public class MediumPartyRoomFactory extends RoomFactory {
	/**
	 * creates an instance of medium party room
	 * @return room that was created
	 */
	public Room createRoom ( ) {
		return new MediumPartyRoom ( );
	}
}
