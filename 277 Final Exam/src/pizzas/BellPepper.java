package pizzas;

public class BellPepper extends ToppingDecorator {
	public BellPepper ( Pizza pizza ) {
		this.pizza = pizza;
	}

	@Override
	public String getDescription ( ) {
		return pizza.getDescription ( ) + ", Bell Pepper";
	}
}
