package roomfactories;
import rooms.*;

public class KaraokeLoungeFactory extends RoomFactory {
	
	public Room createRoom ( RoomFactory roomFactory ) {
		return new KaraokeLounge (null, 0, false );
	}
}
