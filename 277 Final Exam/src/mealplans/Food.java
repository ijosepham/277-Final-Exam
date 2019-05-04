package mealplans;

public abstract class Food {
	protected String name;
	protected int quantity;
	
	public void setName ( String name ) {
		this.name = name;
	}
	
	public void setQuantity ( int quantity ) {
		this.quantity = quantity;
	}
	
	public String getName ( ) {
		return name;
	}
	
	public int getQuantity ( ) {
		return quantity;
	}
	
	public abstract String toString ( );
}
