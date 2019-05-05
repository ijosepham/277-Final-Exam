package roomfactories;
import rooms.*;

public class BilliardsLoungeFactory extends RoomFactory {
	
	public Room createRoom ( ) {
		return new BilliardsLounge ( );
	}
}
