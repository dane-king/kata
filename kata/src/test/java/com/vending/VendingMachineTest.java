package com.vending;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.vending.items.Coin;

public class VendingMachineTest {
	private VendingMachine machine;

	@Before
	public void setUp() {
		machine = new VendingMachine();

	}

	@Test
	public void shouldDisplayAcceptedQuarter() throws Exception {
		insertQuarter();
		assertEquals("0.25", machine.getDisplay());
	}

	@Test
	public void shouldDisplayAcceptedDime() throws Exception {
		insertDime();
		assertEquals("0.10", machine.getDisplay());
	}

	@Test
	public void shouldDisplayAcceptedCoins() throws Exception {
		insertDime();
		insertPenny();
		insertQuarter();
		insertQuarter();
		assertEquals("0.60", machine.getDisplay());
	}

	@Test
	public void shouldReturnRejectedCoinList() {
		insertPenny();
		Double value = machine.getReturnSlot().get(0).getValue();
		assertEquals(Double.valueOf(.01), value);
	}

	@Test
	public void shouldReturnMultipleRejectedCoins() {
		insertPenny();
		insertPenny();
		Double value = totalReturnedCoins();
		assertEquals(Double.valueOf(.02), value);
	}

	private Double totalReturnedCoins() {
		List<Coin> coins = machine.getReturnSlot();
		double total = 0;
		for (Coin coin : coins) {
			total += coin.getValue();
		}
		return total;
	}

	@Test
	public void shouldReturnAllCoinsWhenReturnCoinsIsCalled() {
		insertPenny();
		insertQuarter();
		insertNickle();
		machine.cancel();
		Double value = totalReturnedCoins();

		assertEquals(Double.valueOf(.31), value);
	}

	private void insertNickle() {
		machine.insert(new Coin(.05));

	}

	private void insertPenny() {
		machine.insert(new Coin(".01"));

	}

	private void insertQuarter() {
		machine.insert(new Coin(".25"));
	}

	private void insertDime() {
		machine.insert(new Coin(".10"));
	}
}
