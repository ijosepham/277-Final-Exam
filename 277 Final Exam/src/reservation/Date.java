package reservation;

public class Date {
	private int month;
	private int day;
	private int year;
	private int hour;
	private int minute;
	
	public Date ( ) {
		month = 1;
		day = 1;
		year = 2019;
		hour = 0;
		minute = 0;
	}
	
	public Date ( int month, int day, int year, int hour, int minute ) {
		this.month = month;
		this.day = day;
		this.year = year;
		this.hour = hour;
		this.minute = minute;
	}
	
	public int getMonth ( ) {
		return month;
	}
	
	public int getDay ( ) {
		return day;
	}
	
	public int getYear ( ) {
		return year;
	}

	public int getHour ( ) {
		return hour;
	}

	public int getMinute ( ) {
		return minute;
	}

	public void setMonth ( int month ) {
		this.month = month;
	}

	public void setDay ( int day ) {
		this.day = day;
	}

	public void setYear ( int year ) {
	this.year = year;
	}
	
	public void setHour ( int hour ) {
		this.hour = hour;
	}
	
	public void setMinute ( int minute ) {
		this.minute = minute;
	}
	
	public String toString ( ) {
		return new String ( );
	}
	
	public boolean equals ( Object o ) {
		return true;
	}
}
