package com.coffee.solutions;

import java.util.Set;

import com.coffee.data.Inventory;

public interface CoffeeMachineInventory {
	
	public void addInventory(String ingredientName,Integer ingredientQuantity);
	public void updateInventory(String ingredientName,Integer ingredientQuantity);
	public void displayInventory();
	public void restock();
	public Boolean stockStatus(String ingredientName,Integer noOfUnitsRequired);
	public Set<Inventory> getStockDetails();

}
