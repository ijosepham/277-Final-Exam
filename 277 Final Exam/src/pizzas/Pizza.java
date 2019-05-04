package pizzas;

import mealplans.*;

public abstract class Pizza extends Food {
	protected String description;
	
	public Pizza ( ) {
		name = "Pizza";
		description = "";
		quantity = 0;
	}
	
	public Pizza ( String description, int quantity ) {
		name = "Pizza";
		this.description = description;
		this.quantity = quantity;
	}
	
	public void setDescription ( String description ) {
		this.description = description;
	}
	
	public String getDescription ( ) {
		return description;
	}
	
	public String toString ( ) {
		String str = "";
		
		return str;
	}
}
