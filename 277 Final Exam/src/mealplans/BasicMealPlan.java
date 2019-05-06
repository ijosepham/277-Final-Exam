package mealplans;

public class BasicMealPlan extends MealPlan {
	
	/**
	 * default constructor
	 */
	public BasicMealPlan ( ) {
		tier = "Basic";
	}
	
	/**
	 * returns the cost of the bronze meal plan
	 * @return cost of the meal plan
	 */
	@Override
	public double getCost ( ) {
		return 65.0;
	}
}
