package mealplans;

public class BasicMealPlan extends MealPlan {
	/**
	 * dscription of the meal plan for th epanel
	 */
	public static String DESCRIPTION = "Included: " + "\n" +
			"      3 XL 1 Topping Gourmet Pizzas" + "\n" + 
			"      3 2L Soda Bottles" + "\n" +
			"Cost: $65";
	
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
