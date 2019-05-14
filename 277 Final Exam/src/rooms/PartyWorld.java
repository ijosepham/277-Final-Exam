package rooms;

import java.util.ArrayList;

import reservation.Reservation;
import roomfactories.*;
import rooms.*;

public class PartyWorld {
	
	private ArrayList < Room > aquaWorlds;
	private ArrayList < Room > mediumPartyRooms;
	private ArrayList < Room > smallPartyRooms;
	private ArrayList < Room > billiardsLounges;
	private ArrayList < Room > karaokeLounges;
	
	public PartyWorld ( ) {
		AquaWorldFactory aquaWorldFactory = new AquaWorldFactory ( );
		MediumPartyRoomFactory mPartyFactory = new MediumPartyRoomFactory ( );
		SmallPartyRoomFactory sPartyFactory = new SmallPartyRoomFactory ( );
		BilliardsLoungeFactory bLoungeFactory = new BilliardsLoungeFactory ( );
		KaraokeLoungeFactory kLoungeFactory = new KaraokeLoungeFactory ( );
		
		aquaWorlds = new ArrayList < Room > ( );
		mediumPartyRooms = new ArrayList < Room > ( );
		smallPartyRooms = new ArrayList < Room > ( );
		billiardsLounges = new ArrayList < Room > ( );
		karaokeLounges = new ArrayList < Room > ( );
		
		
		
		aquaWorlds.add ( aquaWorldFactory.createRoom ( ) );
		
		for ( int i = 0; i < RoomFactory.MAX_MEDIUM; i++ ) {
			mediumPartyRooms.add ( mPartyFactory.createRoom ( ) );
		}
		
		for ( int i = 0; i < RoomFactory.MAX_SMALL; i++ ) {
			smallPartyRooms.add ( sPartyFactory.createRoom ( ) );
		}
		
		for ( int i = 0; i < RoomFactory.MAX_BILLIARDS; i++ ) {
			billiardsLounges.add ( bLoungeFactory.createRoom ( ) );
		}
		
		for ( int i = 0; i < RoomFactory.MAX_KARAOKE; i++ ) {
			karaokeLounges.add ( kLoungeFactory.createRoom ( ) );
		}
	}
	
	public ArrayList < Room > getRooms ( String roomType ) {
		if ( roomType.contains ( "Aqua" ) ) {
			return aquaWorlds;
		} else if ( roomType.contains ( "Medium" ) ) {
			return mediumPartyRooms;
		} else if ( roomType.contains ( "Small" ) ) {
			return smallPartyRooms;
		} else if ( roomType.contains ( "Billiards" ) ) {
			return billiardsLounges;
		} else {
			return karaokeLounges;
		}
	}
	
	// gets the next available room. if none are available, returns -1
	public int getAvailableRoom ( String roomType, Reservation r ) {
		Room room;
		if ( roomType.contains ( "Aqua" ) ) {
			if ( aquaWorlds.get ( 0 ).isAvailable ( r ) ) {
				return 0;
			} else {
				return -1;
			}
		} else if ( roomType.contains ( "Medium" ) ) {
			for ( int i = 0; i < mediumPartyRooms.size ( ); i++ ) {
				room = mediumPartyRooms.get ( i );
				if ( room.isAvailable ( r ) ) {
					return i;
				}
			}
		} else if ( roomType.contains ( "Small" ) ) {
			for ( int i = 0; i < smallPartyRooms.size ( ); i++ ) {
				room = smallPartyRooms.get ( i );
				if ( room.isAvailable ( r ) ) {
					return i;
				}
			}
		} else if ( roomType.contains ( "Billiards" ) ) {
			for ( int i = 0; i < billiardsLounges.size ( ); i++ ) {
				room = billiardsLounges.get ( i );
				if ( room.isAvailable ( r ) ) {
					return i;
				}
			}
		} else {
			for ( int i = 0; i < karaokeLounges.size ( ); i++ ) {
				room = karaokeLounges.get ( i );
				if ( room.isAvailable ( r ) ) {
					return i;
				}
			}
		}
		return -1;
	}
	
	// get the next room with the smallest waitlist
	public int getNextAvailableRoom ( String roomType ) {
		Room room;
		int waitlistSize = 0;
		
		if ( roomType.contains ( "Aqua" ) ) {
			 return 0;
		} else if ( roomType.contains ( "Medium" ) ) {
			waitlistSize = mediumPartyRooms.get ( 0 ).getWaitlist ( ).size ( ); // get the size of the waitlist of room1
			
			for ( int i = 0; i < mediumPartyRooms.size ( ); i++ ) {
				room = mediumPartyRooms.get ( i );
				
				if ( room.getWaitlist ( ).size ( ) == 0 ) { // if the first room has an empty waitlist, return it
					return i;
					
				// or if any other waitlist is smaller than the first one
				} else if ( room.getWaitlist ( ).size ( ) < waitlistSize ) { 
					return i;
				}
			}
			
		} else if ( roomType.contains ( "Small" ) ) {
			waitlistSize = smallPartyRooms.get ( 0 ).getWaitlist ( ).size ( ); // get the size of the waitlist of room1
			
			for ( int i = 0; i < smallPartyRooms.size ( ); i++ ) {
				room = smallPartyRooms.get ( i );
				
				if ( room.getWaitlist ( ).size ( ) == 0 ) { // if the first room has an empty waitlist, return it
					return i;
					
				// or if any other waitlist is smaller than the first one
				} else if ( room.getWaitlist ( ).size ( ) < waitlistSize ) { 
					return i;
				}
			}
		} else if ( roomType.contains ( "Billiards" ) ) {
			waitlistSize = billiardsLounges.get ( 0 ).getWaitlist ( ).size ( ); // get the size of the waitlist of room1
			
			for ( int i = 0; i < billiardsLounges.size ( ); i++ ) {
				room = billiardsLounges.get ( i );
				
				if ( room.getWaitlist ( ).size ( ) == 0 ) { // if the first room has an empty waitlist, return it
					return i;
					
				// or if any other waitlist is smaller than the first one
				} else if ( room.getWaitlist ( ).size ( ) < waitlistSize ) { 
					return i;
				}
			}
		} else {
			waitlistSize = karaokeLounges.get ( 0 ).getWaitlist ( ).size ( ); // get the size of the waitlist of room1
			
			for ( int i = 0; i < karaokeLounges.size ( ); i++ ) {
				room = karaokeLounges.get ( i );
				
				if ( room.getWaitlist ( ).size ( ) == 0 ) { // if the first room has an empty waitlist, return it
					return i;
					
				// or if any other waitlist is smaller than the first one
				} else if ( room.getWaitlist ( ).size ( ) < waitlistSize ) { 
					return i;
				}
			}
		}
		// gets here if all waitlists of that roomtype are the same size
		return 0; // return the first room
	}
	
	public Room getRoom ( String roomType, int index ) {
		if ( roomType.contains ( "Aqua" ) ) {
			return aquaWorlds.get ( index );
		} else if ( roomType.contains ( "Medium" ) ) {
			return mediumPartyRooms.get ( index );
		} else if ( roomType.contains ( "Small" ) ) {
			return smallPartyRooms.get ( index );
		} else if ( roomType.contains ( "Billiards" ) ) {
			return billiardsLounges.get ( index );
		} else {
			return karaokeLounges.get ( index );
		}
	}
	
	public void waitlist ( String roomType, int index, Reservation r ) {
		if ( roomType.contains ( "Aqua" ) ) {
			aquaWorlds.get ( index ).addToWaitlist ( r );
		} else if ( roomType.contains ( "Medium" ) ) {
			mediumPartyRooms.get ( index ).addToWaitlist ( r );
		} else if ( roomType.contains ( "Small" ) ) {
			smallPartyRooms.get ( index ).addToWaitlist ( r );
		} else if ( roomType.contains ( "Billiards" ) ) {
			billiardsLounges.get ( index ).addToWaitlist ( r );
		} else {
			karaokeLounges.get ( index ).addToWaitlist ( r );
		}
	}
	
	public void reserve ( String roomType, int index, Reservation r ) {
		if ( roomType.contains ( "Aqua" ) ) {
			aquaWorlds.get ( index ).reserve ( r );
		} else if ( roomType.contains ( "Medium" ) ) {
			mediumPartyRooms.get ( index ).reserve ( r );
		} else if ( roomType.contains ( "Small" ) ) {
			smallPartyRooms.get ( index ).reserve ( r );
		} else if ( roomType.contains ( "Billiards" ) ) {
			billiardsLounges.get ( index ).reserve ( r );
		} else {
			karaokeLounges.get ( index ).reserve ( r );
		}
	}
}
