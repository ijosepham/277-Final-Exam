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
	 * default constructor
	 */
	public Date ( ) {
		month = 1;
		day = 1;
		year = 2019;
	}
	
	/**
	 * overloaded constructor with only month and year
	 * @param month - month of the date
	 * @param day - day of the date
	 * @param year - year of the date
	 */
	public Date ( int month, int year ) {
		this.month = month;
		day = 1;
		this.year = year;
	}
	
	/**
	 * overloaded constructor
	 * @param month - month of the date
	 * @param day - day of the date
	 * @param year - year of the date
	 */
	public Date ( int month, int day, int year ) {
		this.month = month;
		this.day = day;
		this.year = year;
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
	 * string representation of the date
	 * @return date
	 */
	public String toString ( ) {
		String str = "";
		
		if ( month < 10 ) {
			str += "0" + month + "/";
		} else {
			str += month + "/";
		}
		
		if ( day < 10 ) {
			str += "0" + day + "/";
		} else {
			str += day + "/";
		}
		
		str += year;
		
		return str;
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
						return true;
					}
				}
			}
		}
		return false;
	}
}
