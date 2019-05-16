package frames;

import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import reservation.Reservation;
import rooms.*;

public class CheckInFrame extends JFrame {
	JFrame thisFrame = this;
	PartyWorld partyWorld;
	
	JPanel panel;
	
	JList < String > guestsList;
	DefaultListModel < String > guestModel;
	
	JButton checkInButton;
	JButton cancelButton;
	
	public CheckInFrame ( PartyWorld partyWorld ) {
		this.partyWorld = partyWorld;
		
		this.setTitle ( "Check In Frame" );
		
		this.setExtendedState ( JFrame.MAXIMIZED_BOTH ); //makes window screen size
		this.setDefaultCloseOperation ( EXIT_ON_CLOSE );
	
		
		this.createDefaultPanel ( );
		
		
		this.setVisible ( true );
	}
	

	
	public void createDefaultPanel ( ) {
		panel = new JPanel ( );
		
		guestsList = new JList < String > ( );
		
		guestModel = new DefaultListModel < String > ( );
		
		checkInButton = new JButton ( "Check In" );
		checkInButton.addActionListener ( new CheckInButtonListener ( ) );
		
		setGuestModel ( );

		guestsList.setModel ( guestModel );
		
		cancelButton = new JButton ( "Cancel" );
		cancelButton.addActionListener ( new CancelButtonListener ( ) );
		
		panel.add ( guestsList );
		panel.add ( checkInButton );
		panel.add ( cancelButton );
		
		this.add ( panel );
	}
	
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
					
					if ( res.getCheckedIn ( ) == false ) {
						guestModel.addElement ( res.getConfNum ( ) + "   " + res.getGuest ( ).getName ( ) + " "
							+ room.getName ( ) + ", Room #" + room.getRoomNumber ( ) + 
							", Date: " + res.getDate ( ) + ", " + res.getStartTime ( ) + 
							" - " + res.getEndTime ( ) + "\n" );
					}
				}
			}
		}
		
		if ( guestModel.size ( ) == 0 ) {
			checkInButton.setVisible ( false );
			panel.add ( new JLabel ( "No guests available to check in." ), 0 );
		}
	}
	
	class CheckInButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed ( ActionEvent click ) {
			String [ ] strings = guestsList.getSelectedValue ( ).split ( "   " );
			String confNum = strings [ 0 ]; // the first 9 chars are tyhe conf num
			partyWorld.checkInReservation ( confNum );
			setGuestModel ( );
		}
	}
	
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
		new CheckInFrame ( partyWorld );
	}
}
