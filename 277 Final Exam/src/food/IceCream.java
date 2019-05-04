package food;

import mealplans.*;

public class IceCream extends Food {
	private String flavor;
	
	public IceCream ( ) {
		name = "Ice Cream";
		flavor = "";
		quantity = 0;
	}
	
	public IceCream ( String flavor, int quantity ) {
		name = "Ice Cream";
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
