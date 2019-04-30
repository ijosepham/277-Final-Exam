package roomfactories;
import rooms.*;

public class AquaWorldFactory extends RoomFactory {
	
	public Room createRoom ( RoomFactory roomFactory ) {
		return new AquaWorld (null, 0, false );
	}
}
