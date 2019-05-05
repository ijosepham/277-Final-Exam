package reservation;

public class Date {
	/**
	 * month of the date
	 */
	private int month;
	
	/**
	 * day of the date
	 */
	private int day;
	
	/**
	 * year of the date
	 */
	private int year;
	
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
	public Date ( ) {
		month = 1;
		day = 1;
		year = 2019;
		hour = 0;
		minute = 0;
	}
	
	/**
	 * overloaded constructor without time
	 * @param month - month of the date
	 * @param day - day of the date
	 * @param year - year of the date
	 */
	public Date ( int month, int day, int year ) {
		this.month = month;
		this.day = day;
		this.year = year;
		hour = 0;
		minute = 0;
	}
	
	/**
	 * overloaded constructor
	 * @param month - month of the date
	 * @param day - day of the date
	 * @param year - year of the date
	 * @param hour - hour of the date
	 * @param minute - minute of the date
	 */
	public Date ( int month, int day, int year, int hour, int minute ) {
		this.month = month;
		this.day = day;
		this.year = year;
		this.hour = hour;
		this.minute = minute;
	}

	/**
	 * sets the month of the date
	 * @param month - month of the date
	 */
	public void setMonth ( int month ) {
		this.month = month;
	}

	/**
	 * sets the day of the date
	 * @param day - day of the date
	 */
	public void setDay ( int day ) {
		this.day = day;
	}

	/**
	 * sets the year of the date
	 * @param year - year of the date
	 */
	public void setYear ( int year ) {
	this.year = year;
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
	 * returns the month of the date
	 * @return month of the date
	 */
	public int getMonth ( ) {
		return month;
	}
	
	/**
	 * returns the day of the date
	 * @return day of the date
	 */
	public int getDay ( ) {
		return day;
	}
	
	/**
	 * returns the year of the date
	 * @return year of the date
	 */
	public int getYear ( ) {
		return year;
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

	/** 
	 * string representation of the date
	 * @return date
	 */
	public String toString ( ) {
		return new String ( );
	}
	
	/**
	 * sees if two dates are the same
	 * @return whether or not the dates are the same
	 */
	public boolean equals ( Object o ) {
		// make sure its of type date
		if ( o instanceof Date ) {
			Date d = ( Date ) o;
			
			// then makes sure that all the attributes are the same
			if ( this.month == d.month ) {
				if ( this.day == d.day ) {
					if ( this.year == d.year ) {
						if ( this.hour == d.hour ) {
							if ( this.minute == d.minute ) {
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}
}
