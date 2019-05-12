package food;

import mealplans.*;

public class Side extends Food {
	/**
	 * default constructor
	 */
	public Side ( ) {
		name = "";
	}
	
	/**
	 * overloaded consturctor
	 * @param name - name of the side
	 */
	public Side ( String name ) {
		this.name = name;
	}
	
	/**
	 * string represenation of the side
	 * @return name of the side
	 */
	@Override
	public String toString ( ) {
		return name;
	}
}
