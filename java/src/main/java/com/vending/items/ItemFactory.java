package com.vending.items;

@SuppressWarnings("rawtypes")
public class ItemFactory {

	public Item createSoda(final String name, final double price) {
		return new Soda(name, price);
	}

	public Item createCandy(final String name, final double price) {
		return new Candy(name, price);
	}

	public Item createChips(final String name, final double price) {
		return new Chips(name, price);
	}

}
