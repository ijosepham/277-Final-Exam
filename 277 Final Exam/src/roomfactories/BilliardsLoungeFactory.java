package roomfactories;
import rooms.*;

public class BilliardsLoungeFactory extends RoomFactory {
	/**
	 * creates an instance of billiards lounge room
	 * @return room that was created
	 */
	public BilliardsLounge createRoom ( ) {
		billiards_count++;
		return new BilliardsLounge ( );
	}
}
