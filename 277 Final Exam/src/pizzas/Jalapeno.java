package pizzas;

public class Jalapeno extends ToppingDecorator {
	/**
	 * default constructor
	 * @param pizza - pizza being decorated
	 */
	public Jalapeno ( Pizza pizza ) {
		this.pizza = pizza;
		this.toppings = pizza.toppings;
		this.toppings.add ( "Jalapeno" );
	}

	/**
	 * returns the description of the pizza
	 * @return description of the pizza
	 */
	@Override
	public String getDescription ( ) {
		return pizza.getDescription ( ) + ", Jalapeno";
	}
}
