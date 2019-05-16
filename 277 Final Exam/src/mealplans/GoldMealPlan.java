package mealplans;

public class GoldMealPlan extends MealPlan {
	/**
	 * dscription of the meal plan for th epanel
	 */
	public static String DESCRIPTION = "Included: " + "\n" +
			"      3 XL 3 Topping Gourmet Pizzas" + "\n" + 
			"      5 2L Soda Bottles" + "\n" +
			"      2 Chicken Wing Flavors" + "\n" + 
			"      Salad" + "\n" + 
			"      Breadsticks" + "\n" +
			"Cost: $120";
	
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
