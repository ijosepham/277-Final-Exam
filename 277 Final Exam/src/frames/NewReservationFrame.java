package frames;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

import food.*;
import rooms.*;
import pizzas.*;
import mealplans.*;
import reservation.*;

public class NewReservationFrame extends JFrame {
	JFrame thisFrame = this;
	
	JPanel titlePanel;
	
	JPanel guestPanel;
	Date today = new Date ( 5, 16, 2019 );
	JTextField guestNameField;
	JTextField guestAddressField;
	JTextField guestPhoneField;
	JTextField guestEmailField;
	
	JComboBox < Integer > dobMonthCombo;
	JComboBox < Integer > dobDayCombo;
	JComboBox < Integer > dobYearCombo;
	
	JPanel cardPanel;
	JTextField cardNameField;
	JComboBox < String > cardCompanyCombo;
	JTextField ccNumberField;
	JTextField cardSecurityField;
	JComboBox < Integer > expMonthCombo;
	JComboBox < Integer > expYearCombo;
	
	JPanel roomPanel;
	JPanel roomTypePanel;
	JComboBox < String > roomTypeCombo;
	
	JPanel roomDatePanel;
	JComboBox < Integer > roomMonthCombo;
	JComboBox < Integer > roomDayCombo;
	
	JPanel roomStartPanel;
	JComboBox < String > startHourCombo;
	JComboBox < String > startMinCombo;
	
	JPanel roomEndPanel;
	JComboBox < String > endHourCombo;
	JComboBox < String > endMinCombo;
	
	JPanel sizePanel;
	JTextField sizeField;
	JPanel themesPanel;
	JComboBox < String > themeCombo;
	JLabel restrictionsLabel;
	
	JPanel mealPlanPanel;
	JComboBox < String > mealPlanCombo;
	JCheckBox mealUpgradeBox;
	JPanel pizzaPanel;
	JPanel wingsPanel;
	JPanel sodaPanel;
	JPanel iceCreamPanel;
	JPanel sidesPanel;
	
	JPanel contactPanel;
	JCheckBox contactPhoneCheck;
	JCheckBox contactEmailCheck;
	
	JPanel reservationPanel;
	JButton saveButton;
	JButton cancelButton;
	
	JPanel postResPanel;
	JTextArea postResText;
	
	JButton waitlistButton;
	JButton cancelWaitlistButton;
	JButton exitButton;
	
	Integer [ ] days31;
	Integer [ ] days30;
	Integer [ ] days29;
	Integer [ ] days28;
	
	String [ ] partyHours;
	String [ ] loungeHours;
	String [ ] minutes;
	
	PartyWorld partyWorld;
	
	String roomType;
	Room room;
	int roomNumber;
	Reservation res;
	
	boolean waitlisted;
	Room waitlistedRoom;
	
	/**
	 * constructor
	 * @param partyWorld - rooms
	 */
	public NewReservationFrame ( PartyWorld partyWorld ) {
		this.setTitle ( "New Reservation" );
		
		this.partyWorld = partyWorld;
		
		waitlisted = false;
		
		this.setExtendedState ( JFrame.MAXIMIZED_BOTH ); //makes window screen size
		this.setDefaultCloseOperation ( EXIT_ON_CLOSE );
		
		this.createDefaultPanel ( );
		this.setVisible ( true );
	}
	
	/**
	 * constructor used from the selectdate/time frame
	 * @param partyWorld - roomms
	 * @param room - room chosen
	 * @param res - rservation masde
	 * @param waitlisted - whether or not itw as a waitlisted res
	 */
	public NewReservationFrame ( PartyWorld partyWorld, Room room, Reservation res, boolean waitlisted ) {
		this.setTitle ( "New Reservation" );
		
		this.partyWorld = partyWorld;
		this.room = room;
		this.waitlisted = waitlisted;
		if ( waitlisted == true ) {
			waitlistedRoom = room;
		}
		
		this.setExtendedState ( JFrame.MAXIMIZED_BOTH ); //makes window screen size
		this.setDefaultCloseOperation ( EXIT_ON_CLOSE );
		
		this.createDefaultPanel ( );
		this.setDateTime ( room, res );
		
		this.setVisible ( true );
	}
	
	/**
	 * sets the date and time of the room
	 * @param room - room 
	 * @param res - res to set date and time to
	 */
	public void setDateTime ( Room room, Reservation res ) {
		Date date = res.getDate ( );
		Time startTime = res.getStartTime ( );
		Time endTime = res.getEndTime ( );
		
		roomTypeCombo.setSelectedItem ( room.getName ( ) );
		roomMonthCombo.setSelectedItem ( date.getMonth ( ) );
		roomDayCombo.setSelectedItem ( date.getDay ( ) );
		
		startHourCombo.setSelectedItem ( startTime.getHour ( ) + "" );
		startMinCombo.setSelectedIndex ( startTime.getMinute ( ) );
		
		endHourCombo.setSelectedItem ( endTime.getHour ( ) + "" );
		endMinCombo.setSelectedIndex ( endTime.getMinute ( ) );
	}
	
	/**
	 * initializes the default center panel and adds it to this frame
	 * */
	private void createDefaultPanel ( ) {
		JPanel panel = new JPanel ( );
		panel.setLayout ( new BoxLayout ( panel, BoxLayout.Y_AXIS ) );
		
		
		titlePanel = new JPanel ( );
		
		JLabel titleLabel = new JLabel ( "New Reservation" );
		titleLabel.setFont ( new Font ( Font.SERIF, Font.BOLD, 30 ) );
		titlePanel.add ( titleLabel );

		
		guestPanel = new JPanel ( );
		
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
		
		
		days31 = new Integer [ 31 ]; // days 1-31
		for ( int i = 0; i < 31; i++ ) {
			days31 [ i ] = i + 1;
		}
		
		days30 = new Integer [ 30 ]; // days 1-30
		for ( int i = 0; i < 30; i++ ) {
			days30 [ i ] = i + 1;
		}
		
		days29 = new Integer [ 29 ]; // days 1-29
		for ( int i = 0; i < 29; i++ ) {
			days29 [ i ] = i + 1;
		}
		
		days28 = new Integer [ 28 ]; // days 1-28
		for ( int i = 0; i < 28; i++ ) {
			days28 [ i ] = i + 1;
		}
		
		dobDayCombo = new JComboBox < Integer > ( days31 );
		guestPanel.add ( dobDayCombo );
		
		Integer [ ] years = new Integer [ 101 ]; // make an array of 100 years
		for ( int i = 0; i <= 100; i++ ) {
			years [ i ] = 2019 - i;
		}
		dobYearCombo = new JComboBox < Integer > ( years );
		dobYearCombo.addActionListener ( new YearListener ( ) );
		guestPanel.add ( dobYearCombo );
		
		
		cardPanel = new JPanel ( );
		
		cardPanel.add ( new JLabel ( "Name on Card: " ) );
		cardPanel.add ( cardNameField = new JTextField ( 20 ) );
		
		cardPanel.add ( new JLabel ( "Card Company: " ) );
		String [ ] cardCompanies = { "Visa", "Mastercard", "American Express" };
		cardPanel.add ( cardCompanyCombo = new JComboBox < String > ( cardCompanies ) );
		
		cardPanel.add ( new JLabel ( "Card Number: " ) );
		cardPanel.add ( ccNumberField = new JTextField ( 12 ) );
		
		cardPanel.add ( new JLabel ( "CVC: " ) );
		cardPanel.add ( cardSecurityField = new JTextField ( 3 ) );
		
		cardPanel.add ( new JLabel ( "Expiration Date: " ) );
		cardPanel.add ( expMonthCombo = new JComboBox < Integer > ( months ) );
		
		Integer [ ] expYears = new Integer [ 16 ]; // 5 years into the past and into the future
		for ( int i = 0; i < 16; i++ ) {
			expYears [ i ] = 2025 - i;
		}
		cardPanel.add ( expYearCombo = new JComboBox < Integer > ( expYears ) );
		
		
		// JPanel planel = new JPanel ( ); // its a pun for plan panel hehe // man i didnt getta use this
		roomPanel = new JPanel ( );
		
		roomTypePanel = new JPanel ( );
		roomTypePanel.add ( new JLabel ( "Room Type: " ) );
		String [ ] roomTypes = { "Aqua World", "Medium Party Room", "Small Party Room", "Billiards Lounge", "Karaoke Lounge" };
		roomTypeCombo = new JComboBox < String > ( roomTypes );
		roomTypeCombo.addActionListener ( new RoomListener ( ) );
		roomTypePanel.add ( roomTypeCombo );
		roomPanel.add ( roomTypePanel );
		
		roomDatePanel = new JPanel ( );
		roomDatePanel.add ( new JLabel ( "Date: " ) );
		roomMonthCombo = new JComboBox < Integer > ( months );
		roomMonthCombo.setSelectedItem ( 5 );
		roomMonthCombo.addActionListener ( new RoomMonthListener ( ) );
		roomDatePanel.add ( roomMonthCombo );
		roomDayCombo = new JComboBox < Integer > ( days30 );
		roomDayCombo.setSelectedItem ( 16 );
		roomDatePanel.add ( roomDayCombo );
		roomPanel.add ( roomDatePanel );
		
		partyHours = new String [ 16 ]; // party room hours, starts at 9 nds at 12
		partyHours [ 0 ] = "09";
		for ( int i = 1; i < 16; i++ ) {
			partyHours [ i ] = i + 9 + "";
		}
		
		loungeHours = new String [ 17 ]; // starts at 9 ends at 1am
		loungeHours [ 0 ] = "09";
		for ( int i = 1; i < 15; i++ ) {
			loungeHours [ i ] = i + 9 + "";
		}
		loungeHours [ 15 ] = "00";
		loungeHours [ 16 ] = "01";
		
		roomStartPanel = new JPanel ( );
		roomStartPanel.add ( new JLabel ( "Start Time: " ) );
		startHourCombo = new JComboBox < String > ( partyHours );
		startHourCombo.addActionListener ( new StartHourListener ( ) );
		roomStartPanel.add ( startHourCombo );
		
		minutes = new String [ 60 ]; // 00 - 59minutes
		for ( int i = 0; i < 10; i++ ) {
			minutes [ i ] = "0" + i;
		}
		for ( int i = 10; i < 60; i++ ) {
			minutes [ i ] = i + "";
		}
		roomStartPanel.add ( startMinCombo = new JComboBox < String > ( minutes ) );
		roomPanel.add ( roomStartPanel );
		
		roomEndPanel = new JPanel ( );
		roomEndPanel.add ( new JLabel ( "End Time: " ) );
		endHourCombo = new JComboBox < String > ( partyHours );
		endHourCombo.addActionListener ( new EndHourListener ( ) );
		roomEndPanel.add ( endHourCombo );
		roomEndPanel.add ( endMinCombo = new JComboBox < String > ( minutes ) );
		roomPanel.add ( roomEndPanel );
		
		sizePanel = new JPanel ( );
		sizePanel.add ( new JLabel ( "Party Size: " ) );
		sizeField = new JTextField ( 2 );
		sizePanel.add ( sizeField );
		roomPanel.add ( sizePanel );
		
		themesPanel = new JPanel ( );
		setThemesPanel ( "Aqua Party" );
		restrictionsLabel = new JLabel ( "Restrictions: Bathing suits must be worn to access water facilities." );
		roomPanel.add ( restrictionsLabel );
		
		
		mealPlanPanel = new JPanel ( );
		
		mealPlanPanel.add ( new JLabel ( "Meal Plan: " ) );
		
		String [ ] mealPlans = { "No Meal Plan", "Basic Meal Plan" };
		mealPlanCombo = new JComboBox < String > ( mealPlans );
		mealPlanCombo.setSelectedIndex ( 1 );
		mealPlanCombo.addActionListener ( new MealPlanListener ( ) );
		mealPlanPanel.add ( mealPlanCombo );
		
		mealUpgradeBox = new JCheckBox ( "Upgrade" );
		mealUpgradeBox.addActionListener ( new UpgradeListener ( ) );
		mealPlanPanel.add ( mealUpgradeBox );
		
		pizzaPanel = new JPanel ( );
		pizzaPanel.setLayout ( new BoxLayout ( pizzaPanel, BoxLayout.Y_AXIS ) );
		setPizzaPanel ( 3 );
		
		sodaPanel = new JPanel ( );
		setSodaPanel ( 3 );
		
		sidesPanel = new JPanel ( );
		setSidesPanel ( 0 );
		
		wingsPanel = new JPanel ( );
		setWingsPanel ( 0 );
		
		iceCreamPanel = new JPanel ( );
		setIceCreamPanel ( 0 );

		
		contactPanel = new JPanel ( );
		
		contactPanel.add ( new JLabel ( "Contact By: " ) );
		contactPanel.add ( contactPhoneCheck = new JCheckBox ( "Phone" ) );
		contactPanel.add ( contactEmailCheck = new JCheckBox ( "Email" ) );
		
		
		reservationPanel = new JPanel ( );
		
		saveButton = new JButton ( "Save Reservation" );
		saveButton.addActionListener ( new SaveButtonListener ( ) );
		reservationPanel.add ( saveButton );
		
		cancelButton = new JButton ( "Cancel Reservation" );
		cancelButton.addActionListener ( new CancelButtonListener ( ) );
		reservationPanel.add ( cancelButton );
		
		
		// this is here because it formatted weird if put in resrvation panel
		postResPanel = new JPanel ( );
		
		postResText = new JTextArea ( );
		postResText.setEditable ( false );
		postResPanel.add ( postResText );
		postResPanel.setVisible ( false );
		
		waitlistButton = new JButton ( "Waitlist" );
		waitlistButton.addActionListener ( new WaitlistButtonListener ( ) );
		
		cancelWaitlistButton = new JButton ( "Cancel" );
		cancelWaitlistButton.addActionListener ( new CancelWaitlistButtonListener ( ) );
		
		postResPanel.add ( waitlistButton );
		postResPanel.add ( cancelWaitlistButton );
		
		waitlistButton.setVisible ( false );
		cancelWaitlistButton.setVisible ( false );
		
		exitButton = new JButton ( "Exit" );
		exitButton.addActionListener ( new CancelButtonListener ( ) );
		exitButton.setVisible ( false );
		postResPanel.add ( exitButton );
		
		
		panel.add ( titlePanel );
		panel.add ( guestPanel );
		panel.add ( cardPanel );
		panel.add ( roomPanel );
		panel.add ( mealPlanPanel );
		panel.add ( contactPanel );
		panel.add ( reservationPanel );
		panel.add ( postResPanel );
		
		
		this.add ( panel );
	}
	
	/**
	 * updates the themes panels
	 * @param roomType - type of room
	 */
	public void setThemesPanel ( String roomType ) {
		if ( roomType.contains ( "Party" ) ) {
			if ( themesPanel.getComponentCount ( ) == 0 ) { // if its currently empty, add the ones we need
				themesPanel.add ( new JLabel ( "Upgrades: " ) );
				if ( roomType.contains ( "Aqua" ) ) {
					themesPanel.add ( new JCheckBox ( "Towel Rentals" ) );
				}
				
				themesPanel.add ( new JCheckBox ( "Party Favor Bags" ) );
				themesPanel.add ( new JCheckBox ( "Projector" ) );
				
				JCheckBox themeBox = new JCheckBox ( "Party Decoration Set-Up" );
				themeBox.addActionListener ( new ThemeListener ( ) );
				
				themesPanel.add ( themeBox );
				
			} else { // either has 3/4
				JCheckBox checkBox = ( JCheckBox ) themesPanel.getComponent ( 1 ); // get the first check box
				
				if ( checkBox.getText ( ).contains ( "Towel" ) ) { // if its towel
					if ( ! roomType.contains ( "Aqua" ) ) { // and its not aqua world
						themesPanel.remove ( 1 ); // remove it
					}
				} else { // if there's no towel
					if ( roomType.contains ( "Aqua" ) ) { // and its aqua
						themesPanel.add ( new JCheckBox ( "Towel Rentals" ), 1 ); // add it
					}
				}
			}
		} else { // if its the lounge, thers no upgrades available
			themesPanel.removeAll ( );
		}
		
		roomPanel.add ( themesPanel, 5 );
	}
	
	/**
	 * updates the restrictions labels
	 * @param roomType - type of room
	 */
	public void setRestrictionsPanel ( String roomType ) {
		if ( roomType.contains ( "Aqua" ) ) {
			restrictionsLabel.setText ( "Restrictions: Bathing suits must be worn to access water facilities." );
		} else if ( roomType.contains ( "Billiards" ) ) {
			restrictionsLabel.setText ( "Restrictions: 21-year-olds and up only." );
		} else {
			restrictionsLabel.setText ( "" );
		}
	}
	
	/**
	 * show how many pizzas on the panel
	 * @param amount - amount of pizzaws
	 */
	public void setPizzaPanel ( int amount ) {
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
	
	/**
	 * makes sure that there werent too many toppings chosen
	 * @param amount - amount allowed
	 */
	public void validateToppings ( int amount ) {
		int count; // count of toppings per pizza
		JPanel panel = new JPanel ( ); // pizza1, pizza2, pizza3
		Component [ ] toppings; // checkboxes of the pizza
		JCheckBox topping = new JCheckBox ( ); // specific topping
		ArrayList < Integer > checkedToppings = new ArrayList < Integer > ( ); // index of checked toppings
		
		// go through each pizza on the panel
		for ( int i = 0; i < pizzaPanel.getComponentCount ( ); i++ ) {
			checkedToppings = new ArrayList < Integer > ( );
			panel = ( JPanel ) pizzaPanel.getComponent ( i );
			toppings = ( Component [ ] ) panel.getComponents ( );
			count = 0;
			
			// go through each topping on the specific pizza
			for ( int j = 1; j < 11; j++ ) {
				topping = ( JCheckBox ) toppings [ j ];
				if ( topping.isSelected ( ) ) { // check if its checked
					checkedToppings.add ( j );
					count++;
				}
			}
			
			// if checked toppings are more than allowed, uncheck the last checked one
			if ( count > amount ) {
				for ( int j = 0; j < count - amount; j++ ) {
					( ( JCheckBox ) panel.getComponent ( checkedToppings.get ( j ) ) ).setSelected ( false );
				}
			}
		}
	}
	
	/**
	 * sets soda panel
	 * @param amount - amount of sodas
	 */
	public void setSodaPanel ( int amount ) {
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
	
	/**
	 * sets wings panel
	 * @param amount - amount of wings
	 */
	public void setWingsPanel ( int amount ) {
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
	
	/**
	 * sets ice cream panel
	 * @param amount - amount of ice creams
	 */
	public void setIceCreamPanel ( int amount ) {
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
	
	/**
	 * sets the sides panel
	 * @param amount - amount of sides
	 */
	public void setSidesPanel ( int amount ) {
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

	/**
	 * sets the upgrades for rooms
	 */
	public void setUpgradePanel ( ) {
		if ( ! mealUpgradeBox.isSelected ( ) ) { //
			String roomType = ( String ) roomTypeCombo.getSelectedItem ( );
			if ( roomType.contains ( "Lounge" ) ) { // lounge room
				String [ ] mealPlans = { "No Meal Plan" };	
				mealPlanCombo.setModel ( new DefaultComboBoxModel < String > ( mealPlans ) );
				
				setPizzaPanel ( 0 ); // 3 pizzass
				setSodaPanel ( 0 ); // 3 sodas
				setWingsPanel ( 0 ); // no wings
				setIceCreamPanel ( 0 ); // no ice cream
				setSidesPanel ( 0 ); // no sides
				
			} else { // party room
				String [ ] mealPlans = { "No Meal Plan", "Basic Meal Plan" };
				mealPlanCombo.setModel ( new DefaultComboBoxModel < String > ( mealPlans ) );
				
				setPizzaPanel ( 3 ); // 3 pizzass
				validateToppings ( 1 ); // make sure only one topping is checked
				setSodaPanel ( 3 ); // 3 sodas
				setWingsPanel ( 0 ); // no wings
				setIceCreamPanel ( 0 ); // no ice cream
				setSidesPanel ( 0 ); // no sides
			}
		}
	}
	
	/**
	 * inner class listener for save button
	 */
	class SaveButtonListener implements ActionListener
	{	
		/**
		 * saves the order, hides this frame, and returns to neworderframe
		 */
		@Override
		public void actionPerformed ( ActionEvent click ) {
			// guest info
			String name = guestNameField.getText ( );
			String address = guestAddressField.getText ( );
			String phone = guestPhoneField.getText ( );
			String email = guestEmailField.getText ( );
			
			
			// guest dob
			int dobMonth = ( int ) dobMonthCombo.getSelectedItem ( );
			int dobDay = ( int ) dobDayCombo.getSelectedItem ( );
			int dobYear = ( int ) dobYearCombo.getSelectedItem ( );
			Date dob = new Date ( dobMonth, dobDay, dobYear );
			
			// payment info
			String cardName = cardNameField.getText ( );
			String cardCompany = ( String ) cardCompanyCombo.getSelectedItem ( );
			String ccNumber = ccNumberField.getText ( );
			String securityCode = cardSecurityField.getText ( );
			
			
			// card exp date
			int expMonth = ( int ) expMonthCombo.getSelectedItem ( );
			int expYear = ( int ) expYearCombo.getSelectedItem ( );
			Date expDate = new Date ( expMonth, expYear );
			
			Card paymentMethod = new Card ( cardName, cardCompany, ccNumber, securityCode, expDate );
			
			Guest guest = new Guest ( name, address, phone, email, dob, paymentMethod );
			
			
			// room date
			int roomMonth = ( int ) roomMonthCombo.getSelectedItem ( );
			int roomDay = ( int ) roomDayCombo.getSelectedItem ( );
			Date roomDate = new Date ( roomMonth, roomDay, 2019 );
			
			
			// room start time
			int startHour = Integer.parseInt ( ( String ) startHourCombo.getSelectedItem ( ) );
			int startMin = Integer.parseInt ( ( String ) startMinCombo.getSelectedItem ( ) );
			Time startTime = new Time ( startHour, startMin );
			
			
			// room end time
			int endHour = Integer.parseInt ( ( String ) endHourCombo.getSelectedItem ( ) );
			int endMin = Integer.parseInt ( ( String ) endMinCombo.getSelectedItem ( ) );
			Time endTime = new Time ( endHour, endMin );
			
			
			// party size
			String size = ( String ) sizeField.getText ( );
			int partySize = 0;
			if ( size.length ( ) != 0 ) {
				partySize = Integer.parseInt ( ( String ) sizeField.getText ( ) );
			}
			
			
			// upgrades
			ArrayList < String > specialAmenities = new ArrayList < String > ( );
			JCheckBox upgrade = new JCheckBox ( );
			String amenity;
			for ( int i = 1; i < themesPanel.getComponentCount ( ); i++ ) {
				
				if ( themesPanel.getComponent ( i ) instanceof JCheckBox ) {
					upgrade = ( JCheckBox ) themesPanel.getComponent ( i );
					if ( upgrade.isSelected ( ) ) { // add all items checked
						amenity = upgrade.getText ( );
						
						if ( upgrade.getText ( ).contains ( "Decoration" ) ) { // if its the theme set up
							amenity += ( ": " + ( String ) themeCombo.getSelectedItem ( ) ); // add the theme
						}
						
						specialAmenities.add ( amenity );
					}
				}
			}
			// add the meal combo if it was an upgrade
			if ( mealUpgradeBox.isSelected ( ) ) {
				specialAmenities.add ( ( String ) mealPlanCombo.getSelectedItem ( ) );
			}
			
			
			// create a meal plan according to what they chose
			String meal = ( String ) mealPlanCombo.getSelectedItem ( );
			MealPlan mealPlan = new BasicMealPlan ( );
			if ( meal.contains ( "No" ) ) {
				mealPlan = null;
			} else if ( meal.contains ( "Basic" ) ) {
				mealPlan = new BasicMealPlan ( );
			} else if ( meal.contains ( "Bronze" ) ) {
				mealPlan = new BronzeMealPlan ( );
			} else if ( meal.contains ( "Silver" ) ) {
				mealPlan = new SilverMealPlan ( );
			} else if ( meal.contains ( "Gold" ) ) {
				mealPlan = new GoldMealPlan ( );
			} else if ( meal.contains ( "Platinum" ) ) {
				mealPlan = new PlatinumMealPlan ( );
			}
			
			// adding all pizzas to the meal plan
			Pizza pizza;
			JPanel panel = new JPanel ( ); // pizza1, pizza2, pizza3
			Component [ ] toppings; // checkboxes of the pizza
			JCheckBox topping = new JCheckBox ( ); // specific topping
			
			// go through each pizza on the panel
			for ( int i = 0; i < pizzaPanel.getComponentCount ( ); i++ ) {
				pizza = new Pizza ( );
				panel = ( JPanel ) pizzaPanel.getComponent ( i );
				toppings = ( Component [ ] ) panel.getComponents ( );

				
				// go through each topping on the specific pizza
				for ( int j = 1; j < 11; j++ ) {
					topping = ( JCheckBox ) toppings [ j ];
					if ( topping.isSelected ( ) ) { // check if its checked
						if ( topping.getText ( ).contains ( "Cheese" ) ) {
							pizza = new Cheese ( pizza );
						} else if ( topping.getText ( ).contains ( "Pepperoni" ) ) {
							pizza = new Pepperoni ( pizza );
						} else if ( topping.getText ( ).contains ( "Ham" ) ) {
							pizza = new Ham ( pizza );
						} else if ( topping.getText ( ).contains ( "Jalapeno" ) ) {
							pizza = new Jalapeno ( pizza );
						} else if ( topping.getText ( ).contains ( "Sausage" ) ) {
							pizza = new Sausage ( pizza );
						} else if ( topping.getText ( ).contains ( "Mushroom" ) ) {
							pizza = new Mushroom ( pizza );
						} else if ( topping.getText ( ).contains ( "Pineapple" ) ) {
							pizza = new Pineapple ( pizza );
						} else if ( topping.getText ( ).contains ( "Bell Pepper" ) ) {
							pizza = new BellPepper ( pizza );
						} else if ( topping.getText ( ).contains ( "Onion" ) ) {
							pizza = new Onion ( pizza );
						} else if ( topping.getText ( ).contains ( "Garlic Chicken" ) ) {
							pizza = new GarlicChicken ( pizza );
						}
					}
				}
				mealPlan.addFood ( pizza );
			}
			
			
			// adding sodas
			String flavor = "";
			JComboBox < String > flavors = new JComboBox < String > ( );

			// go through each soda on the panel
			for ( int i = 0; i < sodaPanel.getComponentCount ( ); i++ ) {
				panel = ( JPanel ) sodaPanel.getComponent ( i ); // get sodapanel1/2/3
				flavors = ( JComboBox < String > ) panel.getComponent ( 1 ); // get the combobox
				flavor = ( String ) flavors.getSelectedItem ( ); // get the flavor slected
			
				mealPlan.addFood ( new Soda ( flavor ) );
			}
			
			
			// add sides
			if ( mealPlan instanceof SilverMealPlan ) { // silver meal plan only chooses one side
				flavors = ( JComboBox < String > ) sidesPanel.getComponent ( 1 ); // get the combo box
				flavor =  ( String ) flavors.getSelectedItem ( ); // get the selected item
				
				mealPlan.addFood ( new Side ( flavor ) );
			} else if ( ! ( mealPlan instanceof BasicMealPlan ) && mealPlan != null ) { // every other beisde basic and bronze get both
				mealPlan.addFood ( new Side ( "Breadsticks" ) );
				mealPlan.addFood ( new Side ( "Salad" ) );
			}
			
			
			// add wings
			JComboBox < String > bones = new JComboBox < String > ( );
			String bone = "";
			// go through each wing on the panel
			for ( int i = 0; i < wingsPanel.getComponentCount ( ); i++ ) {
				panel = ( JPanel ) wingsPanel.getComponent ( i ); // get wingspanel1/2/3
				flavors = ( JComboBox < String > ) panel.getComponent ( 1 ); // get the flavors box
				flavor = ( String ) flavors.getSelectedItem ( ); // get the flavor slected
			
				bones = ( JComboBox < String > ) panel.getComponent ( 2 ); // get the bones box
				bone = ( String ) bones.getSelectedItem ( );
				
				if ( bone.contains ( "In" ) ) { // if bone in
					mealPlan.addFood ( new Wings ( flavor, true ) );
				} else { // if boneless
					mealPlan.addFood ( new Wings ( flavor, false ) );
				}
			}
			
			
			// add ice cream
			// go through each ice cream on the panel
			for ( int i = 0; i < iceCreamPanel.getComponentCount ( ); i++ ) {
				panel = ( JPanel ) iceCreamPanel.getComponent ( i ); // get icecreampanel1/2/3
				flavors = ( JComboBox < String > ) panel.getComponent ( 1 ); // get the combobox
				flavor = ( String ) flavors.getSelectedItem ( ); // get the flavor slected
			
				mealPlan.addFood ( new IceCream ( flavor ) );
			}
			
			
			// contact by
			ArrayList < Boolean > contactBy = new ArrayList < Boolean > ( );
			for ( int i = 1; i < 3; i++ ) { 
				if ( ( ( JCheckBox ) contactPanel.getComponent ( i ) ).isSelected ( ) ) {
					contactBy.add ( true );
				} else {
					contactBy.add ( false );
				}
			}
			
			
			// make a reservation out of the given info
			res = new Reservation ( guest, roomDate, startTime, endTime, null, specialAmenities, partySize, mealPlan, contactBy );
			
			
			
			roomType = ( String ) roomTypeCombo.getSelectedItem ( );
			boolean valid = true;
			postResText.setText ( "Invalid Reservation: " + "\n" + "\n" );
			
			// first check all info is valid: booking time, cc, partysize, age if billiards
			// start time is later than end time
			
			// so if the start hour is like 00 ( for midnight ), add 24 so it works properly
			Time tempStart = new Time ( startTime.getHour ( ), startTime.getMinute ( ) );
			if ( tempStart.getHour ( ) < 9 ) {
				tempStart.setHour ( tempStart.getHour ( ) + 24 );
			}
			
			// same
			Time tempEnd = new Time ( endTime.getHour ( ), endTime.getMinute ( ) );
			if ( tempEnd.getHour ( ) < 9 ) {
				tempEnd.setHour ( tempEnd.getHour ( ) + 24 );
			}
			
			if ( tempStart.compareTo ( tempEnd ) > 0 ) { 
				postResText.append ( "Start time begins later than end time." + "\n" );
				valid = false;
			}
			
			// if payment is expired
			if ( paymentMethod.isExpired ( today ) ) { 
				postResText.append ( "Payment method has expired." + "\n" );
				valid = false;
			}
			
			// if party size exceeds maximum capacity
			int capacity;
			if ( roomType.contains ( "Aqua" ) ) {
				capacity = AquaWorld.CAPACITY;
			} else if ( roomType.contains ( "Medium" ) ) {
				capacity = MediumPartyRoom.CAPACITY;
			} else if ( roomType.contains ( "Small" ) ) {
				capacity = SmallPartyRoom.CAPACITY;
			} else if ( roomType.contains ( "Billiards" ) ) {
				capacity = BilliardsLounge.CAPACITY;
			} else {
				capacity = KaraokeLounge.CAPACITY;
			}
			if ( partySize > capacity ) {
				postResText.append ( "Party size exceeds maximum capacity." + "\n" );
				valid = false;
			}
			
			// if billiards booker is below 21
			if ( roomType.contains ( "Billiards" ) && ! guest.is21 ( today ) ) {
				postResText.append ( "Not old enough to book a Billiards Lounge." + "\n" );
				valid = false;
			}
			
			// if passes all requirements, book it book it
			if ( valid ) {
				postResText.setText ( "" );
				// check if the roomtype is available at the given date, staart/endtime
				room = partyWorld.getAvailableRoom ( roomType, res ); // gets an available room
				roomNumber = partyWorld.getIndex( roomType, room ); // index of available room
				
				// if no rooms are currently available
				if ( room == null && waitlisted == false ) {
					postResText.append ( "There are no rooms available at the given time."); 
					postResText.append ( "\n" + "Would you like to waitlist instead?" );
					waitlistButton.setVisible ( true );
					cancelWaitlistButton.setVisible ( true );
					
				} else { // if a room is available to reserve immediately
					titlePanel.setVisible ( false );
					guestPanel.setVisible ( false );
					cardPanel.setVisible ( false );
					contactPanel.setVisible ( false );
					roomPanel.setVisible ( false );
					mealPlanPanel.setVisible ( false );
					reservationPanel.setVisible ( false );
					waitlistButton.setVisible ( false );
					cancelWaitlistButton.setVisible ( false );
					
					// if the user came from the waitlist frame, check to make sure they chose the same room
					if ( waitlisted && waitlistedRoom.getName ( ).equals ( roomType ) ) {
						// if the same room, add everything to the waitlist
						room = waitlistedRoom;
						roomNumber = room.getRoomNumber ( ) - 1;
						
						res.setRoom ( room );
						room.addToWaitlist ( res ); // walist the room
						partyWorld.setRoom ( roomType, roomNumber, room ); // update the room inside the list in partyworld
						
						postResText.append ( "You have been waitlisted." );
						postResText.append ( "\n" + "\n" + res );
						
						exitButton.setVisible ( true );
						
					} else {
						//room.setSpecialAmenities ( specialAmenities );
						res.setRoom ( room ); // attach the room to the reservation
						res.finalizeReservation ( ); // initial payment and confirmation number
						
						postResText.append ( "Your room is available in the given time frame. Reserved." );
						postResText.append ( "\n" + "\n" + res );
						
						room.reserve ( res ); // reserve the room
						partyWorld.setRoom ( roomType, roomNumber, room ); // update the room inside the list in partyworld
						
						exitButton.setVisible ( true );
					}
				}
			}
			postResPanel.setVisible ( true );
		}
	}
	
	/**
	 * inner class listener for waitlist button
	 */
	class WaitlistButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed ( ActionEvent click ) {
			room = partyWorld.getNextAvailableRoom ( roomType ); // get the next available room
			roomNumber = partyWorld.getIndex ( roomType, room ); // update the index
			
			res.setRoom ( room ); // attach the room to the reservation
			
			room.addToWaitlist ( res ); // walist the room
			partyWorld.setRoom ( roomType, roomNumber, room ); // update the room inside the list in partyworld
			
			postResText.setText ( "Waitlisted." );
			postResText.append ( "\n" + "You are number " + room.getWaitlist ( ).size ( ) + " on the waitlist." );
			postResText.append ( "\n" + res );
			
			
			titlePanel.setVisible ( false );
			guestPanel.setVisible ( false );
			cardPanel.setVisible ( false );
			contactPanel.setVisible ( false );
			roomPanel.setVisible ( false );
			mealPlanPanel.setVisible ( false );
			reservationPanel.setVisible ( false );
			waitlistButton.setVisible ( false );
			cancelWaitlistButton.setVisible ( false );
			
			exitButton.setVisible ( true );
		}
	}
	
	/**
	 * inner class listener for cancel waitlist button
	 */
	class CancelWaitlistButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed ( ActionEvent click ) {
			waitlistButton.setVisible ( false );
			cancelWaitlistButton.setVisible ( false );
			postResPanel.setVisible ( false );
			
			exitButton.setVisible ( false );
		}
		
	}
	
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
			thisFrame.dispose ( );
			
			// open the new frame
			new MainFrame ( partyWorld );
		}
	}
	
	/**
	 * inner class listener for mealplan upgrade
	 */
	class UpgradeListener implements ActionListener 
	{
		@Override
		public void actionPerformed ( ActionEvent click ) {
			if ( mealUpgradeBox.isSelected ( ) ) { // if they chose to upgrade, then make it them available
				String [ ] mealPlans = { "No Meal Plan", "Basic Meal Plan", "Bronze Meal Plan", "Silver Meal Plan", "Gold Meal Plan", "Platinum Meal Plan" };
				mealPlanCombo.setModel ( new DefaultComboBoxModel < String > ( mealPlans ) );
				mealPlanCombo.setSelectedIndex ( 1 );
			} else { //
				String roomType = ( String ) roomTypeCombo.getSelectedItem ( );
				if ( roomType.contains ( "Lounge" ) ) { // lounge room
					String [ ] mealPlans = { "No Meal Plan" };	
					mealPlanCombo.setModel ( new DefaultComboBoxModel < String > ( mealPlans ) );
					
					setPizzaPanel ( 0 ); // 3 pizzass
					setSodaPanel ( 0 ); // 3 sodas
					setWingsPanel ( 0 ); // no wings
					setIceCreamPanel ( 0 ); // no ice cream
					setSidesPanel ( 0 ); // no sides
					
				} else { // party room
					String [ ] mealPlans = { "No Meal Plan", "Basic Meal Plan" };
					mealPlanCombo.setModel ( new DefaultComboBoxModel < String > ( mealPlans ) );
					mealPlanCombo.setSelectedIndex ( 1 );
					
					setPizzaPanel ( 3 ); // 3 pizzass
					validateToppings ( 1 ); // make sure only one topping is checked
					setSodaPanel ( 3 ); // 3 sodas
					setWingsPanel ( 0 ); // no wings
					setIceCreamPanel ( 0 ); // no ice cream
					setSidesPanel ( 0 ); // no sides
				}
			}
		}
	}
	
	/**
	 * inner class listener for themes
	 */
	class ThemeListener implements ActionListener
	{
		@Override
		public void actionPerformed ( ActionEvent click ) {
			JCheckBox box = ( JCheckBox ) click.getSource ( );
			if ( box.isSelected ( ) ) {
				String [ ] themes = { "Hawaiian", "Sea Life", "Jungle", "Space", "Modern" };
				themeCombo = new JComboBox < String > ( themes );
				
				themesPanel.add ( themeCombo );
			} else {
				themesPanel.remove ( themesPanel.getComponentCount ( ) - 1 );
			}
			themesPanel.revalidate ( );
			themesPanel.repaint ( );
		}
	}
	
	/**
	 * inner class listener for rooms 
	 */
	class RoomListener implements ActionListener
	{
		@Override
		public void actionPerformed ( ActionEvent click ) {
			String roomType = ( String ) roomTypeCombo.getSelectedItem ( );
			setUpgradePanel ( );
			if ( roomType.contains ( "Lounge" ) ) { // if it's a lounge
				startHourCombo.setModel ( new DefaultComboBoxModel < String > ( loungeHours ) ); // change to dusplay lounge hours
				endHourCombo.setModel ( new DefaultComboBoxModel < String > ( loungeHours ) );
				setThemesPanel ( "Lounge" );
				setRestrictionsPanel ( roomType );
			} else { // else its a party room
				startHourCombo.setModel ( new DefaultComboBoxModel < String > ( partyHours ) ); // change to dusplay party hours
				endHourCombo.setModel ( new DefaultComboBoxModel < String > ( partyHours ) );
				
				if ( roomType.contains ( "Aqua" ) ) {
					setThemesPanel ( "Aqua Party" );
				} else {
					setThemesPanel ( "Party" );
				}
				setRestrictionsPanel ( roomType );
				
				// if they're at the default no meal plan, set it to basic cause party rooms come with a basic meal plan
				if ( ( ( String ) mealPlanCombo.getSelectedItem ( ) ).contains ( "No" ) ) {
					mealPlanCombo.setSelectedIndex ( 1 );
				}
			}
			roomPanel.revalidate ( );
			roomPanel.repaint ( );
		}
	}
	
	/**
	 * inner class listener for starthours
	 */
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
	
	/**
	 * inner class listener for end hours button
	 */
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
	
	/**
	 * inner class listener for years
	 */
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
	
	/**
	 * inner class listener for DOB 
	 */
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
	
	/**
	 * inner class listener for months
	 */
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
	
	/**
	 * inner class listener for meal plan
	 */
	class MealPlanListener implements ActionListener
	{
		@Override
		public void actionPerformed ( ActionEvent click ) {
			String selected = ( String ) mealPlanCombo.getSelectedItem ( );
			// depending on what meal plan, allow up to a certain number of foods
			if ( selected.contains ( "No" ) ) {
				setPizzaPanel ( 0 ); 
				setSodaPanel ( 0 ); 
				setWingsPanel ( 0 );
				setIceCreamPanel ( 0 ); 
				setSidesPanel ( 0 );
			}
			if ( selected.contains ( "Basic" ) ) {
				setPizzaPanel ( 3 ); // 3 pizzass
				validateToppings ( 1 ); // make sure only one topping is checked
				setSodaPanel ( 3 ); // 3 sodas
				setWingsPanel ( 0 ); // no wings
				setIceCreamPanel ( 0 ); // no ice cream
				setSidesPanel ( 0 ); // no sides
				
			} else if ( selected.contains ( "Bronze" ) ) {
				setPizzaPanel ( 3 );
				validateToppings ( 2 );
				setSodaPanel ( 5 );
				setWingsPanel ( 0 );
				setIceCreamPanel ( 0 );
				setSidesPanel ( 1 );
				
			} else if ( selected.contains ( "Silver" ) ) {
				setPizzaPanel ( 3 );
				validateToppings ( 3 );
				setSodaPanel ( 5 );
				setWingsPanel ( 0 );
				setIceCreamPanel ( 0 );
				setSidesPanel ( 2 );
				
			} else if ( selected.contains ( "Gold" ) ) {
				setPizzaPanel ( 3 );
				validateToppings ( 3 );
				setSodaPanel ( 5 );
				setWingsPanel ( 2 );
				setIceCreamPanel ( 0 );
				setSidesPanel ( 2 );
				
			} else if ( selected.contains ( "Platinum" ) ) {
				setPizzaPanel ( 4 );
				validateToppings ( 4 );
				setSodaPanel ( 5 );
				setWingsPanel ( 2 );
				setIceCreamPanel ( 2 );
				setSidesPanel ( 2 );
				
			}
			mealPlanPanel.revalidate ( );
			mealPlanPanel.repaint ( );
		}
	}
	
	/**
	 * inner class listener for topping  checkboxes
	 */
	class ToppingListener implements ActionListener
	{
		@Override
		public void actionPerformed ( ActionEvent click ) {
			// get the checkbox clicked
			JCheckBox comp = ( JCheckBox ) click.getSource ( );
			
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
					comp.setSelected ( false ); // dont allow them to check any more
				}
			} else if ( mealPlan.contains( "Bronze" ) ) {
				if ( count > 2 ) {
					comp.setSelected ( false );
				}
			} else if ( mealPlan.contains( "Silver" ) ) {
				if ( count > 3 ) {
					comp.setSelected ( false );
				}
			} else if ( mealPlan.contains( "Gold" ) ) {
				if ( count > 3 ) {
					comp.setSelected ( false );
				}
			} else if ( mealPlan.contains( "Plat" ) ) {
				if ( count > 4 ) {
					comp.setSelected ( false );
				}
			}
		}
	}
	
	public static void main ( String [ ] args ) {
		PartyWorld rooms = new PartyWorld ( );
		NewReservationFrame f = new NewReservationFrame ( rooms );
		f.setVisible ( true );
	}
}
