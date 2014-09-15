package com.vending.items;

public class Coin {
	private final Double value;

	public Coin(final String value) {
		this.value = Double.parseDouble(value);
	}

	public Coin(final double value) {
		this.value = value;
	}

	public Double getValue() {
		return this.value;
	}

}
