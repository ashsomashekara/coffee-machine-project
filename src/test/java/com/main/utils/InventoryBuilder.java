package com.main.utils;

import com.coffee.data.Inventory;

public class InventoryBuilder {
	
	 private Inventory inventory =new Inventory();

	    public Inventory build(){ return inventory;}

	    public InventoryBuilder withAll(){
	        return this
	                .withIngredientName("Coffee")
	                .withIngredientQuantity(10);
	           
	    }
	    
	    public InventoryBuilder withIngredientName(String ingredientName) {
	        inventory.setIngredientName(ingredientName);
	        return this;
	    }

	    public InventoryBuilder withIngredientQuantity(Integer ingredientQuantity) {
	    	inventory.setIngredientQuantity(ingredientQuantity);
	        return this;
	    }

	    public static InventoryBuilder inventory() {
	        return new InventoryBuilder().withAll();
	    }

}
