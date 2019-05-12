package food;

import mealplans.*;

public class Soda extends Food {
	/**
	 * flavor of the soda
	 */
	private String flavor;
	
	/**
	 * default constructor
	 */
	public Soda ( ) {
		name = "Soda";
		flavor = "";
	}
	
	/**
	 * overloaded constructor 
	 * @param flavor - flavor of the soda
	 * @param quantity - quantity of the soda
	 */
	public Soda ( String flavor ) {
		name = "Soda";
		this.flavor = flavor;
	}
	
	/**
	 * sets the flavor of the soda
	 * @param flavor - flavor of the soda
	 */
	public void setFlavor ( String flavor ) {
		this.flavor = flavor;
	}
	
	/**
	 * returns the flavor of the soda
	 * @return flavor of the soda
	 */
	public String getFlavor ( ) {
		return flavor;
	}
	
	/**
	 * returns string represenation of the soda
	 * @return name, flavor, and quantity of the soda
	 */
	@Override
	public String toString ( ) {
		String str = name;
		str += "\n" + "    " + flavor;
		return str;
	}
}
