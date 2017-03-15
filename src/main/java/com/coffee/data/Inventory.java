package com.coffee.data;

/* Object which holds inventory */

public class Inventory {
	
	private String ingredientName;
	private Integer ingredientQuantity;
	
	public String getIngredientName() {
		return ingredientName;
	}
	
	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}
	
	public Integer getIngredientQuantity() {
		return ingredientQuantity;
	}
	
	public void setIngredientQuantity(Integer ingredientQuantity) {
		this.ingredientQuantity = ingredientQuantity;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ingredientName == null) ? 0 : ingredientName.hashCode());
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
		Inventory other = (Inventory) obj;
		if (ingredientName == null) {
			if (other.ingredientName != null)
				return false;
		} else if (!ingredientName.equals(other.ingredientName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Inventory [ingredientName=" + ingredientName + ", "
				+ "ingredientQuantity=" + ingredientQuantity + "]";
	}
}
