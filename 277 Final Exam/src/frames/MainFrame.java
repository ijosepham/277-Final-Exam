package frames;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;

import rooms.*;

public class MainFrame extends JFrame {
	JFrame thisFrame = this;
	JMenuBar menuBar;
	JScrollPane scrollPane;
	JPanel centerPanel;
	PartyWorld partyWorld;

	//border settings used in the method addARoomDescription ( ) 
 	Border raisedbevel = BorderFactory.createRaisedBevelBorder ( ); 
 	Border loweredbevel = BorderFactory.createLoweredBevelBorder ( );
	
	public MainFrame ( PartyWorld partyWorld ) {
		this.partyWorld = partyWorld;
		this.setTitle ( "Reservation System" );
		this.setExtendedState ( JFrame.MAXIMIZED_BOTH ); //makes window screen size
		this.setDefaultCloseOperation ( EXIT_ON_CLOSE );
		
		this.createMenuBar ( );
		this.createDefaultPanel ( );
		this.setVisible ( true );
	}
	


	/*
	 * initializes the default center panel and adds it to this frame
	 * */
	private void createDefaultPanel ( ) {
		centerPanel = new JPanel ( );
		centerPanel.setLayout ( new BoxLayout ( centerPanel, BoxLayout.Y_AXIS ) );
		
		//Title of default view
		JLabel panelTitle = new JLabel ( "Party World Rooms" );
		panelTitle.setFont ( new Font ( Font.SERIF, Font.BOLD, 30 ) );
		
		centerPanel.add ( panelTitle );
		addRoomDescription ( centerPanel, "C:\\Users\\appsm\\Documents\\GitHub\\277-Final-Exam\\277 Final Exam\\mparty.jpg", "Small Party Room" , SmallPartyRoom.DESCRIPTION );
		addRoomDescription ( centerPanel, "C:\\Users\\appsm\\Documents\\GitHub\\277-Final-Exam\\277 Final Exam\\sparty.jpg","Medium Party Room", MediumPartyRoom.DESCRIPTION );
		addRoomDescription ( centerPanel, "C:\\Users\\appsm\\Documents\\GitHub\\277-Final-Exam\\277 Final Exam\\aworld.jpg", "Aqua World" , AquaWorld.DESCRIPTION );
		
		scrollPane = new JScrollPane ( centerPanel );
		this.add ( scrollPane, BorderLayout.CENTER );
	}
	
	/* initializes menu bar items and adds them to this window*/
	private void createMenuBar ( ) {
		menuBar = new JMenuBar ( );
		//-------
				JMenu menu;
				JMenu submenu;
				JMenuItem menuItem;
				
				//------- DESCRIPTIONS MENU------------------
				menu = new JMenu ( "Descriptions" );

				//Party Room Sub Menu
				submenu = new JMenu ( "Party Rooms" );

				
				menuItem = new JMenuItem ( "All" );
				menuItem.addActionListener ( new RoomItemListener ( ) );
				submenu.add ( menuItem );

				menuItem = new JMenuItem ( "Small Party Rooms" );
				menuItem.addActionListener ( new RoomItemListener ( ) );
				submenu.add ( menuItem );
				
				menuItem = new JMenuItem ( "Medium Party Rooms" );
				menuItem.addActionListener ( new RoomItemListener ( ) );
				submenu.add ( menuItem );
				
				menuItem = new JMenuItem ( "Aqua World" );
				submenu.add ( menuItem );
				menu.add ( submenu );
				
				//Lounges Sub Menu
				submenu = new JMenu ( "Lounges" );
				
				menuItem = new JMenuItem ( "All" );
				submenu.add ( menuItem );
				
				menuItem = new JMenuItem ( "Karaoke Lounges" );
				submenu.add ( menuItem );
				
				menuItem = new JMenuItem ( "Billiards Lounges" );
				submenu.add ( menuItem );
				
				menu.add ( submenu );
				menu.addSeparator ( );
				
				//Meal Plans Sub Menu
				submenu = new JMenu ( "Meal Plans" );

				menuItem = new JMenuItem ( "All" );
				submenu.add ( menuItem );
				menuItem.addActionListener ( new MealItemListener ( ) );
				
				menuItem = new JMenuItem ( "Basic" );
				submenu.add ( menuItem );
				menuItem.addActionListener ( new MealItemListener ( ) );
				
				menuItem = new JMenuItem ( "Bronze" );
				submenu.add ( menuItem );
				menuItem.addActionListener ( new MealItemListener ( ) );
				
				menuItem = new JMenuItem ( "Silver" );
				submenu.add ( menuItem );
				menuItem.addActionListener ( new MealItemListener ( ) );
				
				menuItem = new JMenuItem ( "Gold" );
				submenu.add ( menuItem );
				menuItem.addActionListener ( new MealItemListener ( ) );
				
				menuItem = new JMenuItem ( "Platinum" );
				submenu.add ( menuItem );
				menuItem.addActionListener ( new MealItemListener ( ) );
				
				menu.add ( submenu );
			
			
				
				menuBar.add ( menu );
				
				
				//------- RESERVATIONS MENU------------------
				menu = new JMenu ( "Reservations" );
						
						//New reservation item
						menuItem = new JMenuItem ( "New Reservation..." );
						menuItem.addActionListener ( new NewReservationListener ( ) );
						menu.add ( menuItem );
						menu.addSeparator ( );
						
						//Edit reservation item
						menuItem = new JMenuItem ( "Edit Existing Reservation..." );
						menuItem.addActionListener ( new EditReservationListener ( ) );
						menu.add ( menuItem );
						menu.addSeparator ( );
						
						
						//Manage reservation sub menu 
						submenu = new JMenu ( "Manage Current Reservation" );
						// menuItem.addActionListener ( new NewReservationListener ( ) );
						submenu.setMnemonic ( KeyEvent.VK_S );

						menuItem = new JMenuItem ( "Check-in" );
						// menuItem.addActionListener ( new NewReservationListener ( ) );
						submenu.add ( menuItem );
						
						menuItem = new JMenuItem ( "Check-out" );
						// menuItem.addActionListener ( new NewReservationListener ( ) );
						submenu.add ( menuItem );
						

						menu.add ( submenu );
				
				
				menuBar.add ( menu );
				this.add ( menuBar, BorderLayout.NORTH );
	}
	
	
	
	/* 
	 * adds room image and description to a given container
	 * @param container - the container onto which to add the new description
	 * @param imgDir - the directory of the image
	 * @param roomName - the name of the room
	 * @param roomDesc - the description of the room
	 * 
	 * */
	 private void addRoomDescription ( Container container, String imgDir, String roomName, String roomDesc ) {
	 	JPanel p = new JPanel ( );
	 	
	 	ImageIcon icon = new ImageIcon ( imgDir );
	 	JLabel picture = new JLabel ( roomName, icon, JLabel.CENTER );
	 	picture.setFont ( new Font ( Font.SERIF, Font.BOLD, 20 ) );
	 	
	 	//Set the position of the text, relative to the icon:
	 	picture.setVerticalTextPosition ( JLabel.TOP );
	 	picture.setHorizontalTextPosition ( JLabel.CENTER );
	 	
	 	//Set border around 
	 	picture.setBorder ( BorderFactory.createCompoundBorder ( raisedbevel, loweredbevel ) );
	 	
	 	p.add ( picture );

	 	JTextArea description = new JTextArea ( 5, 10 );
	 	description.append ( roomDesc );
	 	description.setEditable ( false );
	 	description.setFont ( new Font ( Font.SERIF, Font.PLAIN, 20 ) );
	 	description.setBorder ( BorderFactory.createCompoundBorder ( raisedbevel, loweredbevel ) );
		p.add ( description );
			
	    JButton bookButton = new JButton ( "Book Now" );
	    p.add ( bookButton );
	    container.add ( p );
	  }

//	 private void addMealPlanDescription ( Container container, String imgDir, String mealPlanName, String mealPlanDesc ) {
//	 	JPanel p = new JPanel ( );
//		 	
//	 	ImageIcon icon = new ImageIcon ( imgDir );
//	 	JLabel picture = new JLabel ( mealPlanName, icon, JLabel.CENTER );
//	 	picture.setFont ( new Font ( Font.SERIF, Font.BOLD, 20 ) );
//	 	
//	 	//Set the position of the text, relative to the icon:
//	 	picture.setVerticalTextPosition ( JLabel.TOP );
//	 	picture.setHorizontalTextPosition ( JLabel.CENTER );
//	 	
//	 	//Set border around 
//	 	picture.setBorder ( BorderFactory.createCompoundBorder ( raisedbevel, loweredbevel ) );
//	 	
//	 	p.add ( picture );
//	 	
//	 	JTextArea description = new JTextArea ( 5,10 );
//	 	description.append ( mealPlanDesc );
//	 	description.setEditable ( false );
//	 	description.setFont ( new Font ( Font.SERIF, Font.PLAIN, 20 ) );
//	 	description.setBorder ( BorderFactory.createCompoundBorder ( raisedbevel, loweredbevel ) );
//		p.add ( description );
//		
//	    JButton bookButton = new JButton ( "Book Now" );
//	    p.add ( bookButton );
//	    container.add ( p );
//	  }

	// press on the meal item inside the top menu, then do an action
	class MealItemListener implements ActionListener {

		@Override
		public void actionPerformed ( ActionEvent click ) {
			JMenuItem menuItem = ( JMenuItem ) click.getSource ( );
			String item = menuItem.getText ( );
			System.out.println ( item );
			
			if ( item.equals ( "All" ) ) {
				System.out.println ( "VIEW ALL" ); //replace 
				
			} else if ( item.equals ( "Basic" ) ) {
				System.out.println ( "VIEW BASIC" ); //replace 
				
			} else if ( item.equals ( "Bronze" ) ) {
				System.out.println ( "VIEW BRONZE" );
				
			} else if ( item.equals ( "Silver" ) ) {
				
				
			} else if ( item.equals ( "Gold" ) ) {
				
				
			} else if ( item.equals ( "Platinum" ) ) {
				
			}
		}
	}
	
	// same but its for rooms
	class RoomItemListener implements ActionListener {

		@Override
		public void actionPerformed ( ActionEvent select ) {
			JMenuItem item = ( JMenuItem ) select.getSource ( );
			
			if ( item.getText ( ).contains ( "Aqua" ) ) {
				System.out.println ( "Display only Aqua Room" );
			} else if ( item.getText ( ).contains ( "Medium" ) ) {
				System.out.println ( "Display only Medium Party Room" );
			} else if ( item.getText ( ).contains ( "Small" ) ) {
				System.out.println ( "Display only Small Party Room" );
			} else if ( item.getText ( ).contains ( "Billiards" ) ) {
				System.out.println ( "Display only Billiards Room" );
			} else if ( item.getText ( ).contains ( "Karaoke" ) ) {
				System.out.println ( "Display only Karaoke Room" );
			}
		}
	}
	
	class NewReservationListener implements ActionListener 
	{
		@Override
		public void actionPerformed ( ActionEvent select ) {
			thisFrame.dispose ( );
			
			new NewReservationFrame ( partyWorld );
		}
	}
	
	class EditReservationListener implements ActionListener 
	{
		@Override
		public void actionPerformed ( ActionEvent select ) {
			thisFrame.dispose ( );
			
			new EditReservationFrame ( partyWorld );
		}
	}
	
	public static void main ( String [ ] args ) {
		PartyWorld partyWorld = new PartyWorld ( );
		MainFrame f = new MainFrame ( partyWorld );
		f.setVisible ( true );
	}
}
