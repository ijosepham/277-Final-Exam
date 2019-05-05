package mealplans;

public abstract class Food {
	/**
	 * name of the food
	 */
	protected String name;
	
	/**
	 * amount of food
	 */
	protected int quantity;
	
	/**
	 * default constructor
	 */
	public Food ( ) {
		name = "";
		quantity = 0;
	}
	
	/**
	 * sets the name of the food
	 * @param name - name of the food
	 */
	public void setName ( String name ) {
		this.name = name;
	}
	
	/**
	 * sets the quantity of the food
	 * @param quantity - quantity of the food
	 */
	public void setQuantity ( int quantity ) {
		this.quantity = quantity;
	}
	
	/**
	 * returns the name of the food
	 * @return name of the food
	 */
	public String getName ( ) {
		return name;
	}
	
	/**
	 * returns the quantity of the food
	 * @return quantity of the food
	 */
	public int getQuantity ( ) {
		return quantity;
	}
	
	/**
	 * string representaion of the food item
	 */
	public abstract String toString ( );
}
