package mealplans;

import java.util.ArrayList;

public abstract class MealPlan {
	protected ArrayList < Food > foods;
	
	public abstract double getCost ( );
}
