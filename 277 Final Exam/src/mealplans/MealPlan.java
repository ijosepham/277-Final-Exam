package mealplans;

import java.util.ArrayList;

public abstract class MealPlan {
	/**
	 * list of foods that are included in the meal plan
	 */
	protected ArrayList < Food > foods;
	
	/**
	 * adds the food to the array list of foods
	 * @param food - food to be added
	 */
	public void addFood ( Food food ) {
		foods.add ( food );
	}
	
	/**
	 * returns the cost of the meal plan
	 * @return cost of the meal plan
	 */
	public abstract double getCost ( );
}