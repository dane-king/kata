package com.company.vending;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class VendingMachineTest {
	private VendingMachine machine;

	@Before
	public void setUp() {
		machine = new VendingMachine();
	}

	@Test
	public void test_machine_is_instantiated() {
		assertNotNull(machine);
	}

	@Test
	public void test_when_nothing_is_inserted_display_is_insert_coins() {
		machine.insert(null);
		assertEquals("INSERT COIN", machine.getDisplay());
	}

	@Test
	public void test_when_nickel_is_inserted_display_is_05() {
		machine.insert(Coin.NICKEL);
		assertEquals("0.05", machine.getDisplay());
	}

	@Test
	public void test_when_dime_is_inserted_display_is_10() {
		machine.insert(Coin.DIME);
		assertEquals("0.10", machine.getDisplay());

	}

	@Test
	public void test_when_quarter_is_inserted_display_is_25() {
		machine.insert(Coin.QUARTER);
		assertEquals("0.25", machine.getDisplay());

	}

	@Test
	public void test_when_penny_is_inserted_display_is_insert_coin() {
		machine.insert(Coin.PENNY);
		assertEquals("INSERT COIN", machine.getDisplay());

	}
}
