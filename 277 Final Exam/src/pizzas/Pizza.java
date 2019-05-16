package pizzas;

import java.util.ArrayList;

import mealplans.*;

public class Pizza extends Food {
	/**
	 * list of toppings on the pizza
	 */
	protected ArrayList < String > toppings;
	
	/**
	 * description of the pizza
	 */
	protected String description;
	
	/**
	 * default construcor
	 */
	public Pizza ( ) {
		name = "Pizza";
		toppings = new ArrayList < String > ( );
		description = "Pizza";
	}
	
	/**
	 * overloaded cosntruicotr
	 * @param description -dscriptoon of the pizza
	 * @param toppings - toppings of the piza
	 */
	public Pizza ( String description, ArrayList < String > toppings ) {
		name = "Pizza";
		this.toppings = toppings;
		this.description = description;
	}
	
	/**
	 * sets the description of the pizza
	 * @param description - dscription of the pizza
	 */
	public void setDescription ( String description ) {
		this.description = description;
	}
	
	/**
	 * sets the toppings og the pizza
	 * @param toppings - toppings of the pizza
	 */
	public void setToppings ( ArrayList < String > toppings ) {
		this.toppings = toppings;
	}
	
	/**
	 * gets the dsription of the piza
	 * @return dscriptiopn opf the [izza
	 */
	public String getDescription ( ) {
		return description;
	}
	
	/**
	 * gets the toppings of the pizza
	 * @return toppings of the pizzza
	 */
	public ArrayList < String > getToppings ( ) {
		return toppings;
	}
	
	/**
	 * string representaion of the pizza
	 * @return string representaion of the pizza
	 */
	public String toString ( ) {
		String str = name;
		for ( int i = 0; i < toppings.size ( ); i++ ) {
			str += "\n" + "    " + toppings.get ( i );
		}		
		return str;
	}
}
