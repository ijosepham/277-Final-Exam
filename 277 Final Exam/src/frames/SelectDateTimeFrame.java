package frames;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import reservation.Date;
import reservation.Reservation;
import reservation.Time;
import rooms.*;

public class SelectDateTimeFrame extends JFrame {
	JFrame thisFrame = this;
	PartyWorld partyWorld;
	
	JSpinner monthSpinner;
	JSpinner daySpinner;
	
	JSpinner startHourSpinner;
	JSpinner startMinuteSpinner;
	
	JSpinner endHourSpinner;
	JSpinner endMinuteSpinner;
	
	
	Integer [ ] days31;
	Integer [ ] days30;
	Integer [ ] days29;
	Integer [ ] days28;
	
	String [ ] partyHours;
	String [ ] loungeHours;
	String [ ] minutes;
	
	JButton reserveButton;
	JButton cancelButton;
	
	String roomType;
	
	/**
	 * constructor
	 * @param partyWorld - rooms
	 * @param roomType - roomtype from booknow
	 */
	public SelectDateTimeFrame ( PartyWorld partyWorld, String roomType ) {
		this.partyWorld = partyWorld;
		this.roomType = roomType;
		
		this.setTitle ( roomType );
		
		this.setExtendedState ( JFrame.MAXIMIZED_BOTH ); //makes window screen size
		this.setDefaultCloseOperation ( EXIT_ON_CLOSE );
	
		
		this.createDefaultPanel ( roomType );
		
		
		this.setVisible ( true );
	}
	
	/**
	 * instantiates all item
	 * @param roomType - roomtype from the booknow button
	 */
	public void createDefaultPanel ( String roomType ) {

		
		JPanel titlePanel = new JPanel ( );
		JLabel title= new JLabel ( "Book Now" );
		title.setFont ( new Font ( Font.SERIF, Font.BOLD, 30 ) );
		
		titlePanel.add ( title, BorderLayout.NORTH );
		
		
		JPanel panel = new JPanel ( );
		
		Integer [ ] months = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
		SpinnerListModel monthModel = new SpinnerListModel ( months );
		monthSpinner = new JSpinner ( monthModel );
		
		
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
		
		SpinnerListModel dayModel = new SpinnerListModel ( days31 );
		daySpinner = new JSpinner ( dayModel );

		
		
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
		
		
		
		if ( roomType.contains ( "Lounge" ) ) {
			startHourSpinner = new JSpinner ( new SpinnerListModel ( loungeHours ) );
			endHourSpinner = new JSpinner ( new SpinnerListModel ( loungeHours ) );
		} else {
			startHourSpinner = new JSpinner ( new SpinnerListModel ( partyHours ) );
			endHourSpinner = new JSpinner ( new SpinnerListModel ( partyHours ) );
		}
		
		
		
		minutes = new String [ 60 ]; // 00 - 59minutes
		for ( int i = 0; i < 10; i++ ) {
			minutes [ i ] = "0" + i;
		}
		for ( int i = 10; i < 60; i++ ) {
			minutes [ i ] = i + "";
		}
		
		startMinuteSpinner = new JSpinner ( new SpinnerListModel ( minutes ) );
		endMinuteSpinner = new JSpinner ( new SpinnerListModel ( minutes ) );
		
		
		Component spinnerEditor = monthSpinner.getEditor ( );
		JFormattedTextField field = ( ( JSpinner.DefaultEditor ) spinnerEditor ).getTextField ( );
		field.setColumns ( 2 );
		
		spinnerEditor = daySpinner.getEditor ( );
		field = ( ( JSpinner.DefaultEditor ) spinnerEditor ).getTextField ( );
		field.setColumns ( 2 );
		
		spinnerEditor = startHourSpinner.getEditor ( );
		field = ( ( JSpinner.DefaultEditor ) spinnerEditor ).getTextField ( );
		field.setColumns ( 2 );
		
		spinnerEditor = startMinuteSpinner.getEditor ( );
		field = ( ( JSpinner.DefaultEditor ) spinnerEditor ).getTextField ( );
		field.setColumns ( 2 );
		
		spinnerEditor = endHourSpinner.getEditor ( );
		field = ( ( JSpinner.DefaultEditor ) spinnerEditor ).getTextField ( );
		field.setColumns ( 2 );
		
		spinnerEditor = endMinuteSpinner.getEditor ( );
		field = ( ( JSpinner.DefaultEditor ) spinnerEditor ).getTextField ( );
		field.setColumns ( 2 );
		
		panel.add ( new JLabel ( "Date: " ) );
		panel.add ( new JLabel ( "Month: " ) );
		panel.add ( monthSpinner );
		panel.add ( new JLabel ( "Day: " ) );
		panel.add ( daySpinner );
		panel.add ( new JLabel ( "Start Time: " ) );
		panel.add ( new JLabel ( "Hour: " ) );
		panel.add ( startHourSpinner );
		panel.add ( new JLabel ( "Minute: " ) );
		panel.add ( startMinuteSpinner );
		panel.add ( new JLabel ( "End Time: " ) );
		panel.add ( new JLabel ( "Hour: " ) );
		panel.add ( endHourSpinner );
		panel.add ( new JLabel ( "Minute: " ) );
		panel.add ( endMinuteSpinner );
		
		reserveButton = new JButton ( "Reserve" );
		reserveButton.addActionListener ( new ReserveButtonListener ( ) );
		
		cancelButton = new JButton ( "Cancel" );
		cancelButton.addActionListener ( new CancelButtonListener ( ) );
		
		panel.add ( reserveButton );
		panel.add ( cancelButton );
		
		this.add ( titlePanel, BorderLayout.NORTH );
		this.add ( panel, BorderLayout.CENTER);
	}
	
	/**
	 * inner class listener for reserve button
	 */
	class ReserveButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed ( ActionEvent click ) {
			Integer month = ( Integer ) monthSpinner.getValue ( );
			Integer day = ( Integer ) daySpinner.getValue ( );
			Integer startHour = Integer.parseInt ( ( String ) startHourSpinner.getValue ( ) );
			Integer startMinute = Integer.parseInt ( ( String ) startMinuteSpinner.getValue ( ) );
			Integer endHour = Integer.parseInt ( ( String ) endHourSpinner.getValue ( ) );
			Integer endMinute = Integer.parseInt ( ( String ) endMinuteSpinner.getValue ( ) );
			
			Date date = new Date ( month, day, 2019 );
			Time startTime = new Time ( startHour, startMinute );
			Time endTime = new Time ( endHour, endMinute );
			
			Reservation res = new Reservation ( );
			res.setDate ( date );
			res.setStartTime ( startTime );
			res.setEndTime ( endTime );
			
			Room room = partyWorld.getAvailableRoom ( roomType, res ); 

			thisFrame.dispose ( );
			
			if ( room == null ) {
				new WaitlistMessageFrame ( partyWorld, roomType, res );
			} else {
				new NewReservationFrame ( partyWorld, room, res, false );
			}
		}
	}
	
	/**
	 * inner class listener for cancel button
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
		new SelectDateTimeFrame ( partyWorld, "Aqua World" );
	}
}
