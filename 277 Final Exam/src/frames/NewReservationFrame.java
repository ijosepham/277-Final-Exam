package frames;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.Border;

import reservation.*;

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
	JComboBox < String > mealPlanCombo;
	
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
		
		Integer [ ] days = new Integer [ 31 ];
		for ( int i = 0; i < 31; i++ ) {
			days [ i ] = i + 1;
		}
		guestPanel.add ( dobDayCombo = new JComboBox < Integer > ( days ) );
		
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
		
		
		JPanel planel = new JPanel ( ); // its a pun for plan panel hehe

		planel.add ( new JLabel ( "Room Type: " ) );
		String [ ] roomTypes = { "Aqua World", "Medium Party Room", "Small Party Room", "Billiards Lounge", "Karaoke Lounge" };
		planel.add ( roomTypeCombo = new JComboBox < String > ( roomTypes ) );
		
		planel.add ( new JLabel ( "Meal Plan: " ) );
		String [ ] mealPlans = { "Basic Meal Plan", "Bronze Meal Plan", "Silver Meal Plan", "Gold Meal Plan", "Platinum Meal Plan" };
		planel.add ( mealPlanCombo = new JComboBox < String > ( mealPlans ) );
		
		planel.add ( new JLabel ( "Contact By: " ) );
		planel.add ( contactPhoneCheck = new JCheckBox ( "Phone" ) );
		planel.add ( contactEmailCheck = new JCheckBox ( "Email" ) );
		
		
		JPanel buttonPanel = new JPanel ( );
		
		buttonPanel.add ( saveReservationButton = new JButton ( "Save Reservation" ) );
		buttonPanel.add ( cancelReservationButton = new JButton ( "Cancel Reservation" ) );
		
		panel.add ( titlePanel );
		panel.add ( guestPanel );
		panel.add ( cardPanel );
		panel.add ( planel );
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
			
			Reservation r = new Reservation ( "" );
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
