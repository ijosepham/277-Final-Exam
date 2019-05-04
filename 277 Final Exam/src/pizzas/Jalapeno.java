package pizzas;

public class Jalapeno extends ToppingDecorator {
	public Jalapeno ( Pizza pizza ) {
		this.pizza = pizza;
		toppings.add ( "Jalapeno");
	}

	@Override
	public String getDescription ( ) {
		return pizza.getDescription ( ) + ", Jalapeno";
	}
}
