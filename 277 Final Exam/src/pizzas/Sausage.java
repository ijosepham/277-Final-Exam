package pizzas;

public class Sausage extends ToppingDecorator {
	public Sausage ( Pizza pizza ) {
		this.pizza = pizza;
		toppings.add ( "Sausage");
	}

	@Override
	public String getDescription ( ) {
		return pizza.getDescription ( ) + ", Sausage";
	}
}
