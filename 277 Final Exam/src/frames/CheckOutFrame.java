package frames;

import javax.swing.*;

import rooms.*;

public class CheckOutFrame extends JFrame {
	PartyWorld partyWorld;
	
	public CheckOutFrame ( PartyWorld partyWorld ) {
		this.partyWorld = partyWorld;
		
		this.setTitle ( "Check Out Frame" );
		
		this.setExtendedState ( JFrame.MAXIMIZED_BOTH ); //makes window screen size
		this.setDefaultCloseOperation ( EXIT_ON_CLOSE );
	
		
		this.createDefaultPanel ( );
		
		
		this.setVisible ( true );
	}
	
	public void createDefaultPanel ( ) {
		
	}
}
