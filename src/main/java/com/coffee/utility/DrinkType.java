package com.coffee.utility;

public enum DrinkType {
	AMERICANO(1), LATTE(2), MOCHA(3), CAPPACCINO(4), COFFEE(5), DECAF(6);

	private final int value;

	DrinkType(int value) {
		this.value = value;
	}

}
