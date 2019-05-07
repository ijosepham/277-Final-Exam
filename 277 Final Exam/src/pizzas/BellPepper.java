package pizzas;

public class BellPepper extends ToppingDecorator {
	/**
	 * default constructor
	 * @param pizza - pizza being decorated
	 */
	public BellPepper ( Pizza pizza ) {
		this.pizza = pizza;
		this.toppings = pizza.toppings;
		this.toppings.add ( "Bell Pepper" );
	}

	/**
	 * returns the description of the pizza
	 * @return description of the pizza
	 */
	@Override
	public String getDescription ( ) {
		return pizza.getDescription ( ) + ", Bell Pepper";
	}
}
