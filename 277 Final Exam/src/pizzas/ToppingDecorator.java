package pizzas;

public abstract class ToppingDecorator extends Pizza {
	/**
	 * pizza being decorated
	 */
	protected Pizza pizza;
	
	/**
	 * gets the description of the pizza
	 */
	public abstract String getDescription ( );
}
