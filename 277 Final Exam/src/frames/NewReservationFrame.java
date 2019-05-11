package frames;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import reservation.*;

// needa finish save button listener
// meal plan stuff like pizzas 
// needa make a thing for guest/res i think to see if they're checked in ornot
// main frame just make everything into the boxlayout
//		probably needa change things that have to do with the description of the place

public class NewReservationFrame extends JFrame {
	JTextField guestNameField;
	JTextField guestAddressField;
	JTextField guestPhoneField;
	JTextField guestEmailField;
	
	JComboBox < Integer > dobMonthCombo;
	JComboBox < Integer > dobDayCombo;
	JComboBox < Integer > dobYearCombo;
	
	JComboBox < String > cardCompanyCombo;
	JTextField ccNumberField;
	JTextField cardSecurityField;
	JComboBox < Integer > expMonthCombo;
	JComboBox < Integer > expYearCombo;
	
	JCheckBox contactPhoneCheck;
	JCheckBox contactEmailCheck;
	
	JComboBox < String > roomTypeCombo;
	
	JPanel mealPlanPanel;
	JComboBox < String > mealPlanCombo;
	JPanel pizzaPanel;
	JPanel wingsPanel;
	JPanel sodaPanel;
	JPanel iceCreamPanel;
	JPanel sidesPanel;
	
	JComboBox < Integer > roomMonthCombo;
	JComboBox < Integer > roomDayCombo;
	
	JComboBox < String > startHourCombo;
	JComboBox < String > startMinCombo;
	JComboBox < String > endHourCombo;
	JComboBox < String > endMinCombo;
	
	JButton saveReservationButton;
	JButton cancelReservationButton;
	
	Integer [ ] days31;
	Integer [ ] days30;
	Integer [ ] days29;
	Integer [ ] days28;
	
	String [ ] partyHours;
	String [ ] loungeHours;
	String [ ] minutes;
	
	public NewReservationFrame ( ) {
		this.setTitle ( "New Reservation" );
		
		this.setExtendedState ( JFrame.MAXIMIZED_BOTH ); //makes window screen size
		this.setDefaultCloseOperation ( EXIT_ON_CLOSE );
		
		this.createDefaultPanel ( );
		this.setVisible ( true );
	}
	
	/*
	 * initializes the default center panel and adds it to this frame
	 * */
	private void createDefaultPanel ( ) {
		JPanel panel = new JPanel ( );
		panel.setLayout ( new BoxLayout ( panel, BoxLayout.Y_AXIS ) );
		
		
		JPanel titlePanel = new JPanel ( );
		
		JLabel titleLabel = new JLabel ( "New Reservation" );
		titleLabel.setFont ( new Font ( Font.SERIF, Font.BOLD, 30 ) );
		titlePanel.add ( titleLabel );

		
		JPanel guestPanel = new JPanel ( );
		
		guestPanel.add ( new JLabel ( "Name: " ) );
		guestPanel.add ( guestNameField = new JTextField ( 20 ) );
		
		guestPanel.add ( new JLabel ( "Address: " ) );
		guestPanel.add ( guestAddressField = new JTextField ( 17 ) );
		
		guestPanel.add ( new JLabel ( "Phone Number: " ) );
		guestPanel.add ( guestPhoneField = new JTextField ( 10 ) );
		
		guestPanel.add ( new JLabel ( "Email Address: " ) );
		guestPanel.add ( guestEmailField = new JTextField ( 17 ) );
		
		guestPanel.add ( new JLabel ( "Date of Birth: " ) );
		Integer [ ] months = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
		dobMonthCombo = new JComboBox < Integer > ( months );
		dobMonthCombo.addActionListener ( new DOBMonthListener ( ) );
		guestPanel.add ( dobMonthCombo );
		
		
		days31 = new Integer [ 31 ];
		for ( int i = 0; i < 31; i++ ) {
			days31 [ i ] = i + 1;
		}
		
		days30 = new Integer [ 30 ];
		for ( int i = 0; i < 30; i++ ) {
			days30 [ i ] = i + 1;
		}
		
		days29 = new Integer [ 29 ];
		for ( int i = 0; i < 29; i++ ) {
			days29 [ i ] = i + 1;
		}
		
		days28 = new Integer [ 28 ];
		for ( int i = 0; i < 28; i++ ) {
			days28 [ i ] = i + 1;
		}
		
		dobDayCombo = new JComboBox < Integer > ( days31 );
		guestPanel.add ( dobDayCombo );
		
		Integer [ ] years = new Integer [ 101 ];
		for ( int i = 0; i <= 100; i++ ) {
			years [ i ] = 2019 - i;
		}
		dobYearCombo = new JComboBox < Integer > ( years );
		dobYearCombo.addActionListener ( new YearListener ( ) );
		guestPanel.add ( dobYearCombo );
		
		
		JPanel cardPanel = new JPanel ( );
		
		cardPanel.add ( new JLabel ( "Card Company: " ) );
		String [ ] cardCompanies = { "Visa", "Mastercard", "American Express" };
		cardPanel.add ( cardCompanyCombo = new JComboBox < String > ( cardCompanies ) );
		
		cardPanel.add ( new JLabel ( "Card Number: " ) );
		cardPanel.add ( ccNumberField = new JTextField ( 11 ) );
		
		cardPanel.add ( new JLabel ( "CVC: " ) );
		cardPanel.add ( cardSecurityField = new JTextField ( 2 ) );
		
		cardPanel.add ( new JLabel ( "Expiration Date: " ) );
		cardPanel.add ( expMonthCombo = new JComboBox < Integer > ( months ) );
		
		Integer [ ] expYears = new Integer [ 11 ];
		for ( int i = 0; i < 11; i++ ) {
			expYears [ i ] = 2025 - i;
		}
		cardPanel.add ( expYearCombo = new JComboBox < Integer > ( expYears ) );
		
		
		// JPanel planel = new JPanel ( ); // its a pun for plan panel hehe // man i didnt getta use this
		JPanel roomPanel = new JPanel ( );
		
		roomPanel.add ( new JLabel ( "Room Type: " ) );
		String [ ] roomTypes = { "Aqua World", "Medium Party Room", "Small Party Room", "Billiards Lounge", "Karaoke Lounge" };
		roomTypeCombo = new JComboBox < String > ( roomTypes );
		roomTypeCombo.addActionListener ( new RoomListener ( ) );
		roomPanel.add ( roomTypeCombo );
		
		roomPanel.add ( new JLabel ( "Date: " ) );
		roomMonthCombo = new JComboBox < Integer > ( months );
		roomMonthCombo.addActionListener ( new RoomMonthListener ( ) );
		roomPanel.add ( roomMonthCombo );
		roomPanel.add ( roomDayCombo = new JComboBox < Integer > ( days31 ) );
		
		
		partyHours = new String [ 16 ];
		partyHours [ 0 ] = "09";
		for ( int i = 1; i < 16; i++ ) {
			partyHours [ i ] = i + 9 + "";
		}
		
		loungeHours = new String [ 17 ];
		loungeHours [ 0 ] = "09";
		for ( int i = 1; i < 15; i++ ) {
			loungeHours [ i ] = i + 9 + "";
		}
		loungeHours [ 15 ] = "00";
		loungeHours [ 16 ] = "01";
		
		roomPanel.add ( new JLabel ( "Start Time: " ) );
		startHourCombo = new JComboBox < String > ( partyHours );
		startHourCombo.addActionListener ( new StartHourListener ( ) );
		roomPanel.add ( startHourCombo );
		
		minutes = new String [ 60 ];
		for ( int i = 0; i < 10; i++ ) {
			minutes [ i ] = "0" + i;
		}
		for ( int i = 10; i < 60; i++ ) {
			minutes [ i ] = i + "";
		}
		roomPanel.add ( startMinCombo = new JComboBox < String > ( minutes ) );
		
		roomPanel.add ( new JLabel ( "End Time: " ) );
		endHourCombo = new JComboBox < String > ( partyHours );
		endHourCombo.addActionListener ( new EndHourListener ( ) );
		roomPanel.add ( endHourCombo );
		roomPanel.add ( endMinCombo = new JComboBox < String > ( minutes ) );
		
		
		mealPlanPanel = new JPanel ( );
		
		mealPlanPanel.add ( new JLabel ( "Meal Plan: " ) );
		
		String [ ] mealPlans = { "Basic Meal Plan", "Bronze Meal Plan", "Silver Meal Plan", "Gold Meal Plan", "Platinum Meal Plan" };
		mealPlanCombo = new JComboBox < String > ( mealPlans );
		
		mealPlanCombo.addActionListener ( new MealPlanListener ( ) );
		mealPlanPanel.add ( mealPlanCombo );
		
		pizzaPanel = new JPanel ( );
		pizzaPanel.setLayout ( new BoxLayout ( pizzaPanel, BoxLayout.Y_AXIS ) );
		createPizzaPanel ( 5 );
		createPizzaPanel ( 0 );
		
		wingsPanel = new JPanel ( );
		createWingsPanel ( 2 );
		
		sodaPanel = new JPanel ( );
		createSodaPanel ( 2 );
		
		iceCreamPanel = new JPanel ( );
		createIceCreamPanel ( 2 );
		
		sidesPanel = new JPanel ( );
		createSidesPanel ( 2 );
		
		
		JPanel contactPanel = new JPanel ( );
		
		contactPanel.add ( new JLabel ( "Contact By: " ) );
		contactPanel.add ( contactPhoneCheck = new JCheckBox ( "Phone" ) );
		contactPanel.add ( contactEmailCheck = new JCheckBox ( "Email" ) );
		
		
		JPanel buttonPanel = new JPanel ( );
		
		buttonPanel.add ( saveReservationButton = new JButton ( "Save Reservation" ) );
		buttonPanel.add ( cancelReservationButton = new JButton ( "Cancel Reservation" ) );
		
		panel.add ( titlePanel );
		panel.add ( guestPanel );
		panel.add ( cardPanel );
		panel.add ( roomPanel );
		panel.add ( mealPlanPanel );
		panel.add ( contactPanel );
		panel.add ( buttonPanel );
		
		this.add ( panel );
	}
	
	class SaveButtonListener implements ActionListener
	{	
		/**
		 * saves the order, hides this frame, and returns to neworderframe
		 */
		@Override
		public void actionPerformed ( ActionEvent click ) {
			String name = guestNameField.getText ( );
			String address = guestAddressField.getText ( );
			String phone = guestAddressField.getText ( );
			String email = guestEmailField.getText ( );
			
			int dobMonth = ( int ) dobMonthCombo.getSelectedItem ( );
			int dobDay = ( int ) dobDayCombo.getSelectedItem ( );
			int dobYear = ( int ) dobYearCombo.getSelectedItem ( );
			Date dob = new Date ( dobMonth, dobDay, dobYear );
			
			String cardCompany = ( String ) cardCompanyCombo.getSelectedItem ( );
			String ccNumber = ccNumberField.getText ( );
			String securityCode = cardSecurityField.getText ( );
			
			int expMonth = ( int ) expMonthCombo.getSelectedItem ( );
			int expYear = ( int ) expYearCombo.getSelectedItem ( );
			Date expDate = new Date ( expMonth, expYear );
			
			Card paymentMethod = new Card ( cardCompany, ccNumber, securityCode, expDate );
			
			Guest guest = new Guest ( name, address, phone, email, dob, paymentMethod );
			
			//Roov 
			
			//Reservation r = new Reservation ( "" );
		}
	}

	
	// so the reason why all my listeners have new DefaultboXmodel is beacuse if they used the same model,
	// then they would all cahnge simultaneously, instead of individually
	
	/**
	 * inner class listener for cancel button
	 */
	class CancelButtonListener implements ActionListener
	{
		/**
		 * hides this frame and goes back to neworderframe
		 */
		@Override
		public void actionPerformed ( ActionEvent click ) {
		}
	}
	
	class RoomListener implements ActionListener
	{
		@Override
		public void actionPerformed ( ActionEvent click ) {
			if ( ( ( String ) roomTypeCombo.getSelectedItem ( ) ).contains ( "Lounge" ) ) { // if it's a lounge
				startHourCombo.setModel ( new DefaultComboBoxModel < String > ( loungeHours ) ); // change to dusplay lounge hours
				endHourCombo.setModel ( new DefaultComboBoxModel < String > ( loungeHours ) );
			} else { // else its a party room
				startHourCombo.setModel ( new DefaultComboBoxModel < String > ( partyHours ) ); // change to dusplay party hours
				endHourCombo.setModel ( new DefaultComboBoxModel < String > ( partyHours ) );
			}
		}
	}
	
	class StartHourListener implements ActionListener
	{
		@Override
		public void actionPerformed ( ActionEvent click ) {
			int index = ( int ) startHourCombo.getSelectedIndex ( );
			int size = ( int ) startHourCombo.getItemCount ( );
			
			if ( index == size - 1 ) { // if the hour chosen was the last one, make it so that they cant choose past 0 min
				String [ ] zero = { "00" };
				startMinCombo.setModel ( new DefaultComboBoxModel < String > ( zero ) );
			} else { // else any other hour was chosen
				if ( startMinCombo.getItemCount ( ) == 1 ) { // if youre coming from the last hour available, reset the box
					startMinCombo.setModel ( new DefaultComboBoxModel < String > ( minutes ) );
				}
			}
		}
	}
	
	class EndHourListener implements ActionListener
	{
		@Override
		public void actionPerformed ( ActionEvent click ) {
			int index = ( int ) endHourCombo.getSelectedIndex ( );
			int size = ( int ) endHourCombo.getItemCount ( );
			
			if ( index == size - 1 ) { // if the hour chosen was the last one, make it so that they cant choose past 0 min
				String [ ] zero = { "00" };
				endMinCombo.setModel ( new DefaultComboBoxModel < String > ( zero ) );
			} else { // else any other hour was chosen
				if ( endMinCombo.getItemCount ( ) == 1 ) { // if youre coming from the last hour available, reset the box
					endMinCombo.setModel ( new DefaultComboBoxModel < String > ( minutes ) );
				}
			}
		}
	}
	
	class YearListener implements ActionListener
	{
		@Override
		public void actionPerformed ( ActionEvent click ) {
			Integer month = ( Integer ) dobMonthCombo.getSelectedItem ( );
			Integer year = ( Integer ) dobYearCombo.getSelectedItem ( );
			if ( year % 4 == 0 ) { // if it's a leap year
				if ( month == 2 ) { // if its february of a leap year
					dobDayCombo.setModel ( new DefaultComboBoxModel < Integer > ( days29 ) ); // make it so it displays 1-29
				}
			} else { // else change it back to 28 
				if ( month == 2 ) {
					dobDayCombo.setModel ( new DefaultComboBoxModel < Integer > ( days28 ) );
				}
			}
		}
	}
	
	class DOBMonthListener implements ActionListener
	{
		@Override
		public void actionPerformed ( ActionEvent click ) {
			Integer month = ( Integer ) dobMonthCombo.getSelectedItem ( );
			Integer year = ( Integer ) dobYearCombo.getSelectedItem ( );
			if ( month == 2 ) { // check if its feb first
				if ( year % 4 == 0 ) { // if its a leap year
					dobDayCombo.setModel ( new DefaultComboBoxModel < Integer > ( days29 ) );
				} else {
					dobDayCombo.setModel ( new DefaultComboBoxModel < Integer > ( days28 ) );
				}
			} else {
				if ( month < 8 ) { // jan - july
					if ( month % 2 == 1 ) { // odd months have 31 days jan-july
						dobDayCombo.setModel ( new DefaultComboBoxModel < Integer > ( days31 ) ); // make it so it displays 1-31
					} else {
						dobDayCombo.setModel ( new DefaultComboBoxModel < Integer > ( days30 ) ); // even months have 1-30
					}
				} else { // else august - dec, opposite day pattern
					if ( month % 2 == 1 ) {
						dobDayCombo.setModel ( new DefaultComboBoxModel < Integer > ( days30 ) ); 
					} else {
						dobDayCombo.setModel ( new DefaultComboBoxModel < Integer > ( days31 ) );
					}
				}
			}
		}
	}
	
	class RoomMonthListener implements ActionListener
	{
		@Override
		public void actionPerformed ( ActionEvent click ) {
			Integer selected = ( Integer ) roomMonthCombo.getSelectedItem ( );
			if ( selected == 2 ) { // check if its feb first
				roomDayCombo.setModel ( new DefaultComboBoxModel < Integer > ( days28 ) );
			} else {
				if ( selected < 8 ) { // jan - july
					if ( selected % 2 == 1 ) { // odd months have 31 days jan-july
						roomDayCombo.setModel ( new DefaultComboBoxModel < Integer > ( days31 ) ); // make it so it displays 1-31
					} else {
						roomDayCombo.setModel ( new DefaultComboBoxModel < Integer > ( days30 ) ); // even months have 1-30
					}
				} else { // else august - dec, opposite day pattern
					if ( selected % 2 == 1 ) {
						roomDayCombo.setModel ( new DefaultComboBoxModel < Integer > ( days30 ) ); 
					} else {
						roomDayCombo.setModel ( new DefaultComboBoxModel < Integer > ( days31 ) );
					}
				}
			}
		}
	}
	
	public void createPizzaPanel ( int amount ) {
		// reset the pizza panel
		int count = pizzaPanel.getComponentCount ( );
		
		if ( count < amount ) {
			for ( int i = count; i < amount; i++ ) {
				JPanel pizza = new JPanel ( );
				pizza.add ( new JLabel ( "Pizza " + ( i + 1 ) + ": " ) );
				pizza.add ( new JCheckBox ( "Cheese" ) );
				pizza.add ( new JCheckBox ( "Pepperoni" ) );
				pizza.add ( new JCheckBox ( "Ham" ) );
				pizza.add ( new JCheckBox ( "Jalapeno" ) );
				pizza.add ( new JCheckBox ( "Sausage" ) );
				pizza.add ( new JCheckBox ( "Mushroom" ) );
				pizza.add ( new JCheckBox ( "Pineapple" ) );
				pizza.add ( new JCheckBox ( "Bell Pepper" ) );
				pizza.add ( new JCheckBox ( "Onion" ) );
				pizza.add ( new JCheckBox ( "Garlic Chicken" ) );
				pizzaPanel.add ( pizza );
			}
		} else if ( count > amount ) {
			for ( int i = count; i > amount; i-- ) {
				pizzaPanel.remove ( i - 1 );
			}
		}
		
		
		mealPlanPanel.add ( pizzaPanel );
	}
	
	public void createSodaPanel ( int amount ) {
		// reset the wings panel
		sodaPanel.removeAll ( );
		
		for ( int i = 0; i < amount; i++ ) {
			JPanel soda = new JPanel ( );
			soda.add ( new JLabel ( "Soda " + ( i + 1 ) + ": " ) );
			
			String [ ] flavors = { "Coca-Cola", "Diet Coke", "Canada Dry", "Crush", "Squirt", "A&W Root Beer" };
			JComboBox < String > flavorsCombo = new JComboBox < String > ( flavors );
			soda.add ( flavorsCombo );
			
			sodaPanel.add ( soda );
		}
		mealPlanPanel.add ( sodaPanel );
	}
	
	public void createWingsPanel ( int amount ) {
		// reset the wings panel
		wingsPanel.removeAll ( );
		
		for ( int i = 0; i < amount; i++ ) {
			JPanel wings = new JPanel ( );
			wings.add ( new JLabel ( "Wings " + ( i + 1 ) + ": " ) );
			
			String [ ] flavors = { "Mild", "Diablo", "Lemon Pepper", "Barbeque", "Sesame" };
			JComboBox < String > flavorsCombo = new JComboBox < String > ( flavors );
			wings.add ( flavorsCombo );
			
			String [ ] bone = { "Bone-In", "Boneless" };
			JComboBox < String > boneCombo = new JComboBox < String > ( bone );
			wings.add ( boneCombo );
			wingsPanel.add ( wings );
		}
		mealPlanPanel.add ( wingsPanel );
	}
	
	public void createIceCreamPanel ( int amount ) {
		// reset the wings panel
		iceCreamPanel.removeAll ( );
		
		for ( int i = 0; i < amount; i++ ) {
			JPanel iceCreams = new JPanel ( );
			iceCreams.add ( new JLabel ( "Ice Cream " + ( i + 1 ) + ": " ) );
			
			String [ ] flavors = { "Chocolate Fudge", "Vanilla Bean", "Strawberry Shortcake", "Choco-Mint", "Butter Pecan" };
			JComboBox < String > flavorsCombo = new JComboBox < String > ( flavors );
			iceCreams.add ( flavorsCombo );
			
			iceCreams.add ( flavorsCombo );
			iceCreamPanel.add ( iceCreams );
		}
		mealPlanPanel.add ( iceCreamPanel );
	}
	
	public void createSidesPanel ( int amount ) {
		// reset the wings panel
		sidesPanel.removeAll ( );
		
		if ( amount > 1 ) {
			sidesPanel.add ( new JLabel ( "Sides: Bread-Sticks and Salad" ) );
		} else {
			for ( int i = 0; i < amount; i++ ) {
				JPanel side = new JPanel ( );
				side.add ( new JLabel ( "Side: " ) );
				
				String [ ] sides = { "Bread-Sticks", "Salad" };
				JComboBox < String > sidesCombo = new JComboBox < String > ( sides );
				side.add ( sidesCombo );
				
				sidesPanel.add ( side );
			}
		}
		mealPlanPanel.add ( sidesPanel );
	}
	
	class MealPlanListener implements ActionListener
	{
		@Override
		public void actionPerformed ( ActionEvent click ) {
			String selected = ( String ) mealPlanCombo.getSelectedItem ( );
			if ( selected.contains ( "Basic" ) ) {
				System.out.print ( "Basic" );
				createPizzaPanel ( 3 );
				createSodaPanel ( 3 );
				createSidesPanel ( 0 );
				createWingsPanel ( 0 );
				createIceCreamPanel ( 0 );
				
			} else if ( selected.contains ( "Bronze" ) ) {
				System.out.print ( "Bronze" );
				createPizzaPanel ( 3 );
				createSodaPanel ( 5 );
				createSidesPanel ( 1 );
				createWingsPanel ( 0 );
				createIceCreamPanel ( 0 );
				
			} else if ( selected.contains ( "Silver" ) ) {
				System.out.print ( "Silver" );
				createPizzaPanel ( 3 );
				createSodaPanel ( 5 );
				createSidesPanel ( 2 );
				createWingsPanel ( 0 );
				createIceCreamPanel ( 0 );
				
			} else if ( selected.contains ( "Gold" ) ) {
				System.out.print ( "Gold" );
				createPizzaPanel ( 3 );
				createSodaPanel ( 5 );
				createSidesPanel ( 2 );
				createWingsPanel ( 2 );
				createIceCreamPanel ( 0 );
				
			} else if ( selected.contains ( "Platinum" ) ) {
				System.out.print ( "Plat" );
				createPizzaPanel ( 4 );
				createSodaPanel ( 5 );
				createSidesPanel ( 2 );
				createWingsPanel ( 2 );
				createIceCreamPanel ( 2 );
				
			}
		}
	}
	
	public static void main ( String [ ] args ) {
		NewReservationFrame f = new NewReservationFrame ( );
	}
}
