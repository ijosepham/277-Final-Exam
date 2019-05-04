package pizzas;

public class Pineapple extends ToppingDecorator {
	public Pineapple ( Pizza pizza ) {
		this.pizza = pizza;
	}

	@Override
	public String getDescription ( ) {
		return pizza.getDescription ( ) + ", Pineapple";
	}
}
