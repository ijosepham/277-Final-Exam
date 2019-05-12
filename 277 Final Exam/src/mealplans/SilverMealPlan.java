package mealplans;

public class SilverMealPlan extends MealPlan {
	/**
	 * default constructor
	 */
	public SilverMealPlan ( ) {
		tier = "Silver";
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
