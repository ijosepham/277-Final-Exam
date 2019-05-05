package reservation;

import rooms.*;
import mealplans.*;

public class Reservation {
	private Date date;
	private Room room;
	private MealPlan mealPlan;
	private Guest guest;
	private boolean isFinalized;
	private String confNum;
	
	public void setDate ( Date date ) {
		this.date = date;
	}
	
	public void setRoom ( Room room ) {
		this.room = room;
	}
	
	public void setMealPlan ( MealPlan mealPlan ) {
		this.mealPlan = mealPlan;
	}
	
	public Reservation ( Date date, Room room, MealPlan mealPlan ) {
		this.date = date;
		this.room = room;
		this.mealPlan = mealPlan;
	}
	
	public Date getDate ( ) {
		return date;
	}
	
	public Room getRoom ( ) {
		return room;
	}
	
	public MealPlan getMealPlan ( ) {
		return mealPlan;
	}
	
	public void finalizeReservation ( ) {
		
	}
}
