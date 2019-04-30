package roomfactories;

import rooms.*;

public abstract class RoomFactory {
	public static final int MAX_AQUA = 1;
	public static final int MAX_SMALL = 10;
	public static final int MAX_MEDIUM = 2;
	public static final int MAX_KARAOKE = 10;
	public static final int MAX_BILLIARDS = 5;
	
	private static int aqua = 0;
	private static int small = 0;
	private static int medium = 0;
	private static int karaoke = 0;
	private static int billiards = 0;
	
	public abstract Room createRoom ( RoomFactory roomFactory );
}
