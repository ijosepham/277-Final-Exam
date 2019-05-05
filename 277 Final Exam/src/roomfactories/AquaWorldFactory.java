package roomfactories;
import rooms.*;

public class AquaWorldFactory extends RoomFactory {
	
	public Room createRoom ( ) {
		return AquaWorld.getInstance ( );
	}
}
