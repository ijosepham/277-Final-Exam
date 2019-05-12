package mealplans;

public class GoldMealPlan extends MealPlan {
	
	/**
	 * default constructor
	 */
	public GoldMealPlan ( ) {
		tier = "Gold";
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
