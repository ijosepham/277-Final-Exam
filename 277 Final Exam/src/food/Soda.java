package food;

import mealplans.*;

public class Soda extends Food {
	private String flavor;
	
	public Soda ( ) {
		name = "Soda";
		flavor = "";
		quantity = 0;
	}
	
	public Soda ( String flavor, int quantity ) {
		name = "Soda";
		this.flavor = flavor;
		this.quantity = quantity;
	}
	
	public void setFlavor ( String flavor ) {
		this.flavor = flavor;
	}
	
	public String getFlavor ( ) {
		return flavor;
	}
	
	public String toString ( ) {
		String str = name + " x " + quantity;
		str += "\n" + "    " + flavor;
		return str;
	}
}
