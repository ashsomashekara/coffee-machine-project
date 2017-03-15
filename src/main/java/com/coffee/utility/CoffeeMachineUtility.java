package com.coffee.utility;

import java.util.ArrayList;
import java.util.List;

import com.coffee.data.IngredientDetails;
import com.coffee.solutions.CoffeeMachineInventory;
import com.coffee.solutions.CoffeeMachineInventoryImpl;
import com.coffee.solutions.CoffeeMachineMenu;
import com.coffee.solutions.CoffeeMachineMenuImpl;

public  class CoffeeMachineUtility {
	
	
	public static CoffeeMachineInventory addInventory() {
		
	CoffeeMachineInventory addInventory = new CoffeeMachineInventoryImpl();
	addInventory.addInventory("Cocoa", 10);
	addInventory.addInventory("Coffee", 10);
	addInventory.addInventory("Decaf Coffee",10);
	addInventory.addInventory("Cream",10);
	addInventory.addInventory("Espresso",10);
	addInventory.addInventory("Foamed Milk",10);
	addInventory.addInventory("Steamed Milk",10);
	addInventory.addInventory("Sugar",10);
	addInventory.addInventory("Whipped Cream",10 );
	return addInventory;
}

public final static CoffeeMachineMenu initializeMenu() {
	
	CoffeeMachineMenu addMenu = new CoffeeMachineMenuImpl();
	addMenu.addMenuItem(DrinkType.AMERICANO,"Caffe Americano",3.30,true);
    addMenu.addMenuItem(DrinkType.LATTE,"Caffe Latte",2.55,true);
    addMenu.addMenuItem(DrinkType.MOCHA,"Caffe Mocha",3.35,true);
    addMenu.addMenuItem(DrinkType.CAPPACCINO,"Cappuccino",2.90,true);
    addMenu.addMenuItem(DrinkType.COFFEE,"Coffee",2.75,true);
    addMenu.addMenuItem(DrinkType.DECAF,"Decaf Coffee",2.75,true );
	return addMenu;
 }

public static List<IngredientDetails> getIngredientDetails(DrinkType type) {
	
	List<IngredientDetails> detailsList = new ArrayList<IngredientDetails>();
    	
	switch(type){
	case AMERICANO:
		detailsList.add(new IngredientDetails("Espresso", 3));
		break;
	case LATTE:
		detailsList.add(new IngredientDetails("Espresso", 2));
		detailsList.add(new IngredientDetails("Steamed Milk", 1));
		break;
	case MOCHA:
		detailsList.add(new IngredientDetails("Espresso", 1));
		detailsList.add(new IngredientDetails("Steamed Milk", 1));
		detailsList.add(new IngredientDetails("Cocoa", 1));
		detailsList.add(new IngredientDetails("Whipped Cream", 1));
		break;
	case CAPPACCINO:
		detailsList.add(new IngredientDetails("Espresso", 2));
		detailsList.add(new IngredientDetails("Steamed Milk", 1));
		detailsList.add(new IngredientDetails("Foamed Milk", 1));
		break;
	case COFFEE:
		detailsList.add(new IngredientDetails("Coffee",3));
		detailsList.add(new IngredientDetails("Sugar",1));
		detailsList.add(new IngredientDetails("Cream",1));
		break;
	case DECAF:
		detailsList.add(new IngredientDetails("Decaf Coffee", 3));
		detailsList.add(new IngredientDetails("Sugar", 1));
		detailsList.add(new IngredientDetails("Cream", 1));
		break;
	 }
	return detailsList;
}

}
