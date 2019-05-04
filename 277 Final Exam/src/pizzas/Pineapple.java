package pizzas;

public class Pineapple extends ToppingDecorator {
	public Pineapple ( Pizza pizza ) {
		this.pizza = pizza;
		toppings.add ( "Pineapple");
	}

	@Override
	public String getDescription ( ) {
		return pizza.getDescription ( ) + ", Pineapple";
	}
}
