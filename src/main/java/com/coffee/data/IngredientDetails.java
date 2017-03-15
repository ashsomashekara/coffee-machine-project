package com.coffee.data;

/* Object which holds ingredient details */

public class IngredientDetails {
	
	private String ingredientName;
	private Integer ingredientUnit;
	
	public IngredientDetails() {
		super();
	}
	
	public IngredientDetails(String ingredientName, Integer i) {
		super();
		this.ingredientName = ingredientName;
		this.ingredientUnit = i;
	}
	
	public String getIngredientName() {
		return ingredientName;
	}
	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}
	public Integer getIngredientUnit() {
		return ingredientUnit;
	}
	public void setIngredientUnit(Integer ingredientUnit) {
		this.ingredientUnit = ingredientUnit;
	}

	@Override
	public String toString() {
		return "IngredientDetails [ingredientName=" + ingredientName + ", ingredientUnit=" + ingredientUnit + "]";
	}
}
