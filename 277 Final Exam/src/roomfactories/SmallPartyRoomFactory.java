package roomfactories;
import rooms.*;

public class SmallPartyRoomFactory extends RoomFactory {
	
	public Room createRoom ( ) {
		return new SmallPartyRoom ( );
	}
}
