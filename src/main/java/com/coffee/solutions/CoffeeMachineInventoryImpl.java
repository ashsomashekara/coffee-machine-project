package com.coffee.solutions;

import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.coffee.data.Inventory;

/*
 * This class provides status of Inventory, restock if needed,
 * display inventory and add inventory items.And also has a function to 
 * check the status of the stock
 */

public class CoffeeMachineInventoryImpl implements CoffeeMachineInventory {

	public Set<Inventory> inventoryList = new HashSet<Inventory>();
	
	public CoffeeMachineInventoryImpl() {
		super();
	}

	public CoffeeMachineInventoryImpl(Set<Inventory> inventoryList) {
		super();
		this.inventoryList = inventoryList;
	}

	public void addInventory(String ingredientName, Integer ingredientQuantity) {
		Inventory inventoryData = new Inventory();
		inventoryData.setIngredientName(ingredientName); 
		inventoryData.setIngredientQuantity(ingredientQuantity);
		inventoryList.add(inventoryData);
	 }

	public void updateInventory(String ingredientName, Integer ingredientQuantity) {
		inventoryList.stream()
		.filter(s->s.getIngredientName().equals(ingredientName))
		.findAny()
		.ifPresent(s ->{ 
			if((s.getIngredientQuantity()- ingredientQuantity) >= 0 ){
				s.setIngredientQuantity( s.getIngredientQuantity() - ingredientQuantity);
			} else {
				System.out.println("Out of Stock:");;
			}
	    });
	 }
 
	public void  displayInventory() {
		List<Inventory> sortedList = new ArrayList<Inventory>(inventoryList);
		
		sortedList.sort(
			      (Inventory h1, Inventory h2) -> h1.getIngredientName().compareTo(h2.getIngredientName()));
		
		System.out.println("Current Inventory:");
		sortedList.forEach(item->System.out.println("  " + item.getIngredientName() + "  "
				+ item.getIngredientQuantity()));
	 }
	
   	public void restock() {
		int ingredientQuantity = 10; 
		inventoryList.stream()
		.forEach(s -> s.setIngredientQuantity(ingredientQuantity));
	 }

	public Boolean stockStatus(String ingredientName,Integer noOfUnitsRequired) {
		boolean stockStatus = inventoryList.stream()
				.filter(s->s.getIngredientName().equals(ingredientName) && s.getIngredientQuantity() > 0)
	            .anyMatch(p -> p.getIngredientQuantity() >= noOfUnitsRequired);
		return stockStatus;
	}

	public Set<Inventory> getStockDetails() {
		 return inventoryList;
	}
}
	
