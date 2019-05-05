package pizzas;

public class Pepperoni extends ToppingDecorator {
	/**
	 * default constructor
	 * @param pizza - pizza being decorated
	 */
	public Pepperoni ( Pizza pizza ) {
		this.pizza = pizza;
		toppings.add ( "Pepperoni");
	}

	/**
	 * returns the description of the pizza
	 * @return description of the pizza
	 */
	@Override
	public String getDescription ( ) {
		return pizza.getDescription ( ) + ", Pepperoni";
	}
}
