package mealplans;

import food.Side;

public class PlatinumMealPlan extends MealPlan {
	/**
	 * default constructor
	 */
	public PlatinumMealPlan ( ) {
		tier = "Platinum";
		foods.add ( new Side ( "Bread-Sticks" ) );
		foods.add ( new Side ( "Salad" ) );
	}
	
	/**
	 * returns the cost of the platinum meal plan
	 * @return cost of the meal plan
	 */
	@Override
	public double getCost ( ) {
		return 150.0;
	}
}
