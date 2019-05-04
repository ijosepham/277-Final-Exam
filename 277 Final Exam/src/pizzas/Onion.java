package pizzas;

public class Onion extends ToppingDecorator {
	public Onion ( Pizza pizza ) {
		this.pizza = pizza;
	}

	@Override
	public String getDescription ( ) {
		return pizza.getDescription ( ) + ", Mushroom";
	}
}
