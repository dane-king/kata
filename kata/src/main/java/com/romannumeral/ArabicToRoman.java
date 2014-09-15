package com.romannumeral;

public class ArabicToRoman {

	private static final int I_OFFSET = -2;

	private static final char NULL_CHAR = '\0';

	public int convert(final String num) {
		int returnNum = 0;
		char[] numeralArray = num.toCharArray();
		for (int pos = size(numeralArray); pos >= 0; pos--) {
			char previousCharacter = getPreviousCharacter(numeralArray, pos);
			char currentCharacter = numeralArray[pos];
			returnNum += calculateNumeral(currentCharacter, previousCharacter);
		}
		return returnNum;
	}

	private int calculateNumeral(final char currentCharacter, final char previousCharacter) {
		return getDigitValue(currentCharacter) + leadingINumeralOffset(currentCharacter, previousCharacter);
	}

	private int getDigitValue(final char currentCharacter) {
		return RomanNumerals.valueOf(String.valueOf(currentCharacter)).numericalValue();
	}

	private int size(final char[] numeralArray) {
		return numeralArray.length - 1;
	}

	private int leadingINumeralOffset(final char currentCharacter, final char previousCharacter) {
		if (isOne(currentCharacter) && !isOne(previousCharacter) && previousCharacter != NULL_CHAR) {
			return I_OFFSET;
		}
		return 0;
	}

	private boolean isOne(final char num) {
		return num == 'I';
	}

	private char getPreviousCharacter(final char[] numeralArray, final int currentPosition) {
		char buf = '\0';
		if (currentPosition < size(numeralArray)) {
			buf = numeralArray[currentPosition + 1];
		}
		return buf;
	}
}
