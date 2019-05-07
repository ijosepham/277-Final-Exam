package roomfactories;
import rooms.*;

public class KaraokeLoungeFactory extends RoomFactory {
	/**
	 * creates an instance of karaoke party room
	 * @return room that was created
	 */
	public Room createRoom ( ) {
		if ( karaoke_count < MAX_KARAOKE ) {
			karaoke_count++;
			return new KaraokeLounge ( );
		} else { 
			System.out.println ( "Maximum number of Karaoke Lounges created." );
			return null;
		}
	}
}
