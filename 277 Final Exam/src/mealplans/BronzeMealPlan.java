package mealplans;

public class BronzeMealPlan extends MealPlan {
	public static String DESCRIPTION = "Included: " + "\n" +
			"      3 XL 2 Topping Gourmet Pizzas" + "\n" + 
			"      5 2L Soda Bottles" + "\n" +
			"      Salad or Breadsticks" + "\n" +
			"Cost: $75";
	
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
