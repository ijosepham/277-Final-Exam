package roomfactories;
import rooms.*;

public class KaraokeLoungeFactory extends RoomFactory {
	
	public Room createRoom ( ) {
		return new KaraokeLounge ( );
	}
}
