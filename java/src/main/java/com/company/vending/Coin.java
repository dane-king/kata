package com.company.vending;

import java.util.Map;
import java.util.TreeMap;

public enum Coin {
	PENNY(1), NICKEL(5), DIME(10), QUARTER(25);

	private Integer value;

	private Coin(final Integer value) {
		this.value = value;
	}

	public String getDisplay() {
		return String.format("%3.2f", this.value / 100D);
	}

	public Integer getValue() {
		return this.value;
	}

	private static Map<String, Coin> coins = new TreeMap<String, Coin>();

	static {
		for (Coin coin : Coin.values()) {
			coins.put(coin.name(), coin);
		}
	}

	public static Coin find(final String coin) {
		return coins.get(coin);
	}

	public static Coin find(final Coin coin) {
		return coin == null ? null : find(coin.name());
	}
}
