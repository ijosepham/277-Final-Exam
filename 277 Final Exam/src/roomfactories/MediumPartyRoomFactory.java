package roomfactories;
import rooms.*;

public class MediumPartyRoomFactory extends RoomFactory {
	/**
	 * creates an instance of medium party room
	 * @return room that was created
	 */
	public MediumPartyRoom createRoom ( ) {
		return new MediumPartyRoom ( );
	}
}
