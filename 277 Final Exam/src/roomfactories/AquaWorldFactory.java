package roomfactories;
import rooms.*;

public class AquaWorldFactory extends RoomFactory {
	/**
	 * creates an instance of aqua world room
	 * @return room that was created
	 */
	public Room createRoom ( ) {
		return AquaWorld.getInstance ( );
	}
}
