package com.main.test;

import org.junit.Test;

import com.coffee.data.Inventory;
import com.coffee.data.Menu;
import com.coffee.solutions.CoffeeMachineInventory;
import com.coffee.solutions.CoffeeMachineInventoryImpl;
import com.coffee.solutions.CoffeeMachineMenu;
import com.coffee.solutions.CoffeeMachineMenuImpl;
import com.coffee.utility.DrinkType;

import static com.main.utils.MenuBuilder.menu;
import static com.main.utils.InventoryBuilder.inventory;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Test cases provided to test whether after the order menu is updated and test updating the inventory 
 * and restock 
 */

public class TestSolutions {
	
		@Test
		public void testMain(){
			
			DrinkType drinkType = DrinkType.AMERICANO;
			List<Inventory> inventoryDetails = Arrays.asList(inventory().withIngredientName("Coffee")
					.withIngredientQuantity(10).build(),inventory().withIngredientName("Cream")
					.withIngredientQuantity(10).build(),inventory().withIngredientName("Espresso")
					.withIngredientQuantity(10).build(),inventory().withIngredientName("Sugar")
					.withIngredientQuantity(10).build());
			List<Menu> menuDetails = Arrays.asList(menu().withDrinkType(DrinkType.AMERICANO).withDrinkName("Caffe Americano").build(),
					menu().withDrinkType(DrinkType.COFFEE).withDrinkName("Coffee").build());
			
			
		   Set<Inventory> inventory = new HashSet<Inventory>();
		   inventory.addAll(inventoryDetails);
		   Set<Menu> menu = new HashSet<Menu>();
		   menu.addAll(menuDetails);
		  
		   CoffeeMachineInventory addInventory = new CoffeeMachineInventoryImpl(inventory);
		   CoffeeMachineMenu addMenu = new CoffeeMachineMenuImpl(menu);	
	       addMenu.orderDrink(addInventory,drinkType);
	      
	       Inventory quantity = inventory.stream().filter(s -> s.getIngredientName().equals("Espresso")).findFirst().orElse(null);
	       
	       assert(quantity.getIngredientQuantity().equals(7));		   
	       
	       addMenu.orderDrink(addInventory,drinkType);
	       addMenu.orderDrink(addInventory,drinkType);
	      	       
	       assert(quantity.getIngredientQuantity().equals(1));	
	       
	       Menu inStock = menu.stream().filter(s -> s.getDrinkName().equals("Caffe Americano")).findFirst().orElse(null);
	       
	       assert(inStock.getInStock().equals(false));	
	       
	       addMenu.restock(addInventory);
	               
	       assert(quantity.getIngredientQuantity().equals(10));	
		   
	}
}
