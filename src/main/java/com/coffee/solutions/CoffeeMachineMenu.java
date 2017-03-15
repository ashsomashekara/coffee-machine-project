package com.coffee.solutions;

import com.coffee.utility.DrinkType;

public interface CoffeeMachineMenu {
	
	public void addMenuItem(DrinkType drinkType,String drinkName,Double drinkCost,Boolean inStock);
    public void updateMenu(CoffeeMachineInventory inventory) ;
    public void displayMenu();
    public void orderDrink(CoffeeMachineInventory inventory,DrinkType drinkType);
    public void restock(CoffeeMachineInventory inventory);
  }
