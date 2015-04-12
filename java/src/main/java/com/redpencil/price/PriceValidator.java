package com.redpencil.price;

public class PriceValidator {
	static final double MAXIMUM_ALLOWED_REDUCTION = -.3;
	static final double MINIMUM_ALLOWED_REDUCTION = -.05;

	public boolean isValidReduction(final double pricePercentageChange) {
		return isReduction(pricePercentageChange) && isInRange(pricePercentageChange);
	}

	private boolean isInRange(final double pricePercentageChange) {
		return pricePercentageChange <= MINIMUM_ALLOWED_REDUCTION && pricePercentageChange >= MAXIMUM_ALLOWED_REDUCTION;
	}

	public boolean isIncrease(final double pricePercentageChange) {
		return !isReduction(pricePercentageChange);
	}

	private boolean isReduction(final double pricePercentageChange) {
		return pricePercentageChange < 0;
	}

}
