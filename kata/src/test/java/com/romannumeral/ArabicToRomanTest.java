package com.romannumeral;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ArabicToRomanTest {
	private ArabicToRoman converter;

	@Before
	public void setUp() {
		converter = new ArabicToRoman();
	}

	@Test
	public void shouldConvertIToOne() {
		assertEquals(1, converter.convert("I"));
	}

	@Test
	public void shouldConvertXXVIIToOne() {
		assertEquals(27, converter.convert("XXVII"));
	}

	@Test
	public void shouldConvertIVToFour() {
		assertEquals(4, converter.convert("IV"));
	}

	@Test
	public void shouldConvertIXToNine() {
		assertEquals(9, converter.convert("IX"));
	}

	@Test
	public void shouldConvertIIIToThree() {
		assertEquals(3, converter.convert("III"));
	}

	@Test
	public void shouldConvertVToFive() {
		assertEquals(5, converter.convert("V"));
	}
}
