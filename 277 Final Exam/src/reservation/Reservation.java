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
	
	public Reservation ( Date date, Room room ) {
		
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
	
	public void setDate ( Date date ) {
		
	}
	
	public void setRoom ( Room room ) {
		
	}
	
	public void setMealPlan ( MealPlan mealPlan ) {
		
	}
	
	public void finalizeReservation ( ) {
		
	}
}
