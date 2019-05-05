package pizzas;

public class Pineapple extends ToppingDecorator {
	/**
	 * default constructor
	 * @param pizza - pizza being decorated
	 */
	public Pineapple ( Pizza pizza ) {
		this.pizza = pizza;
		toppings.add ( "Pineapple");
	}

	/**
	 * returns the description of the pizza
	 * @return description of the pizza
	 */
	@Override
	public String getDescription ( ) {
		return pizza.getDescription ( ) + ", Pineapple";
	}
}
