package mealplans;

public class PlatinumMealPlan extends MealPlan {
	/**
	 * default constructor
	 */
	public PlatinumMealPlan ( ) {
		tier = "Platinum";
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
