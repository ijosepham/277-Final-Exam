package rooms;

import java.util.ArrayList;

import reservation.Reservation;
import roomfactories.*;

public class PartyWorld {
	/**
	 * list of all the aqua worlds
	 */
	private ArrayList < Room > aquaWorlds;
	
	/**
	 * list of all the medium party rooms
	 */
	private ArrayList < Room > mediumPartyRooms;
	
	/**
	 * list of all the small party rooms
	 */
	private ArrayList < Room > smallPartyRooms;
	
	/**
	 * list of all the billiards lounges
	 */
	private ArrayList < Room > billiardsLounges;
	
	/**
	 * list of all the karaoke lounges
	 */
	private ArrayList < Room > karaokeLounges;
	
	/**
	 * default constructor
	 */
	public PartyWorld ( ) {
		// create instances of all factories
		AquaWorldFactory aquaWorldFactory = new AquaWorldFactory ( );
		MediumPartyRoomFactory mPartyFactory = new MediumPartyRoomFactory ( );
		SmallPartyRoomFactory sPartyFactory = new SmallPartyRoomFactory ( );
		BilliardsLoungeFactory bLoungeFactory = new BilliardsLoungeFactory ( );
		KaraokeLoungeFactory kLoungeFactory = new KaraokeLoungeFactory ( );
		
		// initialize
		aquaWorlds = new ArrayList < Room > ( );
		mediumPartyRooms = new ArrayList < Room > ( );
		smallPartyRooms = new ArrayList < Room > ( );
		billiardsLounges = new ArrayList < Room > ( );
		karaokeLounges = new ArrayList < Room > ( );
		
		// create rooms
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
	
	/**
	 * returns an arraylist of all the rooms
	 * @return arraylist of all the rooms
	 */
	public ArrayList < ArrayList < Room > > getRooms ( ) {
		ArrayList < ArrayList < Room > > rooms = new ArrayList < ArrayList < Room > > ( );
		rooms.add ( aquaWorlds );
		rooms.add ( mediumPartyRooms );
		rooms.add ( smallPartyRooms );
		rooms.add ( karaokeLounges );
		rooms.add ( billiardsLounges );
		return rooms;
	}
	
	/**
	 * adds the reservation to its room 
	 * @param r - reservatopn to add
	 */
	public void addReservation ( Reservation r ) {
		String roomType = r.getRoom ( ).getName ( );
		int roomNumber = r.getRoom ( ).getRoomNumber ( );
		
		// if its finalized, delete from reservations
		if ( r.isFinalied ( ) ) {
			if ( roomType.contains ( "Aqua" ) ) {
				aquaWorlds.get ( roomNumber - 1 ).addToReservations ( r );
			} else if ( roomType.contains ( "Medium" ) ) {
				mediumPartyRooms.get ( roomNumber - 1 ).addToReservations ( r );
			} else if ( roomType.contains ( "Small" ) ) {
				smallPartyRooms.get ( roomNumber - 1 ).addToReservations ( r );
			} else if ( roomType.contains ( "Billiards" ) ) {
				billiardsLounges.get ( roomNumber - 1 ).addToReservations ( r );
			} else {
				karaokeLounges.get ( roomNumber - 1 ).addToReservations ( r );
			}
			
		} else { // else delete from waitlist
			if ( roomType.contains ( "Aqua" ) ) {
				// get the room ( determined by roomnumber )
				//then delete the reservaiton
				aquaWorlds.get ( roomNumber - 1 ).removeFromWaitlist ( r );
			} else if ( roomType.contains ( "Medium" ) ) {
				mediumPartyRooms.get ( roomNumber - 1 ).removeFromWaitlist( r );
			} else if ( roomType.contains ( "Small" ) ) {
				smallPartyRooms.get ( roomNumber - 1 ).removeFromWaitlist ( r );
			} else if ( roomType.contains ( "Billiards" ) ) {
				billiardsLounges.get ( roomNumber - 1 ).removeFromWaitlist ( r );
			} else {
				karaokeLounges.get ( roomNumber - 1 ).removeFromWaitlist ( r );
			}
		}
	}
	
	/**
	 * delete the reservation of the room to which it belongs
	 * @param reservation
	 */
	public void deleteReservation ( Reservation r ) {
		String roomType = r.getRoom ( ).getName ( );
		int roomNumber = r.getRoom ( ).getRoomNumber ( );
		
		// if its finalized, delete from reservations
		if ( r.isFinalied ( ) ) {
			if ( roomType.contains ( "Aqua" ) ) {
				aquaWorlds.get ( roomNumber - 1 ).removeFromReservations ( r );
			} else if ( roomType.contains ( "Medium" ) ) {
				mediumPartyRooms.get ( roomNumber - 1 ).removeFromReservations ( r );
			} else if ( roomType.contains ( "Small" ) ) {
				smallPartyRooms.get ( roomNumber - 1 ).removeFromReservations ( r );
			} else if ( roomType.contains ( "Billiards" ) ) {
				billiardsLounges.get ( roomNumber - 1 ).removeFromReservations ( r );
			} else {
				karaokeLounges.get ( roomNumber - 1 ).removeFromReservations ( r );
			}
			
		} else { // else delete from waitlist
			if ( roomType.contains ( "Aqua" ) ) {
				// get the room ( determined by roomnumber )
				//then delete the reservaiton
				aquaWorlds.get ( roomNumber - 1 ).removeFromWaitlist ( r );
			} else if ( roomType.contains ( "Medium" ) ) {
				mediumPartyRooms.get ( roomNumber - 1 ).removeFromWaitlist( r );
			} else if ( roomType.contains ( "Small" ) ) {
				smallPartyRooms.get ( roomNumber - 1 ).removeFromWaitlist ( r );
			} else if ( roomType.contains ( "Billiards" ) ) {
				billiardsLounges.get ( roomNumber - 1 ).removeFromWaitlist ( r );
			} else {
				karaokeLounges.get ( roomNumber - 1 ).removeFromWaitlist ( r );
			}
		}
	}
	
	/**
	 * gets the next available reservation on the waitlist
	 * @param res - reservation to be added to confirmed from the waitlist
	 * @return next available reservation on the weaitlist
	 */
	public Reservation getNextAvailableWaitlist ( Reservation res ) {
		Reservation nextRes = null;
		
		// get room attributes
		Room room = res.getRoom ( );
		String roomType = room.getName ( );
		int roomNumber = room.getRoomNumber ( );
		
		ArrayList < Reservation > waitlist;
		
		// find the room, remove the old res from waitlist, finalize, then add it to confirmed
		if ( roomType.contains ( "Aqua" ) ) {
			waitlist = room.getWaitlist ( );
			
			for ( int i = 0; i < waitlist.size ( ); i++ ) {
				nextRes = waitlist.get ( i );
				if ( room.isAvailable ( nextRes ) ) {
					aquaWorlds.get ( roomNumber - 1 ).getWaitlist ( ).remove ( i );
					nextRes.finalizeReservation ( );
					aquaWorlds.get ( roomNumber - 1 ).getReservations ( ).add ( nextRes );
					return nextRes;
				}
			}
			
		} else if ( roomType.contains ( "Medium" ) ) {
			waitlist = room.getWaitlist ( );
			
			for ( int i = 0; i < waitlist.size ( ); i++ ) {
				nextRes = waitlist.get ( i );
				if ( room.isAvailable ( nextRes ) ) {
					mediumPartyRooms.get ( roomNumber - 1 ).getWaitlist ( ).remove ( i );
					nextRes.finalizeReservation ( );
					mediumPartyRooms.get ( roomNumber - 1 ).getReservations ( ).add ( nextRes );
					return nextRes;
				}
			}

		} else if ( roomType.contains ( "Small" ) ) {			
			waitlist = room.getWaitlist ( );
		
			for ( int i = 0; i < waitlist.size ( ); i++ ) {
				nextRes = waitlist.get ( i );
				if ( room.isAvailable ( nextRes ) ) {
					smallPartyRooms.get ( roomNumber - 1 ).getWaitlist ( ).remove ( i );
					nextRes.finalizeReservation ( );
					smallPartyRooms.get ( roomNumber - 1 ).getReservations ( ).add ( nextRes );
					return nextRes;
				}
			}
			
		} else if ( roomType.contains ( "Billiards" ) ) {
			waitlist = room.getWaitlist ( );
			
			for ( int i = 0; i < waitlist.size ( ); i++ ) {
				nextRes = waitlist.get ( i );
				if ( room.isAvailable ( nextRes ) ) {
					billiardsLounges.get ( roomNumber - 1 ).getWaitlist ( ).remove ( i );
					nextRes.finalizeReservation ( );
					billiardsLounges.get ( roomNumber - 1 ).getReservations ( ).add ( nextRes );
					return nextRes;
				}
			}
			
		} else {
			waitlist = room.getWaitlist ( );
			
			for ( int i = 0; i < waitlist.size ( ); i++ ) {
				nextRes = waitlist.get ( i );
				if ( room.isAvailable ( nextRes ) ) {
					karaokeLounges.get ( roomNumber - 1 ).getWaitlist ( ).remove ( i );
					nextRes.finalizeReservation ( );
					karaokeLounges.get ( roomNumber - 1 ).getReservations ( ).add ( nextRes );
					return nextRes;
				}
			}
		}
		
		
		return null;
	}
	
	/**
	 * gets the next available room. if none are available, returns -1
	 * @param roomType - type of room
	 * @param r - reservation
	 * @return next available room
	 */
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
	
	/**
	 * get the next room with the smallest waitlist
	 * @param roomType - type of room
	 * @return room wit the smallest waitlist
	 */
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
	
	/**
	 * gets the room of the given type and roomNumber
	 * @param roomType
	 * @param roomNumber
	 * @return
	 */
	public Room getRoom ( String roomType, int roomNumber ) {
		if ( roomType.contains ( "Aqua" ) ) {
			return aquaWorlds.get ( roomNumber );
		} else if ( roomType.contains ( "Medium" ) ) {
			return mediumPartyRooms.get ( roomNumber );
		} else if ( roomType.contains ( "Small" ) ) {
			return smallPartyRooms.get ( roomNumber );
		} else if ( roomType.contains ( "Billiards" ) ) {
			return billiardsLounges.get ( roomNumber );
		} else {
			return karaokeLounges.get ( roomNumber );
		}
	}
	
	/**
	 * gets the index of the room
	 * @param roomType - tpye of room
	 * @param room - room
	 * @return index
	 */
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
	 * sets the room of the given type and roomNumber
	 * @param roomType - room type
	 * @param roomNumber - room number
	 * @param room - room to be set
	 */
	public void setRoom ( String roomType, int roomNumber, Room room ) {
		if ( roomType.contains ( "Aqua" ) ) {
			aquaWorlds.set ( roomNumber, room );
		} else if ( roomType.contains ( "Medium" ) ) {
			mediumPartyRooms.set ( roomNumber, room );
		} else if ( roomType.contains ( "Small" ) ) {
			smallPartyRooms.set ( roomNumber, room );
		} else if ( roomType.contains ( "Billiards" ) ) {
			billiardsLounges.set ( roomNumber, room );
		} else {
			karaokeLounges.set ( roomNumber, room );
		}
	}
	
	/**
	 * checks in a guest by just flipping a boolean
	 * @param confNum - conf num of res
	 */
	public void checkInReservation ( String confNum ) {
		// get resrvations of a room
		ArrayList < Reservation > reservations = aquaWorlds.get ( 0 ).getReservations ( );
		
		// iterate through all the reservations to check if it amtches the confirmation number
		for ( int i = 0; i < reservations.size ( ); i++ ) {
			if ( reservations.get ( i ).getConfNum ( ).equals ( confNum ) ) { // if a match
				aquaWorlds.get ( 0 ).getReservations ( ).get ( i ).setCheckedIn ( true );
			}
		}
		
		
		// iterate through all the medioum party rooms 
		for ( int i = 0; i < mediumPartyRooms.size ( ); i++ ) {
			reservations = mediumPartyRooms.get ( i ).getReservations ( ); // get the reservations of the room
			
			// iterate through all the reservations to check if it amtches the confirmation number
			for ( int j = 0; j < reservations.size ( ); j++ ) {
				if ( reservations.get ( j ).getConfNum ( ).equals ( confNum ) ) { // if a match
					mediumPartyRooms.get ( i ).getReservations ( ).get ( j ).setCheckedIn ( true );
				}
			}
		}
		
		
		// iterate through all the small party rooms 
		for ( int i = 0; i < smallPartyRooms.size ( ); i++ ) {
			reservations = smallPartyRooms.get ( i ).getReservations ( ); // get the reservations of the room
			
			// iterate through all the reservations to check if it amtches the confirmation number
			for ( int j = 0; j < reservations.size ( ); j++ ) {
				if ( reservations.get ( j ).getConfNum ( ).equals ( confNum ) ) { // if a match
					smallPartyRooms.get ( i ).getReservations ( ).get ( j ).setCheckedIn ( true );
				}
			}
		}
		
		
		// iterate through all the billiards lounges
		for ( int i = 0; i < billiardsLounges.size ( ); i++ ) {
			reservations = billiardsLounges.get ( i ).getReservations ( ); // get the reservations of the room
			
			// iterate through all the reservations to check if it amtches the confirmation number
			for ( int j = 0; j < reservations.size ( ); j++ ) {
				if ( reservations.get ( j ).getConfNum ( ).equals ( confNum ) ) { // if a match
					billiardsLounges.get ( i ).getReservations ( ).get ( j ).setCheckedIn ( true );
				}
			}
		}
		
		
		// iterate through all the karaoke lopunges
		for ( int i = 0; i < karaokeLounges.size ( ); i++ ) {
			reservations = karaokeLounges.get ( i ).getReservations ( ); // get the reservations of the room
			
			// iterate through all the reservations to check if it amtches the confirmation number
			for ( int j = 0; j < reservations.size ( ); j++ ) {
				if ( reservations.get ( j ).getConfNum ( ).equals ( confNum ) ) { // if a match
					karaokeLounges.get ( i ).getReservations ( ).get ( j ).setCheckedIn ( true );
				}
			}
		}
	}
	
	/**
	 * cehcks out the given reservation. removes it from the reservations, and any invalid waitlists
	 * @param confNum - conf num of the rservaion
	 * @return the rservation that was remobed
	 */
	public Reservation checkOutReservation ( String confNum ) {
		Reservation res = null;
		
		// get resrvations of a room
		ArrayList < Reservation > reservations = aquaWorlds.get ( 0 ).getReservations ( );
		
		// iterate through all the reservations to check if it amtches the confirmation number
		for ( int i = 0; i < reservations.size ( ); i++ ) {
			if ( reservations.get ( i ).getConfNum ( ).equals ( confNum ) ) { // if a match
				res = aquaWorlds.get ( 0 ).getReservations ( ).get ( i );
				aquaWorlds.get ( 0 ).removeUnavailableWaitlists ( res );
				aquaWorlds.get ( 0 ).getReservations ( ).remove ( i );
			}
		}
		
		
		// iterate through all the medioum party rooms 
		for ( int i = 0; i < mediumPartyRooms.size ( ); i++ ) {
			reservations = mediumPartyRooms.get ( i ).getReservations ( ); // get the reservations of the room
			
			// iterate through all the reservations to check if it amtches the confirmation number
			for ( int j = 0; j < reservations.size ( ); j++ ) {
				if ( reservations.get ( j ).getConfNum ( ).equals ( confNum ) ) { // if a match
					res = mediumPartyRooms.get ( 0 ).getReservations ( ).get ( i );
					mediumPartyRooms.get ( 0 ).removeUnavailableWaitlists ( res );
					mediumPartyRooms.get ( 0 ).getReservations ( ).remove ( i );
				}
			}
		}
		
		
		// iterate through all the small party rooms 
		for ( int i = 0; i < smallPartyRooms.size ( ); i++ ) {
			reservations = smallPartyRooms.get ( i ).getReservations ( ); // get the reservations of the room
			
			// iterate through all the reservations to check if it amtches the confirmation number
			for ( int j = 0; j < reservations.size ( ); j++ ) {
				if ( reservations.get ( j ).getConfNum ( ).equals ( confNum ) ) { // if a match
					res = smallPartyRooms.get ( 0 ).getReservations ( ).get ( i );
					smallPartyRooms.get ( 0 ).removeUnavailableWaitlists ( res );
					smallPartyRooms.get ( 0 ).getReservations ( ).remove ( i );
				}
			}
		}
		
		
		// iterate through all the billiards lounges
		for ( int i = 0; i < billiardsLounges.size ( ); i++ ) {
			reservations = billiardsLounges.get ( i ).getReservations ( ); // get the reservations of the room
			
			// iterate through all the reservations to check if it amtches the confirmation number
			for ( int j = 0; j < reservations.size ( ); j++ ) {
				if ( reservations.get ( j ).getConfNum ( ).equals ( confNum ) ) { // if a match
					res = billiardsLounges.get ( 0 ).getReservations ( ).get ( i );
					billiardsLounges.get ( 0 ).removeUnavailableWaitlists ( res );
					billiardsLounges.get ( 0 ).getReservations ( ).remove ( i );
				}
			}
		}
		
		
		// iterate through all the karaoke lopunges
		for ( int i = 0; i < karaokeLounges.size ( ); i++ ) {
			reservations = karaokeLounges.get ( i ).getReservations ( ); // get the reservations of the room
			
			// iterate through all the reservations to check if it amtches the confirmation number
			for ( int j = 0; j < reservations.size ( ); j++ ) {
				if ( reservations.get ( j ).getConfNum ( ).equals ( confNum ) ) { // if a match
					res = karaokeLounges.get ( 0 ).getReservations ( ).get ( i );
					karaokeLounges.get ( 0 ).removeUnavailableWaitlists ( res );
					karaokeLounges.get ( 0 ).getReservations ( ).remove ( i );
				}
			}
		}
		
		return res;
	}
	
	/**
	 * this gets a reservation from a confirmation number
	 * @param confNum - number to get the res from
	 * @return - reservation
	 */
	public Reservation getResConfNum ( String confNum ) {
		// get resrvations of a room
		ArrayList < Reservation > reservations = aquaWorlds.get ( 0 ).getReservations ( );
		
		// iterate through all the reservations to check if it amtches the confirmation number
		for ( int i = 0; i < reservations.size ( ); i++ ) {
			if ( reservations.get ( i ).getConfNum ( ).equals ( confNum ) ) { // if a match
				return reservations.get ( i );// return the reservation
			}
		}
		
		
		// iterate through all the medioum party rooms 
		for ( int i = 0; i < mediumPartyRooms.size ( ); i++ ) {
			reservations = mediumPartyRooms.get ( i ).getReservations ( ); // get the reservations of the room
			
			// iterate through all the reservations to check if it amtches the confirmation number
			for ( int j = 0; j < reservations.size ( ); j++ ) {
				if ( reservations.get ( j ).getConfNum ( ).equals ( confNum ) ) { // if a match
					return reservations.get ( j ); // return the reservation
				}
			}
		}
		
		
		// iterate through all the small party rooms 
		for ( int i = 0; i < smallPartyRooms.size ( ); i++ ) {
			reservations = smallPartyRooms.get ( i ).getReservations ( ); // get the reservations of the room
			
			// iterate through all the reservations to check if it amtches the confirmation number
			for ( int j = 0; j < reservations.size ( ); j++ ) {
				if ( reservations.get ( j ).getConfNum ( ).equals ( confNum ) ) { // if a match
					return reservations.get ( j ); // return the reservation
				}
			}
		}
		
		
		// iterate through all the billiards lounges
		for ( int i = 0; i < billiardsLounges.size ( ); i++ ) {
			reservations = billiardsLounges.get ( i ).getReservations ( ); // get the reservations of the room
			
			// iterate through all the reservations to check if it amtches the confirmation number
			for ( int j = 0; j < reservations.size ( ); j++ ) {
				if ( reservations.get ( j ).getConfNum ( ).equals ( confNum ) ) { // if a match
					return reservations.get ( j ); // return the reservation
				}
			}
		}
		
		
		// iterate through all the karaoke lopunges
		for ( int i = 0; i < karaokeLounges.size ( ); i++ ) {
			reservations = karaokeLounges.get ( i ).getReservations ( ); // get the reservations of the room
			
			// iterate through all the reservations to check if it amtches the confirmation number
			for ( int j = 0; j < reservations.size ( ); j++ ) {
				if ( reservations.get ( j ).getConfNum ( ).equals ( confNum ) ) { // if a match
					return reservations.get ( j ); // return the reservation
				}
			}
		}
		
		return null; // return null if no reservation matches
	}
	
	/**
	 * this gets a reservation from a guest name
	 * @param confNum - name to get the res from
	 * @return - reservation
	 */
	public Reservation getResGuestName ( String name ) {
		// get resrvations of a room
		ArrayList < Reservation > waitlist = aquaWorlds.get ( 0 ).getWaitlist ( );
		
		String gName = "";
		
		// iterate through all the waitlists to check if it matches the name
		for ( int i = 0; i < waitlist.size ( ); i++ ) {
			gName = waitlist.get ( i ).getGuest ( ).getName ( );
			
			if ( gName.equals ( name ) ) { // if a match
				return waitlist.get ( i );// return the reservation
			}
		}
		
		
		// iterate through all the medioum party rooms 
		for ( int i = 0; i < mediumPartyRooms.size ( ); i++ ) {
			waitlist = mediumPartyRooms.get ( i ).getWaitlist ( ); // get the reservations of the room
			
			// iterate through all the waitlists to check if it matches the name
			for ( int j = 0; j < waitlist.size ( ); j++ ) {
				gName = waitlist.get ( j ).getGuest ( ).getName ( );
				
				if ( gName.equals ( name ) ) { // if a match
					return waitlist.get ( j );// return the reservation
				}
			}
		}
		
		
		// iterate through all the small party rooms 
		for ( int i = 0; i < smallPartyRooms.size ( ); i++ ) {
			waitlist = smallPartyRooms.get ( i ).getWaitlist ( ); // get the reservations of the room
			
			// iterate through all the waitlists to check if it matches the name
			for ( int j = 0; j < waitlist.size ( ); j++ ) {
				gName = waitlist.get ( j ).getGuest ( ).getName ( );
				
				if ( gName.equals ( name ) ) { // if a match
					return waitlist.get ( j );// return the reservation
				}
			}
		}
		
		
		// iterate through all the billiards lounges
		for ( int i = 0; i < billiardsLounges.size ( ); i++ ) {
			waitlist = billiardsLounges.get ( i ).getWaitlist ( ); // get the reservations of the room
			
			// iterate through all the waitlists to check if it matches the name
			for ( int j = 0; j < waitlist.size ( ); j++ ) {
				gName = waitlist.get ( j ).getGuest ( ).getName ( );
				
				if ( gName.equals ( name ) ) { // if a match
					return waitlist.get ( j );// return the reservation
				}
			}
		}
		
		
		// iterate through all the karaoke lopunges
		for ( int i = 0; i < karaokeLounges.size ( ); i++ ) {
			waitlist = karaokeLounges.get ( i ).getWaitlist ( ); // get the reservations of the room
			
			// iterate through all the waitlists to check if it matches the name
			for ( int j = 0; j < waitlist.size ( ); j++ ) {
				gName = waitlist.get ( j ).getGuest ( ).getName ( );
				
				if ( gName.equals ( name ) ) { // if a match
					return waitlist.get ( j );// return the reservation
				}
			}
		}
		
		return null; // return null if no reservation matches
	}
}
