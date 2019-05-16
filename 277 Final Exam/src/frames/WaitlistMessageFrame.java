package frames;

import java.awt.BorderLayout;
import java.awt.event.*;

import javax.swing.*;

import reservation.*;
import rooms.PartyWorld;
import rooms.Room;

public class WaitlistMessageFrame extends JFrame {
	JFrame thisFrame = this;
	JButton acceptButton;
	JButton declineButton;
	
	Reservation res;
	PartyWorld partyWorld;
	String roomType;
	
	/**
	 * constructor
	 * @param partyWorld - rooms
	 * @param roomType - roomtype of the waitlisted room
	 * @param res - reservation of the waitlsited room
	 */
	public WaitlistMessageFrame ( PartyWorld partyWorld, String roomType, Reservation res ) {
		this.setTitle ( "Waitlist Message" );
		
		this.res = res;
		this.partyWorld = partyWorld;
		this.roomType = roomType;
		
		this.setExtendedState ( JFrame.MAXIMIZED_BOTH ); //makes window screen size
		this.setDefaultCloseOperation ( EXIT_ON_CLOSE );
		
		this.createDefaultPanel ( );
		this.setVisible ( true );
	}
	
	/**
	 * initializes the items
	 * */
	private void createDefaultPanel ( ) {
		JPanel messagePanel = new JPanel ( );
		messagePanel.add ( new JLabel ( "No availability on selected date and time. Add to waitlist?" ) );
		
		
		JPanel buttonPanel = new JPanel ( );
		
		acceptButton = new JButton ( "Accept" );
		acceptButton.addActionListener ( new AcceptButtonListener ( ) );
		
		declineButton = new JButton ( "Decline" );
		declineButton.addActionListener ( new DeclineButtonListener ( ) );
		
		buttonPanel.add ( acceptButton );
		buttonPanel.add ( declineButton );
		
		this.add ( messagePanel, BorderLayout.NORTH );
		this.add ( buttonPanel, BorderLayout.CENTER );
	}
	
	/**
	 * inner class listener for accept button
	 */
	class AcceptButtonListener implements ActionListener 
	{
		@Override
		public void actionPerformed ( ActionEvent click ) {
			thisFrame.dispose ( );
			
			Room room = partyWorld.getNextAvailableRoom ( roomType );
			new NewReservationFrame ( partyWorld, room, res, true );
		}
	}
	
	/**
	 * inner class listener for decline button
	 */
	class DeclineButtonListener implements ActionListener 
	{
		@Override
		public void actionPerformed ( ActionEvent click ) {
			thisFrame.dispose ( );
			new SelectDateTimeFrame ( partyWorld, roomType );
		}
	}
	
	public static void main ( String [ ] args ) {
		PartyWorld partyWorld = new PartyWorld ( );
		new WaitlistMessageFrame ( partyWorld, "Aqua World", new Reservation ( ) );
	}
}
