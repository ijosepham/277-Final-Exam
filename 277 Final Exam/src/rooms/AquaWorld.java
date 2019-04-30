package rooms;

public class AquaWorld extends Room {
	private static AquaWorld aquaWorld;
	
	public AquaWorld ( String amenities, int capacity, boolean isAvailable ) {
		super ( amenities, capacity, isAvailable );
	}
	
	public AquaWorld getInstance ( ) {
		if ( aquaWorld == null ) {
			aquaWorld = new AquaWorld ( null, 0, false );
		}
		return aquaWorld;
	}

	public double getCost ( ) {
		double cost = 0;
		
		return cost;
	}
}
