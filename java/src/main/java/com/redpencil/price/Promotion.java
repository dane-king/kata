package com.redpencil.price;

public class Promotion {

	private boolean started;
	private final PriceValidator validator;

	public Promotion(final PriceValidator validator) {
		this.validator = validator;
	}

	public void start() {
		this.started = true;
	}

	public boolean isStarted() {
		return this.started;
	}

	public void end() {
		this.started = false;
	}

	public void checkPromotion(final double pricePercentageChange) {
		if (validator.isIncrease(pricePercentageChange)) {
			end();
		} else if (validator.isValidReduction(pricePercentageChange)) {
			start();
		}
	}

}
