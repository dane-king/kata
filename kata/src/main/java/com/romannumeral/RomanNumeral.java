package com.romannumeral;

import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class RomanNumeral {

	private final Set<Entry<Integer, String>> entrySet;

	public RomanNumeral() {
		final TreeMap<Integer, String> values = new TreeMap<Integer, String>();
		values.put(10, "X");
		values.put(9, "IX");
		values.put(4, "IV");
		values.put(5, "V");
		values.put(1, "I");

		entrySet = values.descendingMap().entrySet();
	}

	public String convert(int i) {
		StringBuffer returnString = new StringBuffer();
		for (Entry<Integer, String> entries : entrySet) {
			int compareValue = entries.getKey();
			while (i >= compareValue) {
				returnString.append(entries.getValue());
				i -= entries.getKey();
			}
		}

		return returnString.toString();
	}
}
