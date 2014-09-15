package com.vending.items;

@SuppressWarnings("rawtypes")
public class Soda implements Item {
	private final String name;
	private final Double price;

	public Soda(final String name, final Double price) {
		this.name = name;
		this.price = price;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.vending.Item#getName()
	 */
	public String getName() {
		return name;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.vending.Item#getPrice()
	 */
	public Double getPrice() {
		return price;
	}

}
