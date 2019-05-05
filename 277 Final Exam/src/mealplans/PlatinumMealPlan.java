package mealplans;

import food.Side;

public class PlatinumMealPlan extends MealPlan {

	public PlatinumMealPlan ( ) {
		foods.add ( new Side ( "Bread-Sticks" ) );
		foods.add ( new Side ( "Salad" ) );
	}
	
	public double getCost ( ) {
		return 150.0;
	}
}
