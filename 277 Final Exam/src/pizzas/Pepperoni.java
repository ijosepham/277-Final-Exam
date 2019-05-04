package pizzas;

public class Pepperoni extends ToppingDecorator {
	public Pepperoni ( Pizza pizza ) {
		this.pizza = pizza;
		toppings.add ( "Pepperoni");
	}

	@Override
	public String getDescription ( ) {
		return pizza.getDescription ( ) + ", Pepperoni";
	}
}
