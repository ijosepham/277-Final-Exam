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
	 * payment method of the guest
	 */
	private Card paymentMethod;

	/**
	 * constructor
	 * @param name - name of guest
	 * @param address - address of guest
	 * @param phone - phone number of guest
	 * @param email - email of guest
	 * @param paymentMethod - payment method of guest
	 */
	public Guest ( String name, String address, String phone, String email, Card paymentMethod ) {
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
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
	 * returns the payment method of guest
	 * @return payment method of guest
	 */
	public Card getPaymentMethod ( ) {
		return paymentMethod;
	}
}
