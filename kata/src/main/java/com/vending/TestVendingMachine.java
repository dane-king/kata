package com.vending;

import com.vending.items.Item;
import com.vending.items.ItemFactory;

@SuppressWarnings("rawtypes")
public class TestVendingMachine {
	Item soda;
	Item candy;
	Item chips;
	ItemFactory factory;

	public void setFactory(final ItemFactory factory) {
		this.factory = factory;
	}

	public TestVendingMachine() {
		soda = factory.createSoda("Pepsi", 1.75);
		candy = factory.createCandy("Snickers", 1.50);
		chips = factory.createChips("Lays", .95);

	}

}
