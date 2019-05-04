package pizzas;

public class Ham extends ToppingDecorator {
	public Ham ( Pizza pizza ) {
		this.pizza = pizza;
		toppings.add ( "Ham");
	}

	@Override
	public String getDescription ( ) {
		return pizza.getDescription ( ) + ", Ham";
	}
}
