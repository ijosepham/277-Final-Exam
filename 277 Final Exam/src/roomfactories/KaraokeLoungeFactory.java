package roomfactories;
import rooms.*;

public class KaraokeLoungeFactory extends RoomFactory {
	/**
	 * creates an instance of karaoke party room
	 * @return room that was created
	 */
	public Room createRoom ( ) {
		return new KaraokeLounge ( );
	}
}
