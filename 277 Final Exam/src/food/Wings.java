package food;

import mealplans.*;

public class Wings extends Food {
	private String flavor;
	private boolean bone;
	
	public Wings ( ) {
		name = "Wings";
		flavor = "";
		bone = true;
		quantity = 0;
	}
	
	public Wings ( String flavor, boolean bone, int quantity ) {
		name = "Wings";
		this.flavor = flavor;
		this.bone = bone;
		this.quantity = quantity;
	}
	
	public void setFlavor ( String flavor ) {
		this.flavor = flavor;
	}
	
	public void setBone ( boolean bone ) {
		this.bone = bone;
	}
	
	public String getFlavor ( ) {
		return flavor;
	}
	
	public boolean getBone ( ) {
		return bone;
	}
	
	public String toString ( ) {
		String str = name + " x " + quantity;
		str += "\n" + "    " + flavor;
		if ( bone ) {
			str += "\n" + "    Bone-In";
		} else {
			str += "\n" + "    Boneless";
		}
		return str;
	}
}
