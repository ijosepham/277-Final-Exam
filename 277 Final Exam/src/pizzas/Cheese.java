package pizzas;

public class Cheese extends ToppingDecorator {
	public Cheese ( Pizza pizza ) {
		this.pizza = pizza;
	}

	@Override
	public String getDescription ( ) {
		return pizza.getDescription ( ) + ", Cheese";
	}
}
