package roomfactories;
import rooms.*;

public class AdultBilliardsLoungeFactory extends RoomFactory {
	
	public Room createRoom ( RoomFactory roomFactory ) {
		return new AdultBilliardsLounge (null, 0, false );
	}
}
