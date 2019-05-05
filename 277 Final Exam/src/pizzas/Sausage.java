package pizzas;

public class Sausage extends ToppingDecorator {
	/**
	 * default constructor
	 * @param pizza - pizza being decorated
	 */
	public Sausage ( Pizza pizza ) {
		this.pizza = pizza;
		toppings.add ( "Sausage");
	}

	/**
	 * returns the description of the pizza
	 * @return description of the pizza
	 */
	@Override
	public String getDescription ( ) {
		return pizza.getDescription ( ) + ", Sausage";
	}
}
