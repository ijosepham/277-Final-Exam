package pizzas;

public class Mushroom extends ToppingDecorator {
	/**
	 * default constructor
	 * @param pizza - pizza being decorated
	 */
	public Mushroom ( Pizza pizza ) {
		this.pizza = pizza;
		this.toppings = pizza.toppings;
		this.toppings.add ( "Mushroom" );
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
