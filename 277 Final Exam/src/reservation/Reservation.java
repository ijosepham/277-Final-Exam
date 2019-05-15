package reservation;

import rooms.*;

import java.util.ArrayList;

import mealplans.*;

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
	 * confirmation number of the reservation
	 */
	private String confNum;
	
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
		//initialPayment += room.getCost ( ) + mealPlan.getCost ( );
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
	 * returns the means of contact
	 * @return means of contact
	 */
	public ArrayList < Boolean > getContactBy ( ) {
		return contactBy;
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
	 * upgrades the amenities with the given amenity
	 * @param amenity - desired amenity
	 */
	public void upgradeAmenities ( String amenity ) {
		room.upgradeAmenities ( amenity );
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
		String str = "Name: " + guest.getName ( );
		str += "\n" + "Room: " + room.getName ( ) + ", Room #" + room.getRoomNumber ( );
		str += "\n" + "Party Size: " + partySize;
		str += "\n" + "Date: " + date;
		str += "\n" + "Start Time: " + startTime;
		str += "\n" + "End Time: " + endTime;
		str += "\n" + "Meal Plan: " + mealPlan.getTier ( ) + " Tier";
		str += "\n" + "Initial Payment: $" + initialPayment;
		
		if ( isFinalized ) {
			str += "\n" + "Confirmation Number: " + confNum;
		}
		
		return str;
	}
}
