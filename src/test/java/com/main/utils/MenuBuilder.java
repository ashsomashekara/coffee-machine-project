package com.main.utils;

import com.coffee.data.Menu;
import com.coffee.utility.DrinkType;

public class MenuBuilder {
	
	public Menu menu = new Menu();
	
	public Menu build(){ return menu;}

    public MenuBuilder withAll(){
        return this
                .withDrinkType(DrinkType.DECAF)
                .withDrinkName("Caffe Latte")
                .withDrinkCost(4.25)
                .withInStock(true); 
    }

    public MenuBuilder withDrinkType(DrinkType drinkType) {
        menu.setDrinkType(drinkType);
        return this;
    }

    public MenuBuilder withDrinkName(String drinkName) {
    	menu.setDrinkName(drinkName);
        return this;
    }
    
    public MenuBuilder withDrinkCost(Double drinkCost) {
        menu.setDrinkCost(drinkCost);
        return this;
    }

    public MenuBuilder withInStock(Boolean inStock) {
    	menu.setInStock(inStock);
        return this;
    }

    public static MenuBuilder menu() {
        return new MenuBuilder().withAll();
    }
}


