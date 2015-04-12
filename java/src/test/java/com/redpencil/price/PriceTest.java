package com.redpencil.price;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class PriceTest {

	private static final int INITIAL_PRICE = 100;
	Price underTest;
	@Mock
	Promotion promotion;
	PromotionTest promotionTest;

	@Before
	public void setUp() throws Exception {
		initMocks(this);
		underTest = new Price(INITIAL_PRICE, promotion);
	}

	@Test
	public void priceChangeShouldTestPromotion() {
		changePriceBy(10);
		verify(promotion).checkPromotion(.1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void instantiatePriceWithZeroWillThrowError() {
		underTest = new Price(0, promotion);
	}

	@Test
	public void priceCalculatePercentage() {
		changePriceBy(10);
		assertThat(underTest.calculatePercentage(), equalTo(.10));
	}

	void changePriceBy(final double amount) {
		underTest.setChange(amount);
	}

}
