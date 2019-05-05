package mealplans;

import food.Side;

public class SilverMealPlan extends MealPlan {
	/**
	 * default constructor
	 */
	public SilverMealPlan ( ) {
		foods.add ( new Side ( "Bread-Sticks" ) );
		foods.add ( new Side ( "Salad" ) );
	}
	
	/**
	 * returns the cost of the silver meal plan
	 * @return cost of the meal plan
	 */
	@Override
	public double getCost ( ) {
		return 90.0;
	}
}
