package food;

import mealplans.*;

public class IceCream extends Food {
	/**
	 * flavor of the ice cream
	 */
	private String flavor;
	
	/** 
	 * default constsructor
	 */
	public IceCream ( ) {
		name = "Ice Cream";
		flavor = "";
		quantity = 0;
	}
	
	/**
	 * overloaded constructor
	 * @param flavor - flavor of the ice cream
	 * @param quantity - quantity of the ice cream
	 */
	public IceCream ( String flavor, int quantity ) {
		name = "Ice Cream";
		this.flavor = flavor;
		this.quantity = quantity;
	}
	
	/**
	 * sets the flavor of the ice cream
	 * @param flavor - flavor of the ice cream
	 */
	public void setFlavor ( String flavor ) {
		this.flavor = flavor;
	}
	
	/**
	 * returns the flavor of the ice cream
	 * @return flavor of the ice cream
	 */
	public String getFlavor ( ) {
		return flavor;
	}
	
	/**
	 * string rerpesenation of the ice cream
	 * @return ice cream name, flavor, and quantity
	 */
	@Override
	public String toString ( ) {
		String str = name + " x " + quantity;
		str += "\n" + "    " + flavor;
		return str;
	}
}
