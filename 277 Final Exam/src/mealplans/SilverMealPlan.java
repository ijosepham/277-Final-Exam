package mealplans;

public class SilverMealPlan extends MealPlan {
	/**
	 * dscription of the meal plan for th epanel
	 */
	public static String DESCRIPTION = "Included: " + "\n" +
			"      3 XL 3 Topping Gourmet Pizzas" + "\n" + 
			"      5 2L Soda Bottles" + "\n" +
			"      Salad" + "\n" + 
			"      Breadsticks" + "\n" +
			"Cost: $90";
	
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
