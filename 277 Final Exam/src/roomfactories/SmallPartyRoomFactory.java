package roomfactories;
import rooms.*;

public class SmallPartyRoomFactory extends RoomFactory {
	
	public Room createRoom ( RoomFactory roomFactory ) {
		return new SmallPartyRoom (null, 0, false );
	}
}
