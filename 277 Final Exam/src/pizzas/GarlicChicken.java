package pizzas;

public class GarlicChicken extends ToppingDecorator {
	public GarlicChicken ( Pizza pizza ) {
		this.pizza = pizza;
		toppings.add ( "Garlic Chicken");
	}

	@Override
	public String getDescription ( ) {
		return pizza.getDescription ( ) + ", Garlic Chicken";
	}
}
