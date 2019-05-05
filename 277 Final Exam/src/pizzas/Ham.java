package pizzas;

public class Ham extends ToppingDecorator {
	/**
	 * default constructor
	 * @param pizza - pizza being decorated
	 */
	public Ham ( Pizza pizza ) {
		this.pizza = pizza;
		toppings.add ( "Ham");
	}

	/**
	 * returns the description of the pizza
	 * @return description of the pizza
	 */
	@Override
	public String getDescription ( ) {
		return pizza.getDescription ( ) + ", Ham";
	}
}
