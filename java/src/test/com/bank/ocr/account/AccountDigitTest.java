package com.bank.ocr.account;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AccountDigitTest {
	private String[] lines;

	@Test
	public void test_equals() {
		assertTrue(AccountDigit.ONE.isEqual(mockOne()));
	}

	@Test
	public void test_parse_empty_array_should_return_null() {
		assertNull(AccountDigit.find(new String[4]));
	}

	@Test
	public void test_parse_empty_array_with_missing_line_should_return_null() {
		assertNull(AccountDigit.find(mockZeroMissingLine()));
	}

	@Test
	public void test_parse_empty_array_with_extra_line_should_return_null() {
		assertNull(AccountDigit.find(mockZeroExtraLine()));
	}

	@Test
	public void test_parse_should_equal_zero() {
		assertEquals(AccountDigit.ZERO, AccountDigit.find(mockZero()));
	}

	@Test
	public void test_parse_should_equal_one() {
		lines = mockOne();
		assertEquals(AccountDigit.ONE, AccountDigit.find(lines));
	}

	@Test
	public void test_parse_should_equal_two() {
		lines = mockTwo();
		assertEquals(AccountDigit.TWO, AccountDigit.find(lines));
	}

	@Test
	public void test_parse_should_equal_three() {
		lines = mockThree();
		assertEquals(AccountDigit.THREE, AccountDigit.find(lines));
	}

	@Test
	public void test_parse_should_equal_four() {
		lines = mockFour();
		assertEquals(AccountDigit.FOUR, AccountDigit.find(lines));
	}

	@Test
	public void test_parse_should_equal_five() {
		lines = mockFive();
		assertEquals(AccountDigit.FIVE, AccountDigit.find(lines));
	}

	@Test
	public void test_parse_should_equal_six() {
		lines = mockSix();
		assertEquals(AccountDigit.SIX, AccountDigit.find(lines));
	}

	@Test
	public void test_parse_should_equal_seven() {
		lines = mockSeven();
		assertEquals(AccountDigit.SEVEN, AccountDigit.find(lines));
	}

	@Test
	public void test_parse_should_equal_eight() {
		lines = mockEight();
		assertEquals(AccountDigit.EIGHT, AccountDigit.find(lines));
	}

	@Test
	public void test_parse_should_equal_nine() {
		lines = mockNine();
		assertEquals(AccountDigit.NINE, AccountDigit.find(lines));
	}

	private String[] mockZero() {
		String[] lines = new String[4];
		lines[0] = " _ ";
		lines[1] = "| |";
		lines[2] = "|_|";
		lines[3] = "   ";
		return lines;
	}

	private String[] mockZeroExtraLine() {
		String[] lines = new String[5];
		lines[0] = " _ ";
		lines[1] = "| |";
		lines[2] = "|_|";
		lines[3] = "   ";
		lines[4] = "   ";
		return lines;
	}

	private String[] mockZeroMissingLine() {
		String[] lines = new String[3];
		lines[0] = " _ ";
		lines[1] = "| |";
		lines[2] = "|_|";
		return lines;
	}

	private String[] mockOne() {
		String[] lines = new String[4];
		lines[0] = "   ";
		lines[1] = "  |";
		lines[2] = "  |";
		lines[3] = "   ";
		return lines;
	}

	private String[] mockTwo() {
		String[] lines = new String[4];
		lines[0] = " _ ";
		lines[1] = " _|";
		lines[2] = "|_ ";
		lines[3] = "   ";
		return lines;
	}

	private String[] mockThree() {
		String[] lines = new String[4];
		lines[0] = " _ ";
		lines[1] = " _|";
		lines[2] = " _|";
		lines[3] = "   ";
		return lines;
	}

	private String[] mockFour() {
		String[] lines = new String[4];
		lines[0] = "   ";
		lines[1] = "|_|";
		lines[2] = "  |";
		lines[3] = "   ";
		return lines;
	}

	private String[] mockFive() {
		String[] lines = new String[4];
		lines[0] = " _ ";
		lines[1] = "|_ ";
		lines[2] = " _|";
		lines[3] = "   ";
		return lines;
	}

	private String[] mockSix() {
		String[] lines = new String[4];
		lines[0] = " _ ";
		lines[1] = "|_ ";
		lines[2] = "|_|";
		lines[3] = "   ";
		return lines;
	}

	private String[] mockSeven() {
		String[] lines = new String[4];
		lines[0] = " _ ";
		lines[1] = "  |";
		lines[2] = "  |";
		lines[3] = "   ";
		return lines;
	}

	private String[] mockEight() {
		String[] lines = new String[4];
		lines[0] = " _ ";
		lines[1] = "|_|";
		lines[2] = "|_|";
		lines[3] = "   ";
		return lines;
	}

	private String[] mockNine() {
		String[] lines = new String[4];
		lines[0] = " _ ";
		lines[1] = "|_|";
		lines[2] = " _|";
		lines[3] = "   ";
		return lines;
	}
}
