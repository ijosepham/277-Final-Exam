package reservation;

import rooms.*;
import mealplans.*;

import java.util.ArrayList;

public class Reservation {
	/**
	 * date of the reservation
	 */
	private Date date;
	
	/**
	 * start time of the reservation
	 */
	private Time startTime;
	
	/**
	 * end time of the reservation
	 */
	private Time endTime;
	
	/**
	 * room the reservation is requesting
	 */
	private Room room;
	
	/**
	 * party size
	 */
	private int partySize;
	
	/**
	 * special amenities
	 */
	private ArrayList < String > specialAmenities;
	
	/**
	 * meal plan of the room
	 */
	private MealPlan mealPlan;
	
	/**
	 * guest rqeuesting the reservation
	 */
	private Guest guest;
	
	/**
	 * contact by
	 */
	private ArrayList < Boolean > contactBy;
	
	/**
	 * whether or not the reservation was made
	 */
	private boolean isFinalized;
	
	/**
	 * down payment to initially pay for reservation
	 */
	private double initialPayment;
	
	/**
	 * cost of the reservation
	 */
	private double cost;
	
	/**
	 * confirmation number of the reservation
	 */
	private String confNum;
	
	/**
	 * whether or not they guest was checked in
	 */
	private boolean checkedIn;
	
	/**
	 * default constructor
	 */
	public Reservation ( ) {
		guest = new Guest ( );
		date = new Date ( );
		startTime = new Time ( );
		endTime = new Time ( );
		room = null;
		specialAmenities = new ArrayList < String > ( );
		contactBy = new ArrayList < Boolean > ( );
		mealPlan = null;
		initialPayment = 0;
		isFinalized = false;
		partySize = 0;
		cost = 0;
		checkedIn = false;
	}
	
	/**
	 * constructor
	 * @param date - date of the reservation
	 * @param room - room of the reservation
	 * @param mealPlan - mealplan of the reservation
	 */
	public Reservation ( Guest guest, Date date, Time startTime, Time endTime, Room room, ArrayList < String > specialAmenities, int partySize, MealPlan mealPlan, ArrayList < Boolean > contactBy ) {
		this.guest = guest;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.room = room;
		this.specialAmenities = specialAmenities;
		this.partySize = partySize;
		this.mealPlan = mealPlan;
		this.contactBy = contactBy;
		isFinalized = false;
		initialPayment = 0;
		cost = 0;
		checkedIn = false;
	}
	
	/**
	 * sets the date of the reservation
	 * @param date - date of reservation
	 */
	public void setDate ( Date date ) {
		this.date = date;
	}
	
	/**
	 * sets the start time of the reservation
	 * @param startTime - start time of the reservation
	 */
	public void setStartTime ( Time startTime ) {
		this.startTime = startTime;
	}
	
	/**
	 * sets the end time of the reservation
	 * @param endTime - end time of the reservation
	 */
	public void setEndTime ( Time endTime ) {
		this.endTime = endTime;
	}
	
	/**
	 * sets the room of the reservation
	 * @param room - room of reservation
	 */
	public void setRoom ( Room room ) {
		this.room = room;
	}
	
	/**
	 * sets the party size of the res
	 * @param partySize - party size
	 */
	public void setPartySize ( int partySize ) {
		this.partySize = partySize;
	}
	
	/**
	 * sets the meal plan of the reservation
	 * @param mealPlan - mealplan of the reservation
	 */
	public void setMealPlan ( MealPlan mealPlan ) {
		this.mealPlan = mealPlan;
	}
	
	/**
	 * sets whether or not the guest is checked in
	 * @param whether or nto they guest is checked in
	 */
	public void setCheckedIn ( boolean checkedIn ) {
		this.checkedIn = checkedIn;
	}
	
	/**
	 * sets the guest of the reservation
	 * @param guest
	 */
	public void setGuest ( Guest guest ) {
		this.guest = guest;
	}
	
	/**
	 * gets the date of the reservation
	 * @return date of the reservation
	 */
	public Date getDate ( ) {
		return date;
	}
	
	/**
	 * gets the start time of the reservation
	 * @return start time of the reservation
	 */
	public Time getStartTime ( ) {
		return startTime;
	}
	
	/**
	 * gets the end time of the reservation
	 * @return end time of the reservation
	 */
	public Time getEndTime ( ) {
		return endTime;
	}
	
	/**
	 * gets the room of the reservation
	 * @return room of the reservation
	 */
	public Room getRoom ( ) {
		return room;
	}
	
	/**
	 * gets the size of the party
	 * @return size of teh party
	 */
	public int getPartySize ( ) {
		return partySize;
	}
	
	/**
	 * gets the mealplan of the reservation
	 * @return mealplan of the reservation
	 */
	public MealPlan getMealPlan ( ) {
		return mealPlan;
	}
	
	/**
	 * gets the guest of the reservation
	 * @return guest of the reservation
	 */
	public Guest getGuest ( ) {
		return guest;
	}
	
	/**
	 * gets the speciala menities
	 * @return special amenities
	 */
	public ArrayList < String > getSpecialAmenities ( ) {
		return specialAmenities;
	}
	
	/**
	 * returns the means of contact
	 * @return means of contact
	 */
	public ArrayList < Boolean > getContactBy ( ) {
		return contactBy;
	}
	
	/**
	 * return whether or not the user was checked in
	 * @reutrn whether or not the user was checked in
	 */
	public boolean getCheckedIn ( ) {
		return checkedIn;
	}
	
	/**
	 * gets the initial payment amount needed
	 * @return initial payment
	 */
	public double getInitialPayment ( ) {
		calculateCost ( );
		return initialPayment;
	}
	
	/**
	 * gets the cost of the res
	 * @return cost
	 */
	public double getCost ( ) {
		calculateCost ( );
		return cost;
	}
	
	/**
	 * returns whether or not the reservationw as finalized
	 * @return if the reservation was finalized
	 */
	public boolean isFinalied ( ) {
		return isFinalized;
	}
	
	/**
	 * upgrades the meal plan to the given one
	 * @param mealPlan - desired meal paln
	 */
	public void upgradeMealPlan ( MealPlan mealPlan ) {
		this.mealPlan = mealPlan;
	}
	
	/** 
	 * finalizes reservation, makes sure date is open, and all information is collected
	 * also makes sure that down payment is paid beforehand
	 */
	public void finalizeReservation ( ) {
		initialPayment = 0;
		confNum = ( ( int ) ( Math.random ( ) * 1000000000 ) ) + "";
		isFinalized = true;
		room.setIsAvailable ( false );
	}
	
	/**
	 * return the confirmation number 
	 * @return confirmation number
	 */
	public String getConfNum ( ) {
		return confNum;
	}
	
	/**
	 * string representation of the reservation
	 * @return the reservation
	 */
	public String toString ( ) {
		calculateCost ( );
		
		String str = "Name: " + guest.getName ( );
		str += "\n" + "Room: " + room.getName ( ) + ", Room #" + room.getRoomNumber ( );
		str += "\n" + "Party Size: " + partySize;
		str += "\n" + "Date: " + date;
		str += "\n" + "Start Time: " + startTime;
		str += "\n" + "End Time: " + endTime;
		if ( mealPlan != null ) {
			str += "\n" + "Meal Plan: " + mealPlan.getTier ( ) + " Tier";
		} else {
			str += "\n" + "Meal Plan: None";
		}
		
		str += "\n" + "Initial Payment: $" + String.format ( "%.2f", initialPayment );
		str += "\n" + "Total Cost: $" + String.format ( "%.2f", cost );
		
		if ( isFinalized ) {
			str += "\n" + "\n" + "Confirmation Number: " + confNum;
		}
		
		return str;
	}
	
	/**
	 * calculates the cost of the rservation
	 * @return cost
	 */
	public double calculateCost ( ) {
		cost = 0;
		
		// time stayed
		double time =  ( ( double ) endTime.compareTo ( startTime ) ) / 60.0; // 12pm - 9am = 180 min. 180 / 60 = 3 hours
		cost += room.getCost ( ) * time; // room cost per hour * time
		// go through all the amenities
		for ( int i = 0; i < specialAmenities.size ( ); i++ ) {
			if ( specialAmenities.get ( i ).contains ( "Meal" ) ) {
				double quantity = Math.ceil ( partySize / 15.0 );
				
				String roomType = room.getName ( );
				if ( roomType.contains ( "Lounge" ) ) { // lounges take the full price of the meal plan
					cost += mealPlan.getCost ( ) * quantity;
				} else {
					if ( roomType.contains ( "Aqua" ) ) { // party worlds dont
						cost += quantity * 5 * ( mealPlan.getCost ( ) - 65.0 );
						
					} else if ( roomType.contains ( "Medium" ) ) {
						cost += quantity * 3 * ( mealPlan.getCost ( ) - 65.0 );
						
					} else if ( roomType.contains ( "Small" ) ) {
						cost += quantity * 1 * ( mealPlan.getCost ( ) - 65.0 );
					} 
				}
				
				
			} else if ( specialAmenities.get ( i ).contains ( "Towel" ) ) {
				cost += ( ( double ) partySize ) * 2.0;
				
			} else if ( specialAmenities.get ( i ).contains ( "Bag" ) ) {
				cost += ( ( double ) partySize ) * 5.0;
				
			} else if ( specialAmenities.get ( i ).contains ( "Projector" ) ) {
				cost += 10.0 * time;
				
			} else if ( specialAmenities.get ( i ).contains ( "Decoration" ) ) {
				cost += 100.0;
			}
		}
		
		initialPayment = cost * .25;
		
		
		// round costs to nearest hundred
		cost = Math.round ( cost * 100.0 ) / 100.0;
		
		initialPayment = Math.round ( initialPayment * 100.0 ) / 100.0;
				
		return cost;
	}
	
	/**
	 * returns an invoice of all the costs of the reservation
	 * @return invoice of the res
	 */
	public String getInvoice ( ) {
		String str = "";
		
		double roomCost = 0;
		double mealPlanCost = 0;
		double specAmCost = 0;
		
		double cost = 0;
		
		// time stayed
		double time = endTime.compareTo ( startTime ) / 60.0; // 12pm - 9am = 180 min. 180 / 60 = 3 hours
		roomCost = room.getCost ( ) * time; // room cost per hour * time
		
		// go through all the amenities
		for ( int i = 0; i < specialAmenities.size ( ); i++ ) {
			if ( specialAmenities.get ( i ).contains ( "Meal" ) ) {
				double quantity = Math.ceil ( partySize / 15 );
				
				String roomType = room.getName ( );
				if ( roomType.contains ( "Lounge" ) ) { // lounges take the full price of the meal plan
					mealPlanCost = mealPlan.getCost ( ) * quantity;
					
				} else {
					if ( roomType.contains ( "Aqua" ) ) { // party worlds dont
						mealPlanCost = quantity * 5 * ( mealPlan.getCost ( ) - 65.0 );
						
					} else if ( roomType.contains ( "Medium" ) ) {
						mealPlanCost = quantity * 3 * ( mealPlan.getCost ( ) - 65.0 );
						
					} else if ( roomType.contains ( "Small" ) ) {
						mealPlanCost = quantity * 1 * ( mealPlan.getCost ( ) - 65.0 );
					} 
				}
				
				
			} else if ( specialAmenities.get ( i ).contains ( "Towel" ) ) {
				specAmCost += partySize * 2.0;
				
			} else if ( specialAmenities.get ( i ).contains ( "Bag" ) ) {
				specAmCost += partySize * 5.0;
				
			} else if ( specialAmenities.get ( i ).contains ( "Projector" ) ) {
				specAmCost += 10.0 * time;
				
			} else if ( specialAmenities.get ( i ).contains ( "Decoration" ) ) {
				specAmCost += 100.0;
			}
		}
		
		cost = roomCost + mealPlanCost + specAmCost;
		cost = Math.round ( cost * 100.0 ) / 100.0;
		
		
		str += "      Room: $" + String.format ( "%.2f", roomCost ) + "\n";
		str += "      Meal Plan: $" + String.format ( "%.2f", mealPlanCost ) + "\n";
		str += "      Special Amenities: $" + String.format ( "%.2f", specAmCost ) + "\n";
		
		return str;
	}
}
