package com.babysitter;

public class Dollars {

	private final int amount;

	public Dollars(final int amount) {
		this.amount = amount;
	}

	@Override
	public int hashCode() {
		return amount;
	}

	@Override
	public boolean equals(final Object obj) {
		return obj instanceof Dollars && amount == ((Dollars) obj).amount;

	}
}
