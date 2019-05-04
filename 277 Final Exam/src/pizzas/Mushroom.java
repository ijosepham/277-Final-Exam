package pizzas;

public class Mushroom extends ToppingDecorator {
	public Mushroom ( Pizza pizza ) {
		this.pizza = pizza;
		toppings.add ( "Mushroom");
	}

	@Override
	public String getDescription ( ) {
		return pizza.getDescription ( ) + ", Mushroom";
	}
}
