package com.vending.items;

@SuppressWarnings("rawtypes")
public class Candy implements Item {
	private final String name;
	private final Double price;

	public Candy(final String name, final Double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return this.name;
	}

	public Double getPrice() {
		return this.price;
	}

}
