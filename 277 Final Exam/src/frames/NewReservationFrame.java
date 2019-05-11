package frames;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class NewReservationFrame extends JFrame {
	JTextField guestNameField;
	JTextField guestAddressField;
	JTextField guestPhoneField;
	JTextField guestEmailField;
	
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
		JPanel panel1 = new JPanel ( );
		
		JLabel panelTitle = new JLabel ( "New Reservation" );
		panelTitle.setFont ( new Font ( Font.SERIF, Font.BOLD, 30 ) );
		panel1.add ( panelTitle );

		
		JPanel panel = new JPanel ( );
		
		panel.add ( new JLabel ( "Name: " ) );
		panel.add ( guestNameField = new JTextField ( 20 ) );
		
		panel.add ( new JLabel ( "Address" ) );
		panel.add ( guestAddressField = new JTextField ( 17 ) );
		
		panel.add ( new JLabel ( "Phone Number: " ) );
		panel.add ( guestPhoneField = new JTextField ( 10 ) );
		
		panel.add ( new JLabel ( "Email Address: " ) );
		panel.add ( guestEmailField = new JTextField ( 17 ) );
		
		panel.add ( new JLabel ( "Card Companies: " ) );
		String [ ] cardCompanies = { "Visa", "Masterard", "American Express" };
		panel.add ( cardCompanyCombo = new JComboBox < String > ( cardCompanies ) );
		
		panel.add ( new JLabel ( "Credit Card Number: " ) );
		panel.add ( ccNumberField = new JTextField ( 11 ) );
		
		panel.add ( new JLabel ( "CVC: " ) );
		panel.add ( cardSecurityField = new JTextField ( 2 ) );
		
		panel.add ( new JLabel ( "Credit Card Expiration Date: " ) );
		Integer [ ] months = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
		panel.add ( expMonthCombo = new JComboBox < Integer > ( months ) );
		
		Integer [ ] years = { 2015, 2016, 2017, 2018, 2019, 2020, 2021, 2022, 2023, 2024, 2025 };
		panel.add ( expYearCombo = new JComboBox < Integer > ( years ) );
		
		panel.add ( new JLabel ( "Contact By: " ) );
		panel.add ( contactPhoneCheck = new JCheckBox ( "Phone" ) );
		panel.add ( contactEmailCheck = new JCheckBox ( "Email" ) );
		
		panel.add ( new JLabel ( "Room Type: " ) );
		String [ ] roomTypes = { "Aqua World", "Medium Party Room", "Small Party Room", "Billiards Lounge", "Karaoke Lounge" };
		panel.add ( roomTypeCombo = new JComboBox < String > ( roomTypes ) );
		
		panel.add ( new JLabel ( "Meal Plan: " ) );
		String [ ] mealPlans = { "Basic Meal Plan", "Bronze Meal Plan", "Silver Meal Plan", "Gold Meal Plan", "Platinum Meal Plan" };
		panel.add ( mealPlanCombo = new JComboBox < String > ( mealPlans ) );
		
		panel.add ( saveReservationButton = new JButton ( "Save Reservation" ) );
		panel.add ( cancelReservationButton = new JButton ( "Cancel Reservation" ) );
		
		
		
		
		
		this.add ( panel );
	}
	
	public static void main ( String [ ] args ) {
		NewReservationFrame f = new NewReservationFrame ( );
	}
}
