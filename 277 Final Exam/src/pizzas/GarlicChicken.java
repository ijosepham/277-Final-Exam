package pizzas;

public class GarlicChicken extends ToppingDecorator {
	/**
	 * default constructor
	 * @param pizza - pizza being decorated
	 */
	public GarlicChicken ( Pizza pizza ) {
		this.pizza = pizza;
		toppings.add ( "Garlic Chicken");
	}

	/**
	 * returns the description of the pizza
	 * @return description of the pizza
	 */
	@Override
	public String getDescription ( ) {
		return pizza.getDescription ( ) + ", Garlic Chicken";
	}
}
