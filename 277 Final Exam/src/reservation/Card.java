package reservation;

public class Card {
	private String cardCompany;
	private String ccNumber;
	private String securityCode;
	private String expDate;
	
	
	
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
	
	public void setCardCompany ( String cardComapny ) {
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
}
