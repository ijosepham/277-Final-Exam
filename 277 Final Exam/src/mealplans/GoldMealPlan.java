package mealplans;

import food.Side;

public class GoldMealPlan extends MealPlan {
	
	/**
	 * default constructor
	 */
	public GoldMealPlan ( ) {
		tier = "Gold";
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
