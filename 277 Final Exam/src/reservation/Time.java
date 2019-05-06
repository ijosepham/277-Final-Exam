package reservation;

public class Time {
	/**
	 * hour of the date
	 */
	private int hour;
	
	/**
	 * minute of the date
	 */
	private int minute;
	
	/**
	 * default constructor
	 */
	public Time ( ) {
		hour = 0;
		minute = 0;
	}
	
	/**
	 * overloaded consturctor
	 * @param hour - hour of the day
	 * @param minute - minute of the day
	 */
	public Time ( int hour, int minute ) {
		this.hour = hour;
		this.minute = minute;
	}
	
	/**
	 * sets the hour of the date
	 * @param hour - hour of the date
	 */
	public void setHour ( int hour ) {
		this.hour = hour;
	}
	
	/**
	 * sets the minute of the date
	 * @param minute - minute of the date
	 */
	public void setMinute ( int minute ) {
		this.minute = minute;
	}
	
	/**
	 * returns the hour of the date
	 * @return hour of the date
	 */
	public int getHour ( ) {
		return hour;
	}

	/**
	 * returns the minute of the date
	 * @return minute of the date
	 */
	public int getMinute ( ) {
		return minute;
	}
	
	public boolean equals ( Object o ) {
		// make sure its of type time
		if ( o instanceof Time ) {
			Time t = ( Time ) o;
			
			// then makes sure that all the attributes are the same
			if ( this.hour == t.hour ) {
				if ( this.minute == t.minute ) {
					return true;
				}
			}
		}
		return false;
	}
}
