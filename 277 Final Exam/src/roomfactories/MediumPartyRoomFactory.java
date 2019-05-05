package roomfactories;
import rooms.*;

public class MediumPartyRoomFactory extends RoomFactory {
	
	public Room createRoom ( ) {
		return new MediumPartyRoom ( );
	}
}
