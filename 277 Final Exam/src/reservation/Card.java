package reservation;

public class Card {
	/**
	 * name of the card company
	 */
	private String cardCompany;
	
	/**
	 * credit card number
	 */
	private String ccNumber;
	
	/**
	 * credit card's security code
	 */
	private String securityCode;
	
	/**
	 * credit card's expiration date
	 */
	private Date expDate;
	
	/**
	 * default constructor
	 */
	public Card ( ) {
		cardCompany = "";
		ccNumber = "";
		securityCode = "";
		expDate = new Date ( );
	}
	
	/**
	 * overloaded constructor
	 * @param cardCompany - name of the card company
	 * @param ccNumber - credit card number
	 * @param securityCode - security code of the card
	 * @param expDate - expiration date of the card
	 */
	public Card ( String cardCompany, String ccNumber, String securityCode, Date expDate ) {
		this.cardCompany = cardCompany;
		this.ccNumber = ccNumber;
		this.securityCode = securityCode;
		this.expDate = expDate;
	}
	
	/**
	 * sets the name of the card company
	 * @param cardCompany - name of the card company
	 */
	public void setCardCompany ( String cardCompany ) {
		this.cardCompany = cardCompany;
	}
	
	/**
	 * sets the credit card number 
	 * @param ccNumber - credit card number
	 */
	public void setCCNumber ( String ccNumber ) {
		this.ccNumber = ccNumber;
	}
	
	/**
	 * sets the security code of the credit card
	 * @param securityCode - security code of the credit card
	 */
	public void setSecurityCode ( String securityCode ) {
		this.securityCode = securityCode;
	}
	
	/**
	 * sets the expiration date of the credit card
	 * @param expDate - expiration date of the credit card
	 */
	public void setExpDate ( Date expDate ) {
		this.expDate = expDate;
	}
	
	/**
	 * returns the name of the credit card company
	 * @return name of the credit card company
	 */
	public String getCardCompany ( ) {
		return cardCompany;
	}
	
	/**
	 * returns the credit card number
	 * @return credit card number
	 */
	public String getCCNumber ( ) {
		return ccNumber;
	}
	
	/**
	 * returns the security code of the credit card
	 * @return security code of the credit card
	 */
	public String getSecurityCode ( ) {
		return securityCode;
	}
	
	/** 
	 * returns the expiration date of the credit card
	 * @return expiration date of the credit card
	 */
	public Date getExpDate( ) {
		return expDate;
	}
	
	public boolean isExpired ( Date date ) {
		if ( expDate.getYear ( ) == date.getYear ( ) ) {
			if ( expDate.getMonth ( ) < date.getMonth ( ) ) {
				return true;
			}
		}
		else if ( expDate.getYear ( ) < date.getYear ( ) ) {
			return true;
		}
		return false;
	}
	
	public String toString ( ) {
		String str = "Card Company: " + cardCompany;
		str += "\n" + "Card Number: " + ccNumber;
		str += "\n" + "CVC: " + securityCode;
		str += "\n" + "ExpDate: " + expDate;
		return str;
	}
}
