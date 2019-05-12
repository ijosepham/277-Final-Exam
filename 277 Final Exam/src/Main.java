import reservation.*;
import roomfactories.*;
import rooms.*;
import food.*;
import mealplans.*;
import pizzas.*;

/**
 * to-do: 
 * check in and out
 * creating rooms all at once? or when called
 * 		make thme all at once
 * waitlists belongs to the room itself
 * do waitlisted people need a reservation, or just guest info?
 * 		reservation needs time
 * 		resrevation is cancelled if the whole entire tiem lot is not open
 */

public class Main {
	public static void main ( String [ ] args ) {
		//Room aquaWorld = aquaWorldTester ( );
		Pizza pizza = pizzaTester ( );
		MealPlan mealPlan = mealPlanTester ( pizza );
		waitlistTester ( );
	}
	
	public static Room aquaWorldTester ( ) {
		System.out.println ( "\n" + "AquaWorld Tester:" );
		System.out.println ( "Create an Aqua World." );
		Room aquaWorld = RoomFactory.createRoom ( new AquaWorldFactory ( ) );
		
		System.out.println ( "Create a second Aqua World." );
		Room aquaWorld1 = RoomFactory.createRoom ( new AquaWorldFactory ( ) );
		
		System.out.println ( "Change capacity of Aqua World to 1234124312." );
		aquaWorld.setCapacity ( 1234124312 );
		
		System.out.println ( "Aqua World's capacity: " + aquaWorld.getCapacity ( ) );
		
		return aquaWorld;
	}
	
	public static Pizza pizzaTester ( ) {
		System.out.println ( "\n" + "Pizza Tester: ");
		System.out.println ( "Adding toppings." );
		Pizza pizza = new Pizza ( );
		pizza = new Pineapple ( pizza );
		pizza = new Sausage ( pizza );
		pizza = new GarlicChicken ( pizza );
		pizza = new Mushroom ( pizza );
		pizza = new Onion ( pizza );
		System.out.println ( pizza.getDescription ( ) );
		return pizza;
	}
	
	public static MealPlan mealPlanTester ( Pizza pizza ) {
		System.out.println ( "\n" + "Meal Plan Tester:" );
		MealPlan mealPlan = new PlatinumMealPlan ( );
		
		System.out.println ( "Adding foods." );
		mealPlan.addFood ( pizza );
		mealPlan.addFood ( new IceCream ( "Strawberry Shortcake", 1 ) );
		mealPlan.addFood ( new Wings ( "Lemon Pepper", true, 1 ) );
		mealPlan.addFood ( new Soda ( "Canada Dry", 1 ) );
		System.out.println ( "Foods: " + "\n" + mealPlan );
		
		return mealPlan;
	}
	
	public static void waitlistTester ( ) {
		System.out.println ( "\n" + "Waitlist Tester:" );
		System.out.println ( "Created Karaoke Lounge." );
		Room karaokeLounge = RoomFactory.createRoom ( new KaraokeLoungeFactory ( ) );
		
		
		Date ep1 = new Date ( 4, 0, 2019 );
		Card c1 = new Card ( "Visa", "1234 5678 9012 3456", "123", ep1 );
		Date dob1 = new Date ( 6, 8, 1999 );
		Guest g1 = new Guest ( "Joey Joe", "1234 Cerritos Drive", "(562) 275-5206", "joeyjoe@mail.com", dob1, c1 );
		Date d1 = new Date ( 5, 7, 2019 );
		Time s1 = new Time ( 8, 00 );
		Time e1 = new Time ( 12, 00 );
		MealPlan m1 = new BasicMealPlan ( );
		
		Reservation r1 = new Reservation ( g1, d1, s1, e1, karaokeLounge, m1 );
		
		System.out.println ( "Guest1: " + "\n" + g1 );
		System.out.println ( "\n" + "Reservation1: " + "\n" + r1 );
		
		if ( karaokeLounge.isAvailable ( r1 ) ) {
			r1.finalizeReservation ( );
		}
		
		Date ep2 = new Date ( 10, 0, 2019 );
		Card c2 = new Card ( "MasterCard", "6543 2109 8765 4321", "321", ep2 );
		Date dob2 = new Date ( 5, 6, 1998 );
		Guest g2 = new Guest ( "Bobby Bob", "4321 Sotirrec Drive", "(265) 572-6025", "bobbybob@mail.com", dob2, c2 );
		Date d2 = new Date ( 5, 7, 2019 );
		Time s2 = new Time ( 10, 00 );
		Time e2 = new Time ( 14, 00 );
		MealPlan m2 = new SilverMealPlan ( );
		
		Reservation r2 = new Reservation ( g2, d2, s2, e2, karaokeLounge, m2 );
		
		System.out.println ( "\n" + "Guest2: " + "\n" + g2 );
		System.out.println ( "\n" + "Reservation2: " + "\n" + r2 );
		
		if ( karaokeLounge.isAvailable ( r2 ) ) {
			r2.finalizeReservation ( );
		}
		
		System.out.println ( "\n" + "Try to create another reservation with the same date" );
		
		if ( karaokeLounge.isAvailable ( r2 ) ) {
			r2.finalizeReservation ( );
		}
	}
}
