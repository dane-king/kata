package com.redpencil.price;

public class Price {

	private final Promotion promotion;
	private final double startPrice;
	private double change;

	public Price(final double initial, final Promotion promotion) {
		validateInitial(initial);
		this.startPrice = initial;
		this.promotion = promotion;
	}

	private void validateInitial(final double initial_price) {
		if (initial_price <= 0)
			throw new IllegalArgumentException("Price must be greater than 0");
	}

	public void setChange(final double amount) {
		this.change = amount;
		promotion.checkPromotion(calculatePercentage());
	}

	public double calculatePercentage() {
		return this.change / startPrice;
	}

}
