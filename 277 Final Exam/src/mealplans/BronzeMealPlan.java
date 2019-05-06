package mealplans;

public class BronzeMealPlan extends MealPlan {
	
	/**
	 * default constructor
	 */
	public BronzeMealPlan ( ) {
		tier = "Bronze";
	}
	/**
	 * returns the cost of the bronze meal plan
	 * @return cost of the meal plan
	 */
	@Override
	public double getCost ( ) {
		return 75.0;
	}
}
