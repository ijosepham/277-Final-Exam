package mealplans;

public abstract class Food {
	/**
	 * name of the food
	 */
	protected String name;
	
	/**
	 * default constructor
	 */
	public Food ( ) {
		name = "";
	}
	
	/**
	 * sets the name of the food
	 * @param name - name of the food
	 */
	public void setName ( String name ) {
		this.name = name;
	}
	
	/**
	 * returns the name of the food
	 * @return name of the food
	 */
	public String getName ( ) {
		return name;
	}
	
	/**
	 * string representaion of the food item
	 */
	public abstract String toString ( );
}
