package roomfactories;
import rooms.*;

public class MediumPartyRoomFactory extends RoomFactory {
	
	public Room createRoom ( RoomFactory roomFactory ) {
		return new MediumPartyRoom (null, 0, false );
	}
}
