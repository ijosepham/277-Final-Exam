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
	
//	/** im stupid
//	 * compares two times to each other. if implicit is earlier, returns a negative number
//	 * if implicit is later/explicit is earlier, returns a positive number
//	 * @param time - second time to compare to
//	 * @return which one is earlier, - if imp is earlier
//	 */
//	public int compareTo ( Time time ) {
//		int difference;
//		
//		// if theyre the same hour, compare only minutes
//		if ( this.hour == time.hour ) {
//			return this.minute - time.minute;
//		} else if ( this.hour > time.hour ) { // if this > that
//			// will be 4 digits, first two are hour difference
//			difference = ( this.hour - time.hour ) * 100; // HHMM
//			
//			// if that's minutes are greater than this
//			if ( time.minute > this.minute ) {
//				difference -= 100; // carry over to minutes' place
//				difference += 60; // use the extra carry
//			} 
//			
//			// do the difference
//			difference += this.minute - time.minute;
//			
//			return difference;
//		} else { // do difference but will be negative
//			difference = ( time.hour - this.hour ) * 100;
//			
//			if ( this.minute > time.minute ) {
//				difference -= 100;
//				difference += 60; 
//			}
//			
//			difference += this.minute - time.minute;
//			
//			return -difference;
//		}
//	}
	
	/**
	 * returns the number of minutes of difference between the two times
	 * will be negative if the first time is earlier
	 * @param time - second time to compare to
	 * @return which one is earlier, - if imp is earlier
	 */
	public int compareTo ( Time time ) {
		int difference;
		
		difference = ( this.hour * 60 ) - ( time.hour * 60 );
		difference += this.minute - time.minute;
		
		return difference;
	}
	
	/**
	 * checks if both times are the same
	 * @return if both times are the same
	 */
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
	
	/**
	 * string representation of time
	 * @return time
	 */
	public String toString ( ) {
		String str = "";
		
		if ( hour == 0 ) {
			str = "00:";
		} else if ( hour < 10 ) {
			str = "0" + hour + ":";
		} else {
			str = hour + ":";
		}
		
		if ( minute == 0 ) {
			str += "00";
		} else if ( minute < 10 ) {
			str += "0" + minute;
		} else {
			str += minute + "";
		}
		
		return str;
	}
}
