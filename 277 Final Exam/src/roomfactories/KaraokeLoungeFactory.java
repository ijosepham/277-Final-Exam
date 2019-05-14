package roomfactories;
import rooms.*;

public class KaraokeLoungeFactory extends RoomFactory {
	/**
	 * creates an instance of karaoke party room
	 * @return room that was created
	 */
	public KaraokeLounge createRoom ( ) {
		karaoke_count++;
		return new KaraokeLounge ( );
	}
}
