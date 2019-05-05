package mealplans;

import food.Side;

public class GoldMealPlan extends MealPlan {
	/**
	 * returns the cost of the Gold meal plan
	 * @return cost of the meal plan
	 */
	public GoldMealPlan ( ) {
		foods.add ( new Side ( "Bread-Sticks" ) );
		foods.add ( new Side ( "Salad" ) );
	}
	
	/**
	 * returns the cost of the bronze meal plan
	 * @return cost of the meal plan
	 */
	@Override
	public double getCost ( ) {
		return 120.0;
	}
}
