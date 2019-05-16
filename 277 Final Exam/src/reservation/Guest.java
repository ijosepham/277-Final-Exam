package reservation;

public class Guest {
	/**
	 * name of the guest
	 */
	private String name;
	
	/**
	 * address of the guest
	 */
	private String address;
	
	/**
	 * phone number of the guest
	 */
	private String phone;
	
	/**
	 * email of the guest
	 */
	private String email;
	
	/**
	 * DOB of the guest
	 */
	private Date dateOfBirth;
	
	/**
	 * payment method of the guest
	 */
	private Card paymentMethod;
	
	/**
	 * default constructor
	 */
	public Guest ( ) {
		name = "";
		address = "";
		phone = "";
		email = "";
		dateOfBirth = new Date ( );
		paymentMethod = new Card ( );
		dateOfBirth = new Date ( );
	}
	
	/**
	 * constructor
	 * @param name - name of guest
	 * @param address - address of guest
	 * @param phone - phone number of guest
	 * @param email - email of guest
	 * @param dateOfBirth - DOB of guest
	 * @param paymentMethod - payment method of guest
	 */
	public Guest ( String name, String address, String phone, String email, Date dateOfBirth, Card paymentMethod ) {
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.paymentMethod = paymentMethod;
	}
	
	/**
	 * sets the name of the guest
	 * @param name - name of guest
	 */
	public void setName ( String name ) {
		this.name = name;
	}
	
	/**
	 * sets the address of guest
	 * @param address - address of guest
	 */
	public void setAddress ( String address ) {
		this.address = address;
	}
	
	/**
	 * sets the phone number of the guest
	 * @param phone - number of guest
	 */
	public void setPhone ( String phone ) {
		this.phone = phone;
	}
	
	/**
	 * sets the email of the guest
	 * @param email - email of guest
	 */
	public void setEmail ( String email ) {
		this.email = email;
	}
	
	/**
	 * sets the date of birth of the guesty
	 * @param dateOfBirth - date of birth of the guets
	 */
	public void setDateOfBirth ( Date dateOfBirth ) {
		this.dateOfBirth = dateOfBirth;
	}
	/**
	 * sets the payment method of guest
	 * @param paymentMethod - payment method of guest
	 */
	public void setPaymentMethod ( Card paymentMethod ) {
		this.paymentMethod = paymentMethod;
	}
	
	/**
	 * returns the name of the guest
	 * @return name of guest
	 */
	public String getName ( ) {
		return name;
	}
	
	/**
	 * returns the address of guest
	 * @return address of guest
	 */
	public String getAddress ( ) {
		return address;
	}
	
	/**
	 * returns the phone number of the guest
	 * @return phone number of guest
	 */
	public String getPhone ( ) {
		return phone;
	}
	
	/**
	 * returns the email of guest
	 * @return email of guest
	 */
	public String getEmail ( ) {
		return email;
	}
	
	/**
	 * returns date of birth
	 * @return DOB
	 */
	public Date getDateOfBirth ( ) {
		return dateOfBirth;
	}
	
	/**
	 * returns the payment method of guest
	 * @return payment method of guest
	 */
	public Card getPaymentMethod ( ) {
		return paymentMethod;
	}
	
	/**
	 * determnies whether or not the guest is 21yo
	 * @param today - date of today
	 * @return whether or not the guest is 21
	 */
	public boolean is21 ( Date today ) {
		if ( today.getYear ( ) - dateOfBirth.getYear ( ) > 21) {
			return true;
		}
		// if hasnt even been 21 years
		if ( today.getYear ( ) - dateOfBirth.getYear ( ) < 21 ) {
			return false;
		} else { // its been 21 years, but maybe less months, eg late birthdays
			if ( today.getMonth ( ) - dateOfBirth.getMonth ( ) < 0 ) { // may - june. june hasnt turned 21 yet
				return false;
			} else if ( today.getMonth ( ) == dateOfBirth.getMonth ( ) ) { // else if same month, check days
				if ( today.getDay ( ) - dateOfBirth.getDay ( ) < 0 ) { // 16 - 30. if you were born 30, youre not 21 yet
					return false;
				} // else if same day, then youre 21
			}
		}
		return true;
	}
	
	/**
	 * returns a string representation of the guest's info
	 * @return guest's info
	 */
	public String toString ( ) {
		String str = "Name: " + name;
		str += "\n" + "Address: " + address;
		str += "\n" + "Phone: " + phone;
		str += "\n" + "Email: " + email;
		str += "\n" + "DOB: " + dateOfBirth;
		str += "\n" + "Payment Method: " + paymentMethod.getCardCompany ( );
		return str;
	}
}
