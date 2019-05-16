package frames;

import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import reservation.Guest;
import reservation.Reservation;
import rooms.*;

public class CheckOutFrame extends JFrame {
	JFrame thisFrame = this;
	PartyWorld partyWorld;
	
	JPanel panel;
	
	JList < String > guestsList;
	DefaultListModel < String > guestModel;
	
	JButton checkOutButton;
	JButton cancelButton;
	
	JLabel damageChargesLabel;
	JTextField damageChargesField;
	
	JLabel damageDescLabel;
	JTextField damageDescField;
	
	JTextArea finalInvoiceText;
	JButton backButton;
	
	/**
	 * default constructor
	 * @param partyWorld - roooms
	 */
	public CheckOutFrame ( PartyWorld partyWorld ) {
		this.partyWorld = partyWorld;
		
		this.setTitle ( "Check Out Frame" );
		
		this.setExtendedState ( JFrame.MAXIMIZED_BOTH ); //makes window screen size
		this.setDefaultCloseOperation ( EXIT_ON_CLOSE );
		
		this.createDefaultPanel ( );
		
		this.setVisible ( true );
	}
	
	/**
	 * create default items
	 */
	public void createDefaultPanel ( ) {
		panel = new JPanel ( );
		
		damageChargesLabel = new JLabel ( "Damage Charges: $" );
		damageChargesField = new JTextField ( 4 );
		
		damageDescLabel = new JLabel ( "Damage Description: " );
		damageDescField = new JTextField ( 30 );
		
		checkOutButton = new JButton ( "Check Out" );
		checkOutButton.addActionListener ( new CheckOutButtonListener ( ) );

		guestsList = new JList < String > ( );
		guestModel = new DefaultListModel < String > ( );
		guestsList.setModel ( guestModel );
		setGuestModel ( );
		
		cancelButton = new JButton ( "Cancel" );
		cancelButton.addActionListener ( new CancelButtonListener ( ) );
		
		finalInvoiceText = new JTextArea ( );
		
		backButton = new JButton ( "Back" );
		backButton.addActionListener ( new BackButtonListener ( ) );
		
		panel.add ( guestsList );
		panel.add ( damageChargesLabel );
		panel.add ( damageChargesField );
		panel.add ( damageDescLabel );
		panel.add ( damageDescField );
		panel.add ( checkOutButton );
		panel.add ( cancelButton );
		panel.add ( finalInvoiceText );
		panel.add ( backButton );
		
		finalInvoiceText.setVisible ( false );
		backButton.setVisible ( false );
		
		this.add ( panel );
	}
	
	/**
	 * updates the guest model
	 */
	public void setGuestModel ( ) {
		guestModel.clear ( );
		ArrayList < ArrayList < Room > > allRooms = partyWorld.getRooms ( );
		
		ArrayList < Room > rooms;
		ArrayList < Reservation > reservations;
		Reservation res;
		Room room;
			
		// go through aquaworlds, mediums, smalls, etc
		for ( int i = 0; i < allRooms.size ( ); i++ ) {
			rooms = allRooms.get ( i );
			for ( int j = 0; j < rooms.size ( ); j++ ) { // go through all rooms in aquaworld/mediums/etc
				reservations = rooms.get ( j ).getReservations ( );
				for ( int k = 0; k < reservations.size ( ); k++ ) { // go through all reservations
					res = reservations.get ( k );
					room = res.getRoom ( );
					
					if ( res.getCheckedIn ( ) == true ) {
						guestModel.addElement ( res.getConfNum ( ) + "   " + res.getGuest ( ).getName ( ) + " "
							+ room.getName ( ) + ", Room #" + room.getRoomNumber ( ) + 
							", Date: " + res.getDate ( ) + ", " + res.getStartTime ( ) + 
							" - " + res.getEndTime ( ) + "\n" );
					}
				}
			}
		}
		
		if ( guestModel.size ( ) == 0 ) {
			damageChargesLabel.setVisible ( false );
			damageChargesField.setVisible ( false);
			
			damageDescLabel.setVisible ( false );
			damageDescField.setVisible ( false );
			checkOutButton.setVisible ( false );
			
			panel.add ( new JLabel ( "No guests available to check out." ), 0 );
		}
	}
	
	/**
	 * in class listener for check out button
	 */
	class CheckOutButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed ( ActionEvent click ) {
			String [ ] strings = guestsList.getSelectedValue ( ).split ( "   " );
			String confNum = strings [ 0 ]; // the first 9 chars are tyhe conf num
			Reservation res = partyWorld.checkOutReservation ( confNum );
			
			// i should hide all items here and get only the invoice and back button
			guestsList.setVisible ( false );
			damageChargesLabel.setVisible ( false );
			damageChargesField.setVisible ( false );
			damageDescLabel.setVisible ( false );
			damageDescField.setVisible ( false );
			checkOutButton.setVisible ( false );
			cancelButton.setVisible ( false );
			
			Guest g = res.getGuest ( );
			double damageCharges = Double.parseDouble ( damageChargesField.getText ( ) );
			double grandTotal = res.getCost ( ) + damageCharges;
			
			finalInvoiceText.setText ( "Final Invoice: " + "\n" + "\n" );
			finalInvoiceText.append ( "Name: " + g.getName ( ) + "\n" );
			finalInvoiceText.append ( "Card : **** **** **** " + g.getPaymentMethod ( ).getLastCCNumbers ( ) + "\n" );
			finalInvoiceText.append ( "Costs: " + "\n" );
			finalInvoiceText.append ( res.getInvoice ( ) );
			finalInvoiceText.append ( "      Damages: $" + String.format ( "%.2f", damageCharges ) + "\n" + "\n" );
			finalInvoiceText.append ( "Grand Total: $" + String.format ( "%.2f", grandTotal ) );
			
			finalInvoiceText.setVisible ( true );
			backButton.setVisible ( true );
		}
	}
	
	/**
	 * in class listener for back button
	 */
	class BackButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed ( ActionEvent click ) {
			guestsList.setVisible ( true );
			
			damageChargesLabel.setVisible ( true );
			damageChargesField.setVisible ( true );
			
			damageDescLabel.setVisible ( true );
			damageDescField.setVisible ( true );
			
			checkOutButton.setVisible ( true );
			cancelButton.setVisible ( true );
			
			finalInvoiceText.setVisible ( false );
			backButton.setVisible ( false );
			setGuestModel ( );
		}
	}
	
	/**
	 * in class listener for cancel button
	 */
	class CancelButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed ( ActionEvent click ) {
			thisFrame.dispose ( );
			new MainFrame ( partyWorld );
		}
	}
	
	public static void main ( String [ ] args ) {
		PartyWorld partyWorld = new PartyWorld ( );
		new CheckOutFrame ( partyWorld );
	}
}
