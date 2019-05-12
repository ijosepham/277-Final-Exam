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
		createPizzaPanel ( 3 );
		
		sodaPanel = new JPanel ( );
		createSodaPanel ( 3 );
		
		sidesPanel = new JPanel ( );
		createSidesPanel ( 0 );
		
		wingsPanel = new JPanel ( );
		createWingsPanel ( 0 );
		
		iceCreamPanel = new JPanel ( );
		createIceCreamPanel ( 0 );

		
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
			System.exit ( 0 );
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
		
		// if you dont have enough pizzas, add smore B^)
		if ( count < amount ) {
			for ( int i = count; i < amount; i++ ) {
				JPanel pizza = new JPanel ( );
				pizza.add ( new JLabel ( "Pizza " + ( i + 1 ) + ": " ) );

				JCheckBox cheese =  ( new JCheckBox ( "Cheese" ) );
				cheese.addActionListener ( new ToppingListener ( ) );
				
				JCheckBox pepperoni =  ( new JCheckBox ( "Pepperoni" ) );
				pepperoni.addActionListener ( new ToppingListener ( ) );
				
				JCheckBox ham =  ( new JCheckBox ( "Ham" ) );
				ham.addActionListener ( new ToppingListener ( ) );
				
				JCheckBox jalapeno =  ( new JCheckBox ( "Jalapeno" ) );
				jalapeno.addActionListener ( new ToppingListener ( ) );
				
				JCheckBox sausage =  ( new JCheckBox ( "Sausage" ) );
				sausage.addActionListener ( new ToppingListener ( ) );
				
				JCheckBox mushroom =  ( new JCheckBox ( "Mushroom" ) );
				mushroom.addActionListener ( new ToppingListener ( ) );
				
				JCheckBox pineapple =  ( new JCheckBox ( "Pineapple" ) );
				pineapple.addActionListener ( new ToppingListener ( ) );
				
				JCheckBox bellpepper =  ( new JCheckBox ( "Bell Pepper" ) );
				bellpepper.addActionListener ( new ToppingListener ( ) );
				
				JCheckBox onion =  ( new JCheckBox ( "Onion" ) );
				onion.addActionListener ( new ToppingListener ( ) );
				
				JCheckBox chicken =  ( new JCheckBox ( "Garlic Chicken" ) );
				chicken.addActionListener ( new ToppingListener ( ) );
				
				pizza.add ( cheese );
				pizza.add ( pepperoni );
				pizza.add ( ham );
				pizza.add ( jalapeno );
				pizza.add ( sausage );
				pizza.add ( mushroom );
				pizza.add ( pineapple );
				pizza.add ( bellpepper );
				pizza.add ( onion );
				pizza.add ( chicken );
				pizzaPanel.add ( pizza );
			}
		} else if ( count > amount ) { // if you have too many, then remove some
			for ( int i = count; i > amount; i-- ) {
				pizzaPanel.remove ( i - 1 );
			}
		}
		
		mealPlanPanel.add ( pizzaPanel );
	}
	
	public void createSodaPanel ( int amount ) {
		// reset the wings panel
		int count = sodaPanel.getComponentCount ( );
		
		if ( count < amount ) {
			for ( int i = count; i < amount; i++ ) {
				JPanel soda = new JPanel ( );
				soda.add ( new JLabel ( "Soda " + ( i + 1 ) + ": " ) );
				
				String [ ] flavors = { "Coca-Cola", "Diet Coke", "Canada Dry", "Crush", "Squirt", "A&W Root Beer" };
				JComboBox < String > flavorsCombo = new JComboBox < String > ( flavors );
				soda.add ( flavorsCombo );
				
				sodaPanel.add ( soda );
			}
		} else {
			for ( int i = count; i > amount; i-- ) {
				sodaPanel.remove ( i - 1 );
			}
		}
		mealPlanPanel.add ( sodaPanel );
	}
	
	public void createWingsPanel ( int amount ) {
		// reset the wings panel
		int count = wingsPanel.getComponentCount ( );
		
		if ( count < amount ) {
			for ( int i = count; i < amount; i++ ) {
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
		} else if ( count > amount ) {
			for ( int i = count; i > amount; i-- ) {
				wingsPanel.remove ( i - 1 );
			}
		}
		
		mealPlanPanel.add ( wingsPanel );
	}
	
	public void createIceCreamPanel ( int amount ) {
		// reset the wings panel
		int count = iceCreamPanel.getComponentCount ( );
		
		if ( count < amount ) {
			for ( int i = count; i < amount; i++ ) {
				JPanel iceCreams = new JPanel ( );
				iceCreams.add ( new JLabel ( "Ice Cream " + ( i + 1 ) + ": " ) );
				
				String [ ] flavors = { "Chocolate Fudge", "Vanilla Bean", "Strawberry Shortcake", "Choco-Mint", "Butter Pecan" };
				JComboBox < String > flavorsCombo = new JComboBox < String > ( flavors );
				iceCreams.add ( flavorsCombo );
				
				iceCreams.add ( flavorsCombo );
				iceCreamPanel.add ( iceCreams );
			}
		} else if ( count > amount ) {
			for ( int i = count; i > amount; i-- ) {
				iceCreamPanel.remove ( i - 1 );
			}
		}
		
		mealPlanPanel.add ( iceCreamPanel );
	}
	
	public void createSidesPanel ( int amount ) {
		// reset the wings panel
		sidesPanel.removeAll ( );
		
		if ( amount == 1 ) { // if only 1 side is allowed, force them to choose which one 
			JPanel side = new JPanel ( );
			side.add ( new JLabel ( "Side: " ) );
			
			String [ ] sides = { "Breadsticks", "Salad" };
			JComboBox < String > sidesCombo = new JComboBox < String > ( sides );
			side.add ( sidesCombo );
			
			sidesPanel.add ( side );
		} else if ( amount == 2 ) {
			sidesPanel.add ( new JLabel ( "Sides: Breadsticks and Salad" ) );
		}
		mealPlanPanel.add ( sidesPanel );
	}
	
	class MealPlanListener implements ActionListener
	{
		@Override
		public void actionPerformed ( ActionEvent click ) {
			String selected = ( String ) mealPlanCombo.getSelectedItem ( );
			// depending on what meal plan, allow up to a certain number of foods
			if ( selected.contains ( "Basic" ) ) {
				createPizzaPanel ( 3 ); // 3 pizzass
				createSodaPanel ( 3 ); // 3 sodas
				createSidesPanel ( 0 ); // no sides
				createWingsPanel ( 0 ); // no wings
				createIceCreamPanel ( 0 ); // no ice cream
				
			} else if ( selected.contains ( "Bronze" ) ) {
				createPizzaPanel ( 3 );
				createSodaPanel ( 5 );
				createSidesPanel ( 1 );
				createWingsPanel ( 0 );
				createIceCreamPanel ( 0 );
				
			} else if ( selected.contains ( "Silver" ) ) {
				createPizzaPanel ( 3 );
				createSodaPanel ( 5 );
				createSidesPanel ( 2 );
				createWingsPanel ( 0 );
				createIceCreamPanel ( 0 );
				
			} else if ( selected.contains ( "Gold" ) ) {
				createPizzaPanel ( 3 );
				createSodaPanel ( 5 );
				createSidesPanel ( 2 );
				createWingsPanel ( 2 );
				createIceCreamPanel ( 0 );
				
			} else if ( selected.contains ( "Platinum" ) ) {
				createPizzaPanel ( 4 );
				createSodaPanel ( 5 );
				createSidesPanel ( 2 );
				createWingsPanel ( 2 );
				createIceCreamPanel ( 2 );
				
			}
			mealPlanPanel.repaint ( );
			mealPlanPanel.invalidate();
			mealPlanPanel.validate();
			mealPlanPanel.repaint();
		}
	}
	
	class ToppingListener implements ActionListener
	{
		@Override
		public void actionPerformed ( ActionEvent click ) {
			// get the checkbox clicked
			Component comp = ( Component ) click.getSource ( );
			
			// get the specific pizza panel clicked, eg pizza1/pizza2
			JPanel panel = ( JPanel ) comp.getParent ( );
			
			// get all the checkboxes in that panel
			Component [ ] toppings = ( Component [ ] ) panel.getComponents ( );
			
			JCheckBox topping = new JCheckBox ( );
			int count = 0; // keep track of how many boxes were ticked
			// check which toppings wwere checked
			for ( int i = 1; i < 11; i++ ) {
				topping = ( JCheckBox ) toppings [ i ];
				if ( topping.isSelected ( ) ) {
					count++;
				}
			}
			
			// get the meal plan
			String mealPlan = ( String ) mealPlanCombo.getSelectedItem ( );
			if ( mealPlan.contains( "Basic" ) ) { // if its a basic meal plan, you cna only have one topping
				if ( count > 1 ) { 
					( ( JCheckBox ) comp ).setSelected ( false ); // dont allow them to check any more
				}
			} else if ( mealPlan.contains( "Bronze" ) ) {
				if ( count > 2 ) {
					( ( JCheckBox ) comp ).setSelected ( false );
				}
			} else if ( mealPlan.contains( "Silver" ) ) {
				if ( count > 3 ) {
					( ( JCheckBox ) comp ).setSelected ( false );
				}
			} else if ( mealPlan.contains( "Gold" ) ) {
				if ( count > 3 ) {
					( ( JCheckBox ) comp ).setSelected ( false );
				}
			} else if ( mealPlan.contains( "Plat" ) ) {
				if ( count > 4 ) {
					( ( JCheckBox ) comp ).setSelected ( false );
				}
			}
		}
	}
	
	public static void main ( String [ ] args ) {
		NewReservationFrame f = new NewReservationFrame ( );
	}
}
