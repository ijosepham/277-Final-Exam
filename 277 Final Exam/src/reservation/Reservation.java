package reservation;

import rooms.*;
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
	 * meal plan of the room
	 */
	private MealPlan mealPlan;
	
	/**
	 * guest rqeuesting the reservation
	 */
	private Guest guest;
	
	/**
	 * whether or not the reservation was made
	 */
	private boolean isFinalized;
	
	/**
	 * down payment to initially pay for reservation
	 */
	private double initialPayment;
	
	/**
	 * confirmation number of the reserveation
	 */
	private String confNum;
	
	public Reservation ( ) {
		guest = new Guest ( );
		date = new Date ( );
		startTime = new Time ( );
		endTime = new Time ( );
		room = new SmallPartyRoom ( );
		mealPlan = new BasicMealPlan ( );
		initialPayment = 0;
		isFinalized = false;
	}
	
	/**
	 * constructor
	 * @param date - date of the reservation
	 * @param room - room of the reservation
	 * @param mealPlan - mealplan of the reservation
	 */
	public Reservation ( Guest guest, Date date, Time startTime, Time endTime, Room room, MealPlan mealPlan ) {
		this.guest = guest;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.room = room;
		this.mealPlan = mealPlan;
		isFinalized = false;
		initialPayment += room.getCost ( ) + mealPlan.getCost ( );
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
		if ( room.isAvailable ( date, startTime, endTime ) ) {
			System.out.println ( "Initial payment amount: " + ( initialPayment * .25 ) );
			confNum = ( ( int ) ( Math.random ( ) * 100000000 ) ) + "";
			System.out.println ( "Your confirmation number: " + confNum );
			isFinalized = true;
		}
	}
	
	/**
	 * string representation of the reservation
	 * @return the reservation
	 */
	public String toString ( ) {
		String res = "Name: " + guest.getName ( );
		res += "\n" + "Date: " + date;
		res += "\n" + "Start Time: " + startTime;
		res += "\n" + "End Time: " + endTime;
		
		if ( isFinalized ) {
			res += "\n" + "Finalized: True";
			res += "\n" + "Confirmation Number: " + confNum;
		} else {
			res += "\n" + "Finalized: False";
		}
		
		return res;
	}
}
