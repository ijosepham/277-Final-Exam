package mealplans;

import java.util.ArrayList;

public abstract class MealPlan {
	/**
	 * name of the meal plan
	 */
	protected String tier;
	
	/**
	 * list of foods that are included in the meal plan
	 */
	protected ArrayList < Food > foods;
	
	/**
	 * default constructor
	 */
	public MealPlan ( ) {
		tier = "No";
		foods = new ArrayList < Food > ( );
	}
	
	/**
	 * set tier of the meal plan
	 * @param tier - tier of the meal plan
	 */
	public void setTier ( String tier ) {
		this.tier = tier;
	}
	
	/**
	 * sets the foods of this meal plan
	 * @param foods - foods of the meal plan
	 */
	public void setFoods ( ArrayList < Food > foods ) {
		this.foods = foods;
	}
	
	/**
	 * gets the tier of the meal plan
	 * @return tier of the meal plan
	 */
	public String getTier ( ) {
		return tier;
	}
	
	/**
	 * returns the foods of the meal plan
	 * @return foods of the meal plan
	 */
	public ArrayList < Food > getFoods ( ) {
		return foods;
	}
	
	/**
	 * adds the food to the array list of foods
	 * @param food - food to be added
	 */
	public void addFood ( Food food ) {
		foods.add ( food );
	}
	
	/**
	 * string representaion of the meal plan
	 * @return string rep of the meal paln
	 */
	public String toString ( ) {
		String str = "  ";
		Food food;
		
		for ( int i = 0; i < foods.size ( ); i++ ) {
			food = foods.get ( i );
			str += food + "\n" + "  ";
		}
		
		return str;
	}
	
	/**
	 * returns the cost of the meal plan
	 * @return cost of the meal plan
	 */
	public abstract double getCost ( );
}