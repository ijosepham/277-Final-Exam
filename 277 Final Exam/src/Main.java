import reservation.*;
import roomfactories.*;
import rooms.*;

public class Main {
	public static void main ( String [ ] args ) {
		// first user should enter their information
		// then choose what room and times they want
		// then after choosing so, then available?
		//    a. add the details, and ask for meal plan and upgrades
		//    b. ask to waitlist or ask for another time
		// reserve room from date/time to date/time
		// apply time sltos to clean up/setup according to rubric
		// collect 25% of amount due
		//    a. so you have to have all information confirmed by the end
		// send confirmation details, basically a receipt
		
		/**
		RoomFactory factory;
		AquaWorld aquaWorld = ( AquaWorld ) factory.createRoom( new AquaWorldFactory ( ) );
		
		Date expDate = new Date ( 1, 1, 2019 );
		Card card = new Card ( "Visa", "1234 5678 9012 3456", "123", expDate );
		Guest joey = new Guest ( "Joey Pham", "12345 Cerritos Drive", "(562) 275-5206", "joeyspam@mail.com", card );
		
		Date date = new Date ( 5, 5, 2019 );
		Time startTime = new Time ( 10, 00 );
		Time endTime = new Time ( 22, 00 );
		Reservation reservation = new Reservation ( date, startTime, endTime,  )
		*/
		
		Time time1 = new Time ( 15, 34 );
		Time time2 = new Time ( 12, 10 );
		System.out.println ( time1.compareTo ( time2 ) );
	}
}
