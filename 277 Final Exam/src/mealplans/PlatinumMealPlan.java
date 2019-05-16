package mealplans;

public class PlatinumMealPlan extends MealPlan {
	/**
	 * dscription of the meal plan for th epanel
	 */
	public static String DESCRIPTION = "Included: " + "\n" +
			"      4 XL 4 Topping Gourmet Pizzas" + "\n" + 
			"      5 2L Soda Bottles" + "\n" +
			"      2 Chicken Wing Flavors" + "\n" + 
			"      2 Ice Cream Flavors" + "\n" + 
			"      Salad" + "\n" + 
			"      Breadsticks" + "\n" +
			"Cost: $150";
	
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
