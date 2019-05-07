import reservation.*;
import roomfactories.*;
import rooms.*;
import mealplans.*;
import pizzas.*;

public class Main {
	public static void main ( String [ ] args ) {
		aquaWorldTester ( );

		
		Date date1 = new Date ( 1, 1, 2019 );
		Time startTime1 = new Time ( 8, 00 );
		Time endTime1 = new Time ( 12, 00 );
		
		Date date2 = new Date ( 1, 1, 2019 );
		Time startTime2 = new Time ( 10, 00 );
		Time endTime2 = new Time ( 2, 00 );
	}
	
	public static void aquaWorldTester ( ) {
		System.out.println ( "AquaWorld Tester:" );
		System.out.println ( "Create an Aqua World." );
		Room aquaWorld = RoomFactory.createRoom ( new AquaWorldFactory ( ) );
		
		System.out.println ( "Create a second Aqua World." );
		Room aquaWorld1 = RoomFactory.createRoom ( new AquaWorldFactory ( ) );
		
		System.out.println ( "Change capacity of AquaWorld1 to 1234124312." );
		aquaWorld.setCapacity ( 1234124312 );
		
		System.out.println ( "AquaWorld1's capacity: " + aquaWorld.getCapacity ( ) );
	
		System.out.println ( "AquaWorld2's capacity: " + aquaWorld1.getCapacity ( ) );
	}
}
