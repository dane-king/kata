package com.bank.ocr.account;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Enum Class to represent OCR scan of an Account Digit Implements a reverse
 * lookup so you can find the enum based on the scanned lines Image is 4 lines
 * of 3 characters with the last line being blank
 * 
 * @author Dane King
 * 
 */
public enum AccountDigit {
	ZERO(new String[] { " _ ", "| |", "|_|", "   " }), ONE(new String[] { "   ", "  |", "  |", "   " }), TWO(
			new String[] { " _ ", " _|", "|_ ", "   " }), THREE(new String[] { " _ ", " _|", " _|", "   " }), FOUR(
			new String[] { "   ", "|_|", "  |", "   " }), FIVE(new String[] { " _ ", "|_ ", " _|", "   " }), SIX(
			new String[] { " _ ", "|_ ", "|_|", "   " }), SEVEN(new String[] { " _ ", "  |", "  |", "   " }), EIGHT(
			new String[] { " _ ", "|_|", "|_|", "   " }), NINE(new String[] { " _ ", "|_|", " _|", "   " });

	private String[] lines;

	private AccountDigit(final String[] lines) {
		this.lines = lines;
	}

	public Integer getNumber() {
		return this.ordinal();
	}

	public Integer getHashForLines() {
		return Integer.valueOf(Arrays.hashCode(getLines()));
	}

	/**
	 * 
	 * @return String array representing the number
	 */
	public String[] getLines() {
		return this.lines;
	}

	public boolean isEqual(final String[] lines) {
		return Arrays.equals(getLines(), this.lines);
	}

	/**
	 * Create a static lookup map for reverse lookup Need to hash the String
	 * Array and use Arrays.hashCode for the objects to be equal Could also
	 * implement a Comparator with a Tree Map
	 */
	private static final Map<Integer, AccountDigit> lookup = new HashMap<Integer, AccountDigit>();

	static {
		for (AccountDigit number : AccountDigit.values()) {
			lookup.put(number.getHashForLines(), number);
		}

	}

	/**
	 * Reverse find for enum values
	 * 
	 * @param lines
	 * @return
	 */
	public static AccountDigit find(final String[] lines) {
		Integer key = Integer.valueOf(Arrays.hashCode(lines));
		return lookup.get(key);
	}

}
