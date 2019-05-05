package pizzas;

public class Onion extends ToppingDecorator {
	/**
	 * default constructor
	 * @param pizza - pizza being decorated
	 */
	public Onion ( Pizza pizza ) {
		this.pizza = pizza;
		toppings.add ( "Onion");
	}

	/**
	 * returns the description of the pizza
	 * @return description of the pizza
	 */
	@Override
	public String getDescription ( ) {
		return pizza.getDescription ( ) + ", Mushroom";
	}
}
