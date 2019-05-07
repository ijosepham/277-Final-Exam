package pizzas;

public class Cheese extends ToppingDecorator {
	/**
	 * default constructor
	 * @param pizza - pizza being decorated
	 */
	public Cheese ( Pizza pizza ) {
		this.pizza = pizza;
		this.toppings = pizza.toppings;
		this.toppings.add ( "Cheese" );
	}

	/**
	 * returns the description of the pizza
	 * @return description of the pizza
	 */
	@Override
	public String getDescription ( ) {
		return pizza.getDescription ( ) + ", Cheese";
	}
}
