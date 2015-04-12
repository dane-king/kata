package com.redpencil.price;

import static com.redpencil.price.PriceValidator.MAXIMUM_ALLOWED_REDUCTION;
import static com.redpencil.price.PriceValidator.MINIMUM_ALLOWED_REDUCTION;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Before;
import org.junit.Test;

public class PriceValidatorTest {
	private PriceValidator underTest;
	static final double CHANGE_AMOUNT = .01;

	@Before
	public void setup() {
		underTest = new PriceValidator();
	}

	@Test
	public void minimumAllowedReductionIsValid() {
		assertThat(underTest.isValidReduction(MINIMUM_ALLOWED_REDUCTION), equalTo(true));
	}

	@Test
	public void maximumAllowedReductionIsValid() {
		assertThat(underTest.isValidReduction(MAXIMUM_ALLOWED_REDUCTION), equalTo(true));
	}

	@Test
	public void lessThanMinimumAllowedReductionIsInvalid() {
		assertThat(underTest.isValidReduction(MINIMUM_ALLOWED_REDUCTION + CHANGE_AMOUNT), equalTo(false));
	}

	@Test
	public void greaterThanMaximumAllowedReductionIsInvalid() {
		assertThat(underTest.isValidReduction(MAXIMUM_ALLOWED_REDUCTION - CHANGE_AMOUNT), equalTo(false));
	}

	@Test
	public void priceIncreaseReturnTrue() {
		assertThat(underTest.isIncrease(CHANGE_AMOUNT), equalTo(true));
	}

	@Test
	public void priceIncreaseReturnFalse() {
		assertThat(underTest.isIncrease(-CHANGE_AMOUNT), equalTo(false));
	}

}
