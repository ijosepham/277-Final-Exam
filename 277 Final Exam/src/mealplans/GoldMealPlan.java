package mealplans;

import food.Side;

public class GoldMealPlan extends MealPlan {
	
	public GoldMealPlan ( ) {
		foods.add ( new Side ( "Bread-Sticks" ) );
		foods.add ( new Side ( "Salad" ) );
	}
	
	public double getCost ( ) {
		return 120.0;
	}
}
