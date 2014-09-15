package com.company.vending;

public class VendingMachine {
	private String display;

	public String getDisplay() {
		return display;
	}

	public void insert(final Coin insertedCoin) {
		Coin coin = Coin.find(insertedCoin);
		if (coin == null || Coin.PENNY.equals(insertedCoin)) {
			this.display = "INSERT COIN";
		} else {
			this.display = coin.getDisplay();
		}
	}

}
