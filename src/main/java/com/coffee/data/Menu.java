package com.coffee.data;

import com.coffee.utility.DrinkType;

/* Object which holds menu */

public class Menu {
	
	private DrinkType drinkType;
	private String drinkName;
	private Double drinkCost;
	private Boolean inStock;
	
	public Menu() {
	    super();
	}
	
	public Menu(DrinkType drinkType, String drinkName, Double drinkCost, Boolean inStock) {
		super();
		this.drinkType = drinkType;
		this.drinkName = drinkName;
		this.drinkCost = drinkCost;
		this.inStock = inStock;
	}
	public DrinkType getDrinkType() {
		return drinkType;
	}
	public void setDrinkType(DrinkType drinkType) {
		this.drinkType = drinkType;
	}
	public String getDrinkName() {
		return drinkName;
	}
	public void setDrinkName(String drinkName) {
		this.drinkName = drinkName;
	}
	public Double getDrinkCost() {
		return drinkCost;
	}
	public void setDrinkCost(Double drinkCost) {
		this.drinkCost = drinkCost;
	}
	public Boolean getInStock() {
		return inStock;
	}
	public void setInStock(Boolean inStock) {
		this.inStock = inStock;
	}
	@Override
	public String toString() {
		return "Menu [drinkNumber=" + drinkType + ", drinkName=" + drinkName + ", drinkCost=" + drinkCost
				+ ", inStock=" + inStock + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((drinkName == null) ? 0 : drinkName.hashCode());
		result = prime * result + ((drinkType == null) ? 0 : drinkType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Menu other = (Menu) obj;
		if (drinkName == null) {
			if (other.drinkName != null)
				return false;
		} else if (!drinkName.equals(other.drinkName))
			return false;
		if (drinkType == null) {
			if (other.drinkType != null)
				return false;
		} else if (!drinkType.equals(other.drinkType))
			return false;
		return true;
	}	
}
