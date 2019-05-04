package food;

import mealplans.*;

public class Side extends Food {
	
	public Side ( ) {
		name = "";
		quantity = 0;
	}
	
	public Side ( String name ) {
		this.name = name;
		quantity = 1;
	}
	
	public String toString ( ) {
		return name;
	}
}
