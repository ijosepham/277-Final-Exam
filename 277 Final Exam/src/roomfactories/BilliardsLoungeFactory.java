package roomfactories;
import rooms.*;

public class BilliardsLoungeFactory extends RoomFactory {
	/**
	 * creates an instance of billiards lounge room
	 * @return room that was created
	 */
	public Room createRoom ( ) {
		if ( billiards_count < MAX_BILLIARDS ) {
			billiards_count++;
			return new BilliardsLounge ( );
		} else { 
			System.out.println ( "Maximum number of Billiards Lounges created." );
			return null;
		}
	}
}
