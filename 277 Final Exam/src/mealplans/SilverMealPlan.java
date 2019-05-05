package mealplans;

import food.Side;

public class SilverMealPlan extends MealPlan {

	public SilverMealPlan ( ) {
		foods.add ( new Side ( "Bread-Sticks" ) );
		foods.add ( new Side ( "Salad" ) );
	}
	
	public double getCost ( ) {
		return 90.0;
	}
}
