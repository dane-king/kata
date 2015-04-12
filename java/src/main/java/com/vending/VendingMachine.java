package com.vending;

import java.util.ArrayList;
import java.util.List;

import com.vending.items.Coin;

public class VendingMachine {
	private final List<Coin> coins = new ArrayList<Coin>();
	private final List<Coin> returnSlot = new ArrayList<Coin>();

	public void insert(final Coin coin) {
		directCoin(coin);
	}

	private void directCoin(final Coin coin) {
		if (isValid(coin)) {
			this.coins.add(coin);
		} else {
			this.returnSlot.add(coin);
		}
	}

	private boolean isValid(final Coin coin) {
		return coin.getValue() > .01;
	}

	public String getDisplay() {
		return String.format("%01.2f", totalCoins());
	}

	private Double totalCoins() {
		Double total = 0d;
		for (Coin coin : coins) {
			total += isValid(coin) ? coin.getValue() : 0;
		}
		return total;
	}

	public List<Coin> getReturnSlot() {
		return returnSlot;
	}

	public void cancel() {
		returnSlot.addAll(coins);
	}
}
