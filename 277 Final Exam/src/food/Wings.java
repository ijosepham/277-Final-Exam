package food;

import mealplans.*;

public class Wings extends Food {
	/**
	 * flavor of the wings
	 */
	private String flavor;
	
	/**
	 * whether or not the wings are bone-in
	 */
	private boolean bone;
	
	/**
	 * default constructor
	 */
	public Wings ( ) {
		name = "Wings";
		flavor = "";
		bone = true;
	}
	
	/**
	 * overloaded consturctor
	 * @param flavor - flavor of the wings
	 * @param bone - if the wings are bone-in
	 * @param quantity - quantity of the wings
	 */
	public Wings ( String flavor, boolean bone ) {
		name = "Wings";
		this.flavor = flavor;
		this.bone = bone;
	}
	
	/**
	 * sets the flavor of the wings
	 * @param flavor - flavor of the wings
	 */
	public void setFlavor ( String flavor ) {
		this.flavor = flavor;
	}
	
	/**
	 * sets if the wings are bone-in
	 * @param bone - if the wings are bone-in
	 */
	public void setBone ( boolean bone ) {
		this.bone = bone;
	}
	
	/**
	 * returns the flavor of the wings
	 * @return flavor of the wings
	 */
	public String getFlavor ( ) {
		return flavor;
	}
	
	/**
	 * returns whether or not the wings are bone in
	 * @return if the wings are bone-in
	 */
	public boolean getBone ( ) {
		return bone;
	}
	
	/**
	 * returns the string represenation of the wings
	 * @return flavor, quantity, and bone attirbute of the wing
	 */
	@Override
	public String toString ( ) {
		String str = name;
		str += "\n" + "    " + flavor;
		if ( bone ) {
			str += "\n" + "    Bone-In";
		} else {
			str += "\n" + "    Boneless";
		}
		return str;
	}
}
