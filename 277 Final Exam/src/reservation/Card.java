package reservation;

public class Card {
	private String cardCompany;
	private String ccNumber;
	private String securityCode;
	private String expDate;
	
	public Card ( String cardCompany, String ccNumber, String securityCode, String expDate ) {
		this.cardCompany = cardCompany;
		this.ccNumber = ccNumber;
		this.securityCode = securityCode;
		this.expDate = expDate;
	}
	
	public void setCardCompany ( String cardCompany ) {
		this.cardCompany = cardCompany;
	}
	
	public void setCCNumber ( String ccNumber ) {
		this.ccNumber = ccNumber;
	}
	
	public void setSecurityCode ( String securityCode ) {
		this.securityCode = securityCode;
	}
	
	public void setExpDate ( String expDate ) {
		this.expDate = expDate;
	}
	
	public String getCardCompany ( ) {
		return cardCompany;
	}
	
	public String getCCNumber ( ) {
		return ccNumber;
	}
	
	public String getSecurityCode ( ) {
		return securityCode;
	}
	
	public String getExpDate( ) {
		return expDate;
	}
}
