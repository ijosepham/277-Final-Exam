package roomfactories;

import rooms.*;

public class AquaWorldFactory extends RoomFactory {
	/**
	 * creates an instance of aqua world room
	 * @return room that was created
	 */
	public Room createRoom ( ) {
		if ( aqua_count < MAX_AQUA ) {
			aqua_count++;
			return AquaWorld.getInstance ( );
		} else {
			System.out.println ( "Maximum number of Aqua Worlds have been created." );
			return null;
		}
	}
}
