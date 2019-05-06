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
	 * confirmation number of the reserveation
	 */
	private String confNum;
	
	/**
	 * constructor
	 * @param date - date of the reservation
	 * @param room - room of the reservation
	 * @param mealPlan - mealplan of the reservation
	 */
	public Reservation ( Date date, Time startTime, Time endTime, Room room, MealPlan mealPlan ) {
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.room = room;
		this.mealPlan = mealPlan;
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
	 * finalizes reservation, makes sure date is open, and all information is collected
	 * also makes sure that down payment is paid beforehand
	 */
	public void finalizeReservation ( ) {
		
	}
}
