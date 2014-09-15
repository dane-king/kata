package com.redpencil.price;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class PromotionTest {
	private static final double VALID_INCREASE = .1;
	private static final double VALID_DECREASE = -.05;
	static final boolean STARTED = true;
	private static final boolean NOT_STARTED = false;

	@Mock
	private PriceValidator validator;
	@InjectMocks
	private Promotion underTest;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void increaseEndsPromotion() {
		expectPriceIncrease();
		underTest.start();
		underTest.checkPromotion(.1);
		verifyPromotionIs(NOT_STARTED);
	}

	@Test
	public void increaseEndsAStartedPromotion() {
		expectPriceIncrease();
		underTest.checkPromotion(.1);
		verifyPromotionIs(NOT_STARTED);
	}

	private void expectPriceIncrease() {
		when(validator.isIncrease(VALID_INCREASE)).thenReturn(true);
	}

	@Test
	public void validDecreaseStartsPromotion() {
		expectPriceDecrease();
		underTest.checkPromotion(VALID_DECREASE);
		verifyPromotionIs(STARTED);
	}

	private void expectPriceDecrease() {
		when(validator.isIncrease(VALID_DECREASE)).thenReturn(false);
		when(validator.isValidReduction(VALID_DECREASE)).thenReturn(true);
	}

	void verifyPromotionIs(final boolean started) {
		assertThat(underTest.isStarted(), equalTo(started));
	}

}
