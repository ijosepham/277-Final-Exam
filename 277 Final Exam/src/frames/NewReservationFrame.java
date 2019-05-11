package frames;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.Border;

import reservation.*;

// i need to make a roomtype listener that changes the available times for start/end
// listener for months/years too

public class NewReservationFrame extends JFrame {
	JTextField guestNameField;
	JTextField guestAddressField;
	JTextField guestPhoneField;
	JTextField guestEmailField;
	
	Integer [ ] days31;
	Integer [ ] days30;
	Integer [ ] days29;
	Integer [ ] days28;
	
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
	JComboBox < String > mealPlanCombo;
	JComboBox < Integer > roomMonthCombo;
	JComboBox < Integer > roomDayCombo;
	
	String [ ] partyHours;
	String [ ] loungeHours;
	
	JComboBox < String > startHourCombo;
	JComboBox < String > startMinCombo;
	JComboBox < String > endHourCombo;
	JComboBox < String > endMinCombo;
	
	JButton saveReservationButton;
	JButton cancelReservationButton;
	
	Border raisedbevel = BorderFactory.createRaisedBevelBorder ( ); 
 	Border loweredbevel = BorderFactory.createLoweredBevelBorder ( );
	
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
		guestPanel.add ( dobMonthCombo = new JComboBox < Integer > ( months ) );
		
		days31 = new Integer [ 31 ];
		for ( int i = 0; i < 31; i++ ) {
			days31 [ i ] = i + 1;
		}
		guestPanel.add ( dobDayCombo = new JComboBox < Integer > ( days31 ) );
		
		days30 = days31; // days30 willcrop days31 to only 30 elements instead of 31, so it cuts off the last one
		days29 = days30; // same
		days28 = days29;
		
		Integer [ ] years = new Integer [ 101 ];
		for ( int i = 0; i <= 100; i++ ) {
			years [ i ] = i + 1919;
		}
		guestPanel.add ( dobYearCombo = new JComboBox < Integer > ( years ) );
		
		
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
		cardPanel.add ( expYearCombo = new JComboBox < Integer > ( years ) );
		
		
		// JPanel planel = new JPanel ( ); // its a pun for plan panel hehe // man i didnt getta use this
		JPanel roomPanel = new JPanel ( );
		
		roomPanel.add ( new JLabel ( "Room Type: " ) );
		String [ ] roomTypes = { "Aqua World", "Medium Party Room", "Small Party Room", "Billiards Lounge", "Karaoke Lounge" };
		roomPanel.add ( roomTypeCombo = new JComboBox < String > ( roomTypes ) );
		
		roomPanel.add ( new JLabel ( "Date: " ) );
		roomPanel.add ( roomMonthCombo = new JComboBox < Integer > ( months ) );
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
		roomPanel.add ( startHourCombo = new JComboBox < String > ( partyHours ) );
		
		String [ ] minutes = new String [ 60 ];
		for ( int i = 0; i < 10; i++ ) {
			minutes [ i ] = "0" + i;
		}
		for ( int i = 10; i < 60; i++ ) {
			minutes [ i ] = i + "";
		}
		roomPanel.add ( startMinCombo = new JComboBox < String > ( minutes ) );
		
		roomPanel.add ( new JLabel ( "End Time: " ) );
		roomPanel.add ( endHourCombo = new JComboBox < String > ( partyHours ) );
		roomPanel.add ( endMinCombo = new JComboBox < String > ( minutes ) );
		
		
		JPanel mealPanel = new JPanel ( );
		
		mealPanel.add ( new JLabel ( "Meal Plan: " ) );
		String [ ] mealPlans = { "Basic Meal Plan", "Bronze Meal Plan", "Silver Meal Plan", "Gold Meal Plan", "Platinum Meal Plan" };
		mealPanel.add ( mealPlanCombo = new JComboBox < String > ( mealPlans ) );
		
		
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
		panel.add ( mealPanel );
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
	
	public static void main ( String [ ] args ) {
		NewReservationFrame f = new NewReservationFrame ( );
	}
}
