package pizzas;

import java.util.ArrayList;

import mealplans.*;

public class Pizza extends Food {
	protected ArrayList < String > toppings;
	protected String description;
	
	public Pizza ( ) {
		name = "Pizza";
		toppings = new ArrayList < String > ( );
		description = "Pizza";
	}
	
	public Pizza ( String description, int quantity, ArrayList < String > toppings ) {
		name = "Pizza";
		this.toppings = toppings;
		this.description = description;
	}
	
	public void setDescription ( String description ) {
		this.description = description;
	}
	
	public void setToppings ( ArrayList < String > toppings ) {
		this.toppings = toppings;
	}
	
	public String getDescription ( ) {
		return description;
	}
	
	public ArrayList < String > getToppings ( ) {
		return toppings;
	}
	
	public String toString ( ) {
		String str = name;
		for ( int i = 0; i < toppings.size ( ); i++ ) {
			str += "\n" + "    " + toppings.get ( i );
		}		
		return str;
	}
}
