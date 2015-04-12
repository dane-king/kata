package com.vending.items;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.vending.items.Coin;

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
