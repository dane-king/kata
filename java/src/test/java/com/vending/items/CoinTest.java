package com.vending.items;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoinTest {
	@Test
	public void shouldInstantiateQuarterWithString() {
		Coin coin = new Coin(".25");
		assertEquals(Double.valueOf(.25), coin.getValue());
	}

	@Test
	public void shouldInstantiateQuarterWithDouble() {
		Coin coin = new Coin(.25);
		assertEquals(Double.valueOf(.25), coin.getValue());
	}

	@Test
	public void shouldInstantiateDimWithString() {
		Coin coin = new Coin(".10");
		assertEquals(Double.valueOf(.1), coin.getValue());
	}

}
