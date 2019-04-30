package roomfactories;

import rooms.*;

public abstract class RoomFactory {
	static final int MAX_AQUA = 1;
	static final int MAX_SMALL = 10;
	static final int MAX_MEDIUM = 2;
	static final int MAX_KARAOKE = 10;
	static final int MAX_BILLIARDS = 5;
	
	public abstract Room createRoom ( RoomFactory roomFactory );
}
