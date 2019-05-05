import reservation.*;

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
		
		Date expDate = new Date ( 1, 1, 2019 );
		Card card = new Card ( "Visa", "1234 5678 9012 3456", "123", expDate );
		Guest joey = new Guest ( "Joey Pham", "12345 Cerritos Drive", "(562) 275-5206", "joeypham@spam.com", card );
		
		Date date = new Date ( 5, 5, 2019, 10, 00 );
		Reservation reservation = new Reservation ( date, )
	}
}
