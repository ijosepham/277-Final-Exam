package rooms;

import java.util.ArrayList;

import reservation.Reservation;
import roomfactories.*;

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
	
	// gets the next available room. if none are available, returns -1
	public Room getAvailableRoom ( String roomType, Reservation r ) {
		Room room;
		if ( roomType.contains ( "Aqua" ) ) {
			if ( aquaWorlds.get ( 0 ).isAvailable ( r ) ) {
				return aquaWorlds.get ( 0 );
			}
		} else if ( roomType.contains ( "Medium" ) ) {
			for ( int i = 0; i < mediumPartyRooms.size ( ); i++ ) {
				room = mediumPartyRooms.get ( i );
				if ( room.isAvailable ( r ) ) {
					return room;
				}
			}
		} else if ( roomType.contains ( "Small" ) ) {
			for ( int i = 0; i < smallPartyRooms.size ( ); i++ ) {
				room = smallPartyRooms.get ( i );
				if ( room.isAvailable ( r ) ) {
					return room;
				}
			}
		} else if ( roomType.contains ( "Billiards" ) ) {
			for ( int i = 0; i < billiardsLounges.size ( ); i++ ) {
				room = billiardsLounges.get ( i );
				if ( room.isAvailable ( r ) ) {
					return room;
				}
			}
		} else {
			for ( int i = 0; i < karaokeLounges.size ( ); i++ ) {
				room = karaokeLounges.get ( i );
				if ( room.isAvailable ( r ) ) {
					return room;
				}
			}
		}
		return null;
	}
	
	// get the next room with the smallest waitlist
	public Room getNextAvailableRoom ( String roomType ) {
		Room room;
		int waitlistSize = 0;
		
		if ( roomType.contains ( "Aqua" ) ) {
			 return aquaWorlds.get ( 0 );
		} else if ( roomType.contains ( "Medium" ) ) {
			waitlistSize = mediumPartyRooms.get ( 0 ).getWaitlist ( ).size ( ); // get the size of the waitlist of room1
			
			for ( int i = 0; i < mediumPartyRooms.size ( ); i++ ) {
				room = mediumPartyRooms.get ( i );
				
				if ( room.getWaitlist ( ).size ( ) == 0 ) { // if the first room has an empty waitlist, return it
					return room;
					
				// or if any other waitlist is smaller than the first one
				} else if ( room.getWaitlist ( ).size ( ) < waitlistSize ) { 
					return room;
				}
			}
			// gets here if all waitlists of that roomtype are the same size
			return mediumPartyRooms.get ( 0 ); // return the first room
			
		} else if ( roomType.contains ( "Small" ) ) {
			waitlistSize = smallPartyRooms.get ( 0 ).getWaitlist ( ).size ( ); // get the size of the waitlist of room1
			
			for ( int i = 0; i < smallPartyRooms.size ( ); i++ ) {
				room = smallPartyRooms.get ( i );
				
				if ( room.getWaitlist ( ).size ( ) == 0 ) { // if the first room has an empty waitlist, return it
					return room;
					
				// or if any other waitlist is smaller than the first one
				} else if ( room.getWaitlist ( ).size ( ) < waitlistSize ) { 
					return room;
				}
			}
			// gets here if all waitlists of that roomtype are the same size
			return smallPartyRooms.get ( 0 ); // return the first room
			
		} else if ( roomType.contains ( "Billiards" ) ) {
			waitlistSize = billiardsLounges.get ( 0 ).getWaitlist ( ).size ( ); // get the size of the waitlist of room1
			
			for ( int i = 0; i < billiardsLounges.size ( ); i++ ) {
				room = billiardsLounges.get ( i );
				
				if ( room.getWaitlist ( ).size ( ) == 0 ) { // if the first room has an empty waitlist, return it
					return room;
					
				// or if any other waitlist is smaller than the first one
				} else if ( room.getWaitlist ( ).size ( ) < waitlistSize ) { 
					return room;
				}
			}
			// gets here if all waitlists of that roomtype are the same size
			return billiardsLounges.get ( 0 ); // return the first room
			
		} else {
			waitlistSize = karaokeLounges.get ( 0 ).getWaitlist ( ).size ( ); // get the size of the waitlist of room1
			
			for ( int i = 0; i < karaokeLounges.size ( ); i++ ) {
				room = karaokeLounges.get ( i );
				
				if ( room.getWaitlist ( ).size ( ) == 0 ) { // if the first room has an empty waitlist, return it
					return room;
					
				// or if any other waitlist is smaller than the first one
				} else if ( room.getWaitlist ( ).size ( ) < waitlistSize ) { 
					return room;
				}
			}
			
			// gets here if all waitlists of that roomtype are the same size
			return karaokeLounges.get ( 0 ); // return the first room
		}
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
	
	public int getIndex ( String roomType, Room room ) {
		if ( roomType.contains ( "Aqua" ) ) {
			return aquaWorlds.indexOf ( room );
		} else if ( roomType.contains ( "Medium" ) ) {
			return mediumPartyRooms.indexOf ( room );
		} else if ( roomType.contains ( "Small" ) ) {
			return smallPartyRooms.indexOf ( room );
		} else if ( roomType.contains ( "Billiards" ) ) {
			return billiardsLounges.indexOf ( room );
		} else {
			return karaokeLounges.indexOf ( room );
		}
	}
	
	/**
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
	*/
	
	public void setRoom ( String roomType, int index, Room room ) {
		if ( roomType.contains ( "Aqua" ) ) {
			aquaWorlds.set ( index, room );
		} else if ( roomType.contains ( "Medium" ) ) {
			mediumPartyRooms.set ( index, room );
		} else if ( roomType.contains ( "Small" ) ) {
			smallPartyRooms.set ( index, room );
		} else if ( roomType.contains ( "Billiards" ) ) {
			billiardsLounges.set ( index, room );
		} else {
			karaokeLounges.set ( index, room );
		}
	}
}
