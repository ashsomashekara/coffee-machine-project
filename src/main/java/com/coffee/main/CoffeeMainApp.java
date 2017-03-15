package com.coffee.main;

import static com.coffee.utility.CoffeeMachineUtility.addInventory;
import static com.coffee.utility.CoffeeMachineUtility.initializeMenu;

import java.util.Scanner;

import com.coffee.solutions.CoffeeMachineInventory;
import com.coffee.solutions.CoffeeMachineMenu;
import com.coffee.utility.DrinkType;

/* Main class which lets user to view the Menu and Inventory.Select the appropriate drink,
 * dispense the drink based on the availability,restock the inventory 
 * and quit 
 */
public class CoffeeMainApp {

	public static void main(String[] args) {

		CoffeeMachineInventory coffeeMachineInventory = addInventory();
		CoffeeMachineMenu coffeeMachineMenu = initializeMenu();
		coffeeMachineInventory.displayInventory();
		coffeeMachineMenu.displayMenu();
		Scanner scanner = new Scanner(System.in);
		String command = "";
		boolean cont = true;
		
		while (cont) {
			command = scanner.next().toLowerCase();
			switch (command) {
			case "1":
			case "2":
			case "3":
			case "4":
			case "5":
			case "6":
				int drinkNumber = Integer.parseInt(command);
				coffeeMachineMenu.orderDrink(coffeeMachineInventory, DrinkType.values()[drinkNumber-1]);
				coffeeMachineInventory.displayInventory();
				coffeeMachineMenu.displayMenu();
				break;
			case "r":
				coffeeMachineMenu.restock(coffeeMachineInventory);
				coffeeMachineInventory.displayInventory();
				coffeeMachineMenu.displayMenu();
				break;
			case "q":
				cont = false;
				break;
			default:
				System.out.println("Invalid selection:" + command);
				cont = false;
				break;
			}
		}
		scanner.close();
	}
}
