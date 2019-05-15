package frames;

import java.awt.event.*;

import javax.swing.*;

import rooms.PartyWorld;

public class WaitlistMessageFrame extends JFrame {
	JButton acceptButton;
	JButton declineButton;
	
	PartyWorld partyWorld;
	
	public WaitlistMessageFrame ( PartyWorld partyWorld ) {
		this.setTitle ( "Waitlist Message" );
		
		this.partyWorld = partyWorld;
		
		this.setExtendedState ( JFrame.MAXIMIZED_BOTH ); //makes window screen size
		this.setDefaultCloseOperation ( EXIT_ON_CLOSE );
		
		this.createDefaultPanel ( );
		this.setVisible ( true );
	}
	
	/*
	 * initializes the default center panel and adds it to this frame
	 * */
	private void createDefaultPanel ( ) {
		JPanel messagePanel = new JPanel ( );
		messagePanel.add ( new JLabel ( "No availability on selected date and time. Add to waitlist?" ) );
		
		
		JPanel buttonPanel = new JPanel ( );
		
		acceptButton = new JButton ( "Accept" );
		acceptButton.addActionListener ( new AcceptButtonListener ( ) );
		
		declineButton = new JButton ( "Decline" );
		declineButton.addActionListener ( new DeclineButtonListener ( ) );
		
		this.add ( messagePanel );
		this.add ( buttonPanel );
	}
	
	class AcceptButtonListener implements ActionListener 
	{
		@Override
		public void actionPerformed ( ActionEvent click ) {
			
		}
	}
	
	class DeclineButtonListener implements ActionListener 
	{
		@Override
		public void actionPerformed ( ActionEvent click ) {
			
		}
	}
}
