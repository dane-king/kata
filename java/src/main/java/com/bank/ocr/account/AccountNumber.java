package com.bank.ocr.account;

/**
 * Class to Represent Account Number which is an Array of AccountDigits Class
 * can be constructed with either an Array of Account Digits or a OCR image of
 * the account number, which is 4 lines and 27 characters in each line
 * 
 * @author Dane King
 * 
 */
public class AccountNumber {
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (AccountDigit number : numbers) {
			if (number == null) {
				sb.append("?");
			} else {
				sb.append(number.getNumber().toString());
			}
		}
		return sb.toString();
	}

	private static final int ACCOUNT_DIGITS = 9;
	private static final int MAX_LINES = 4;
	private static final int NUM_SPACES = 3;

	private final AccountDigit[] numbers;

	public AccountNumber(final String[] lines) {
		this.numbers = parseTextLines(lines);
	}

	public AccountNumber(final AccountDigit[] digits) {
		this.numbers = digits;
	}

	private AccountDigit[] parseTextLines(final String[] lines) {
		int beginStr = 0;
		int endStr = NUM_SPACES;
		String[] numberStrings = new String[4];
		AccountDigit[] accountNumbers = new AccountDigit[ACCOUNT_DIGITS];
		// loop over all the digits for all the lines
		for (int i = 0; i < ACCOUNT_DIGITS; i++) {
			for (int j = 0; j < MAX_LINES; j++) {
				try {
					numberStrings[j] = lines[j].substring(beginStr, endStr);
				} catch (Exception e) {
					e.printStackTrace();
					numberStrings[j] = "";
					break;
				}
			}
			accountNumbers[i] = AccountDigit.find(numberStrings);
			beginStr = endStr;
			endStr += NUM_SPACES;
		}
		return accountNumbers;
	}

	public AccountDigit[] getAccountNumber() {
		return this.numbers;
	}

	public boolean checkSum() {
		long value = 0;
		for (int i = 0, multiplier = ACCOUNT_DIGITS; i < ACCOUNT_DIGITS; i++) {
			if (numbers[i] != null) {
				value += numbers[i].getNumber().intValue() * multiplier--;
			}
		}
		return value % 11 == 0;
	}
}
