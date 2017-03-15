package com.coffee.solutions;

import static com.coffee.utility.CoffeeMachineUtility.getIngredientDetails;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.coffee.data.IngredientDetails;
import com.coffee.data.Menu;
import com.coffee.utility.DrinkType;

/* This class provides adding the menu ,display the available menu,
 * update the menu whenever there is an order and dispense the order 
 * or let the user know if a particular drink is  out of stock
 * 
 */
public class CoffeeMachineMenuImpl implements CoffeeMachineMenu {
	
	public Set<Menu> menuList = new HashSet<Menu>();
	
	public CoffeeMachineMenuImpl() {
		super();
	}

	public CoffeeMachineMenuImpl(Set<Menu> menuList) {
		super();
		this.menuList = menuList;
	}

	public void addMenuItem(DrinkType drinkType, String drinkName, Double drinkCost, Boolean inStock) {
		Menu menuData = new Menu(drinkType,drinkName,drinkCost,inStock);
		menuList.add(menuData);
	}

	public void displayMenu() {
		List<Menu> sortedList = new ArrayList<Menu>(menuList);
		sortedList.sort(
			      (Menu h1, Menu h2) -> h1.getDrinkName().compareTo(h2.getDrinkName()));
		System.out.println("\nMenu Details:");
		sortedList.forEach(item->System.out.println("  [" + (item.getDrinkType().ordinal()+1)+"] "+ "  "
				+ item.getDrinkName() + "  " + "$" + item.getDrinkCost() +"  " + item.getInStock()));
	}
	
	public void updateMenu(CoffeeMachineInventory inventory) {
		
		for(Menu menu : menuList ){
		boolean status = true;
		List<IngredientDetails> ingredientsList = getIngredientDetails(menu.getDrinkType());	
		 for (IngredientDetails ingredients : ingredientsList){
			 String ingredientName = ingredients.getIngredientName();
			 Integer noOfUnitsRequired = ingredients.getIngredientUnit();
			 status &= inventory.stockStatus(ingredientName,noOfUnitsRequired);
		}
		menu.setInStock(status);
		}
	}

	public void orderDrink(CoffeeMachineInventory inventory,DrinkType drinkType) {
		
		Menu selectedDrink =  menuList.stream()
		.filter(s->s.getDrinkType().equals(drinkType))
		.findAny()									
		.orElse(null);
		
		List<IngredientDetails> ingredients = getIngredientDetails(selectedDrink.getDrinkType()) ;
		
		if(selectedDrink.getInStock()){
			 System.out.println("Dispensing:" + selectedDrink.getDrinkName() );	
			 ingredients.stream()
			 .forEach(s -> inventory.updateInventory(s.getIngredientName(), s.getIngredientUnit()));
		 } else {
			 System.out.println("Out Of Stock:" + selectedDrink.getDrinkName() );
		 }
		 	updateMenu(inventory);
		}
	
	@Override
	public void restock(CoffeeMachineInventory inventory) {
		inventory.restock();
		updateMenu(inventory);
	}
}

	