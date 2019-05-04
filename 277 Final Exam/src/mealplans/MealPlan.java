package mealplans;

import java.util.ArrayList;

public abstract class MealPlan {
	protected ArrayList < Food > foods;
	
	public void addFood ( Food food ) {
		foods.add ( food );
	}
	
	public abstract double getCost ( );
}