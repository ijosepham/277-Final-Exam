package pizzas;

public class Mushroom extends ToppingDecorator {
	public Mushroom ( Pizza pizza ) {
		this.pizza = pizza;
	}

	@Override
	public String getDescription ( ) {
		return pizza.getDescription ( ) + ", Mushroom";
	}
}
