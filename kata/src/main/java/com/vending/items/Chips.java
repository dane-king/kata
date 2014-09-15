package com.vending.items;

@SuppressWarnings("rawtypes")
public class Chips implements Item {
	private final Double price;
	private final String name;

	public Chips(final String name, final Double price) {
		this.price = price;
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public Double getPrice() {
		return this.price;
	}

}
