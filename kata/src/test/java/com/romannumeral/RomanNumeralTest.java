package com.romannumeral;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class RomanNumeralTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test_roman_numeral_can_be_instantiated() {
		RomanNumeral romanNumeral = new RomanNumeral();
		assertNotNull(romanNumeral);
	}

	@Test
	public void test_convert_1_returns_I() {
		RomanNumeral romanNumeral = new RomanNumeral();
		assertEquals("I", romanNumeral.convert(1));
	}

	@Test
	public void test_convert_2_returns_II() {
		RomanNumeral romanNumeral = new RomanNumeral();
		assertEquals("II", romanNumeral.convert(2));
	}

	@Test
	public void test_convert_3_returns_III() {
		RomanNumeral romanNumeral = new RomanNumeral();
		assertEquals("III", romanNumeral.convert(3));
	}

	@Test
	public void test_convert_4_returns_IV() {
		RomanNumeral romanNumeral = new RomanNumeral();
		assertEquals("IV", romanNumeral.convert(4));
	}

	@Test
	public void test_convert_5_returns_V() {
		RomanNumeral romanNumeral = new RomanNumeral();
		assertEquals("V", romanNumeral.convert(5));
	}

	@Test
	public void test_convert_6_returns_VI() {
		RomanNumeral romanNumeral = new RomanNumeral();
		assertEquals("VI", romanNumeral.convert(6));
	}

	@Test
	public void test_convert_7_returns_VII() {
		RomanNumeral romanNumeral = new RomanNumeral();
		assertEquals("VII", romanNumeral.convert(7));
	}

	@Test
	public void test_convert_10_returns_X() {
		RomanNumeral romanNumeral = new RomanNumeral();
		assertEquals("X", romanNumeral.convert(10));
	}

	@Test
	public void test_convert_20_returns_XX() {
		RomanNumeral romanNumeral = new RomanNumeral();
		assertEquals("XX", romanNumeral.convert(20));
	}
}
