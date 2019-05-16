package frames;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;

import mealplans.*;
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
		addRoomDescription ( centerPanel, "C:\\Users\\appsm\\Documents\\GitHub\\277-Final-Exam\\277 Final Exam\\aworld.jpg", "Aqua World" , AquaWorld.DESCRIPTION );
		addRoomDescription ( centerPanel, "C:\\Users\\appsm\\Documents\\GitHub\\277-Final-Exam\\277 Final Exam\\sparty.jpg","Medium Party Room", MediumPartyRoom.DESCRIPTION );
		addRoomDescription ( centerPanel, "C:\\Users\\appsm\\Documents\\GitHub\\277-Final-Exam\\277 Final Exam\\mparty.jpg", "Small Party Room" , SmallPartyRoom.DESCRIPTION );		
		
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

				menuItem = new JMenuItem ( "Aqua World" );
				menuItem.addActionListener ( new RoomItemListener ( ) );
				submenu.add ( menuItem );

				menuItem = new JMenuItem ( "Medium Party Rooms" );
				menuItem.addActionListener ( new RoomItemListener ( ) );
				submenu.add ( menuItem );
				
				menuItem = new JMenuItem ( "Small Party Rooms" );
				menuItem.addActionListener ( new RoomItemListener ( ) );
				submenu.add ( menuItem );
				
				menu.add ( submenu );
				
				//Lounges Sub Menu
				submenu = new JMenu ( "Lounges" );
				
				menuItem = new JMenuItem ( "All" );
				menuItem.addActionListener ( new LoungeItemListener ( ) );
				submenu.add ( menuItem );
				
				menuItem = new JMenuItem ( "Karaoke Lounges" );
				menuItem.addActionListener ( new LoungeItemListener ( ) );
				submenu.add ( menuItem );
				
				menuItem = new JMenuItem ( "Billiards Lounges" );
				menuItem.addActionListener ( new LoungeItemListener ( ) );
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
						submenu.setMnemonic ( KeyEvent.VK_S );

						menuItem = new JMenuItem ( "Check-in" );
						menuItem.addActionListener ( new CheckInItemListener ( ) );
						submenu.add ( menuItem );
						
						menuItem = new JMenuItem ( "Check-out" );
						menuItem.addActionListener ( new CheckOutItemListener ( ) );
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
	 	description.setFont ( new Font ( Font.SERIF, Font.PLAIN, 15 ) );
	 	description.setBorder ( BorderFactory.createCompoundBorder ( raisedbevel, loweredbevel ) );
		p.add ( description );
			
	    JButton bookButton = new JButton ( "Book Now" );
	    bookButton.addActionListener ( new BookButtonListener ( ) );
	    p.add ( bookButton );
	    container.add ( p );
	  }

	 private void addMealPlanDescription ( Container container, String imgDir, String mealPlanName, String mealPlanDesc ) {
	 	JPanel p = new JPanel ( );
		 	
	 	ImageIcon icon = new ImageIcon ( imgDir );
	 	JLabel picture = new JLabel ( mealPlanName, icon, JLabel.CENTER );
	 	picture.setFont ( new Font ( Font.SERIF, Font.BOLD, 20 ) );
	 	
	 	//Set the position of the text, relative to the icon:
	 	picture.setVerticalTextPosition ( JLabel.TOP );
	 	picture.setHorizontalTextPosition ( JLabel.CENTER );
	 	
	 	//Set border around 
	 	picture.setBorder ( BorderFactory.createCompoundBorder ( raisedbevel, loweredbevel ) );
	 	
	 	p.add ( picture );
	 	
	 	JTextArea description = new JTextArea ( 5,10 );
	 	description.append ( mealPlanDesc );
	 	description.setEditable ( false );
	 	description.setFont ( new Font ( Font.SERIF, Font.PLAIN, 15 ) );
	 	description.setBorder ( BorderFactory.createCompoundBorder ( raisedbevel, loweredbevel ) );
		p.add ( description );
		
	    container.add ( p );
	  }

	// press on the meal item inside the top menu, then do an action
	class MealItemListener implements ActionListener {

		@Override
		public void actionPerformed ( ActionEvent click ) {
			JMenuItem menuItem = ( JMenuItem ) click.getSource ( );
			String item = menuItem.getText ( );
			
			JPanel descriptionPanel = new JPanel ( );
			JLabel description = new JLabel ( "Each meal plan serves 12-15 people. Meal plan costs "
					+ "include serving utensils (plates, cups, etc), and condiments" + 
					"(Parmesan cheese, pepper flakes, salt, pepper)." );
			descriptionPanel.add ( description );
			
			
			if ( item.equals ( "All" ) ) {
				centerPanel.removeAll ( );
				
				//Title of default view
				JLabel panelTitle = new JLabel ( "All Meal Plans" );
				panelTitle.setFont ( new Font ( Font.SERIF, Font.BOLD, 30 ) );
				
				centerPanel.add ( panelTitle );
				centerPanel.add ( descriptionPanel );
				
				addMealPlanDescription ( centerPanel, "C:\\Users\\appsm\\Documents\\GitHub\\277-Final-Exam\\277 Final Exam\\iron.png", "Basic Meal Plan" , BasicMealPlan.DESCRIPTION );
				addMealPlanDescription ( centerPanel, "C:\\Users\\appsm\\Documents\\GitHub\\277-Final-Exam\\277 Final Exam\\bronze.png", "Bronze Meal Plan" , BronzeMealPlan.DESCRIPTION );
				addMealPlanDescription ( centerPanel, "C:\\Users\\appsm\\Documents\\GitHub\\277-Final-Exam\\277 Final Exam\\silver.png", "Silver Meal Plan" , SilverMealPlan.DESCRIPTION );
				addMealPlanDescription ( centerPanel, "C:\\Users\\appsm\\Documents\\GitHub\\277-Final-Exam\\277 Final Exam\\gold.png", "Gold Meal Plan" , GoldMealPlan.DESCRIPTION );
				addMealPlanDescription ( centerPanel, "C:\\Users\\appsm\\Documents\\GitHub\\277-Final-Exam\\277 Final Exam\\plat.png", "Platinum Meal Plan" , PlatinumMealPlan.DESCRIPTION );
				
				thisFrame.revalidate ( );
				thisFrame.repaint ( );
				
			} else if ( item.equals ( "Basic" ) ) {
				centerPanel.removeAll ( );
				
				//Title of default view
				JLabel panelTitle = new JLabel ( "Basic Meal Plan" );
				panelTitle.setFont ( new Font ( Font.SERIF, Font.BOLD, 30 ) );
				
				centerPanel.add ( panelTitle );
				centerPanel.add ( descriptionPanel );
				addMealPlanDescription ( centerPanel, "C:\\Users\\appsm\\Documents\\GitHub\\277-Final-Exam\\277 Final Exam\\iron.png", "Basic Meal Plan" , BasicMealPlan.DESCRIPTION );
				
				thisFrame.revalidate ( );
				thisFrame.repaint ( );
				
			} else if ( item.equals ( "Bronze" ) ) {
				centerPanel.removeAll ( );
				
				//Title of default view
				JLabel panelTitle = new JLabel ( "Bronze Meal Plan" );
				panelTitle.setFont ( new Font ( Font.SERIF, Font.BOLD, 30 ) );
				
				centerPanel.add ( panelTitle );
				centerPanel.add ( descriptionPanel );
				addMealPlanDescription ( centerPanel, "C:\\Users\\appsm\\Documents\\GitHub\\277-Final-Exam\\277 Final Exam\\bronze.png", "Bronze Meal Plan" , BronzeMealPlan.DESCRIPTION );
				
				thisFrame.revalidate ( );
				thisFrame.repaint ( );
				
			} else if ( item.equals ( "Silver" ) ) {
				centerPanel.removeAll ( );
				
				//Title of default view
				JLabel panelTitle = new JLabel ( "Silver Meal Plan" );
				panelTitle.setFont ( new Font ( Font.SERIF, Font.BOLD, 30 ) );
				
				centerPanel.add ( panelTitle );
				centerPanel.add ( descriptionPanel );
				addMealPlanDescription ( centerPanel, "C:\\Users\\appsm\\Documents\\GitHub\\277-Final-Exam\\277 Final Exam\\silver.png", "Silver Meal Plan" , SilverMealPlan.DESCRIPTION );
				
				thisFrame.revalidate ( );
				thisFrame.repaint ( );
				
			} else if ( item.equals ( "Gold" ) ) {
				centerPanel.removeAll ( );
				
				//Title of default view
				JLabel panelTitle = new JLabel ( "Gold Meal Plan" );
				panelTitle.setFont ( new Font ( Font.SERIF, Font.BOLD, 30 ) );
				
				centerPanel.add ( panelTitle );
				centerPanel.add ( descriptionPanel );
				addMealPlanDescription ( centerPanel, "C:\\Users\\appsm\\Documents\\GitHub\\277-Final-Exam\\277 Final Exam\\gold.png", "Gold Meal Plan" , GoldMealPlan.DESCRIPTION );
				
				thisFrame.revalidate ( );
				thisFrame.repaint ( );
				
			} else if ( item.equals ( "Platinum" ) ) {
				centerPanel.removeAll ( );
				
				//Title of default view
				JLabel panelTitle = new JLabel ( "Platinum Meal Plan" );
				panelTitle.setFont ( new Font ( Font.SERIF, Font.BOLD, 30 ) );
				
				centerPanel.add ( panelTitle );
				centerPanel.add ( descriptionPanel );
				addMealPlanDescription ( centerPanel, "C:\\Users\\appsm\\Documents\\GitHub\\277-Final-Exam\\277 Final Exam\\plat.png", "Platinum Meal Plan" , PlatinumMealPlan.DESCRIPTION );
				
				thisFrame.revalidate ( );
				thisFrame.repaint ( );
			}
		}
	}
	
	// same but its for rooms
	class RoomItemListener implements ActionListener {

		@Override
		public void actionPerformed ( ActionEvent select ) {
			JMenuItem item = ( JMenuItem ) select.getSource ( );
			
			if ( item.getText ( ).contains ( "All" ) ) {
				centerPanel.removeAll ( );
				
				//Title of default view
				JLabel panelTitle = new JLabel ( "Party World Rooms" );
				panelTitle.setFont ( new Font ( Font.SERIF, Font.BOLD, 30 ) );
				
				centerPanel.add ( panelTitle );
				addRoomDescription ( centerPanel, "C:\\Users\\appsm\\Documents\\GitHub\\277-Final-Exam\\277 Final Exam\\aworld.jpg", "Aqua World" , AquaWorld.DESCRIPTION );
				addRoomDescription ( centerPanel, "C:\\Users\\appsm\\Documents\\GitHub\\277-Final-Exam\\277 Final Exam\\sparty.jpg","Medium Party Room", MediumPartyRoom.DESCRIPTION );
				addRoomDescription ( centerPanel, "C:\\Users\\appsm\\Documents\\GitHub\\277-Final-Exam\\277 Final Exam\\mparty.jpg", "Small Party Room" , SmallPartyRoom.DESCRIPTION );		
				
				
				thisFrame.revalidate ( );
				thisFrame.repaint ( );
				
			} else if ( item.getText ( ).contains ( "Aqua" ) ) {
				centerPanel.removeAll ( );
				
				//Title of default view
				JLabel panelTitle = new JLabel ( "Aqua World" );
				panelTitle.setFont ( new Font ( Font.SERIF, Font.BOLD, 30 ) );
				
				centerPanel.add ( panelTitle );
				addRoomDescription ( centerPanel, "C:\\Users\\appsm\\Documents\\GitHub\\277-Final-Exam\\277 Final Exam\\aworld.jpg", "Aqua World" , AquaWorld.DESCRIPTION );
				
				
				thisFrame.revalidate ( );
				thisFrame.repaint ( );
				
			} else if ( item.getText ( ).contains ( "Medium" ) ) {
				centerPanel.removeAll ( );
				
				//Title of default view
				JLabel panelTitle = new JLabel ( "Medium Party Room" );
				panelTitle.setFont ( new Font ( Font.SERIF, Font.BOLD, 30 ) );
				
				centerPanel.add ( panelTitle );
				addRoomDescription ( centerPanel, "C:\\Users\\appsm\\Documents\\GitHub\\277-Final-Exam\\277 Final Exam\\sparty.jpg","Medium Party Room", MediumPartyRoom.DESCRIPTION );
				
				
				thisFrame.revalidate ( );
				thisFrame.repaint ( );
				
			} else if ( item.getText ( ).contains ( "Small" ) ) {
				centerPanel.removeAll ( );
				
				//Title of default view
				JLabel panelTitle = new JLabel ( "Small Party Room" );
				panelTitle.setFont ( new Font ( Font.SERIF, Font.BOLD, 30 ) );
				
				centerPanel.add ( panelTitle );
				addRoomDescription ( centerPanel, "C:\\Users\\appsm\\Documents\\GitHub\\277-Final-Exam\\277 Final Exam\\mparty.jpg", "Small Party Room" , SmallPartyRoom.DESCRIPTION );		

				thisFrame.revalidate ( );
				thisFrame.repaint ( );
				
			}
		}
	}
	
	// same but its for rooms
	class LoungeItemListener implements ActionListener {

		@Override
		public void actionPerformed ( ActionEvent select ) {
			JMenuItem item = ( JMenuItem ) select.getSource ( );
			
			if ( item.getText ( ).contains ( "All" ) ) {
				centerPanel.removeAll ( );
				
				//Title of default view
				JLabel panelTitle = new JLabel ( "Party World Lounges" );
				panelTitle.setFont ( new Font ( Font.SERIF, Font.BOLD, 30 ) );
				
				centerPanel.add ( panelTitle );
				addRoomDescription ( centerPanel, "C:\\Users\\appsm\\Documents\\GitHub\\277-Final-Exam\\277 Final Exam\\karaoke.png", "Karaoke Lounge" , KaraokeLounge.DESCRIPTION );
				addRoomDescription ( centerPanel, "C:\\Users\\appsm\\Documents\\GitHub\\277-Final-Exam\\277 Final Exam\\billiards.png","Billiards Lounge", BilliardsLounge.DESCRIPTION );
				
				
				thisFrame.revalidate ( );
				thisFrame.repaint ( );
				
			} else if ( item.getText ( ).contains ( "Karaoke" ) ) {
				centerPanel.removeAll ( );
				
				//Title of default view
				JLabel panelTitle = new JLabel ( "Karaoke Lounge" );
				panelTitle.setFont ( new Font ( Font.SERIF, Font.BOLD, 30 ) );
				
				centerPanel.add ( panelTitle );
				addRoomDescription ( centerPanel, "C:\\Users\\appsm\\Documents\\GitHub\\277-Final-Exam\\277 Final Exam\\karaoke.png", "Karaoke Lounge" , KaraokeLounge.DESCRIPTION );
				
				
				thisFrame.revalidate ( );
				thisFrame.repaint ( );
				
			} else if ( item.getText ( ).contains ( "Billiards" ) ) {
				centerPanel.removeAll ( );
				
				//Title of default view
				JLabel panelTitle = new JLabel ( "Billiards Lounge" );
				panelTitle.setFont ( new Font ( Font.SERIF, Font.BOLD, 30 ) );
				
				centerPanel.add ( panelTitle );
				
				addRoomDescription ( centerPanel, "C:\\Users\\appsm\\Documents\\GitHub\\277-Final-Exam\\277 Final Exam\\billiards.png","Billiards Lounge", BilliardsLounge.DESCRIPTION );				
				
				thisFrame.revalidate ( );
				thisFrame.repaint ( );
				
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
	
	class BookButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed ( ActionEvent select ) {
			JButton button = ( JButton ) select.getSource ( );
			JPanel panel = ( JPanel ) button.getParent ( );
			JLabel label = ( JLabel ) panel.getComponent ( 0 );
			String roomType = ( String ) label.getText ( );
			
			thisFrame.dispose ( );
			
			new SelectDateTimeFrame ( partyWorld, roomType );
		}
	}
	
	class CheckInItemListener implements ActionListener
	{
		@Override
		public void actionPerformed ( ActionEvent click ) {
			thisFrame.dispose ( );
			new CheckInFrame ( partyWorld );
		}
	}
	
	class CheckOutItemListener implements ActionListener
	{
		@Override
		public void actionPerformed ( ActionEvent click ) {
			thisFrame.dispose ( );
			new CheckOutFrame ( partyWorld );
		}
	}
	
	public static void main ( String [ ] args ) {
		PartyWorld partyWorld = new PartyWorld ( );
		MainFrame f = new MainFrame ( partyWorld );
		f.setVisible ( true );
	}
}
