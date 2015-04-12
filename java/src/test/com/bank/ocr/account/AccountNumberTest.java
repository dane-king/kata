package com.bank.ocr.account;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AccountNumberTest {

	private static final int LINES_PER_ACCOUNT = 4;

	@Test
	public void test_parse_ZeroAccountNumber() {
		AccountNumber account = mockAllZeroAccountNumber();
		AccountDigit[] parsedAccountNumber = account.getAccountNumber();
		for (int i = 0; i < 9; i++) {
			assertEquals(parsedAccountNumber[i].getNumber(), new Integer(0));
		}

	}

	@Test
	public void test_parse_111111111() {
		AccountNumber account = mockAllOnesAccountNumber();
		AccountDigit[] parsedAccountNumber = account.getAccountNumber();
		for (int i = 0; i < 9; i++) {
			assertEquals(parsedAccountNumber[i].getNumber(), new Integer(1));
		}

	}

	@Test
	public void test_parse_sixes() {
		AccountNumber account = mockAllSixesAccountNumber();
		AccountDigit[] parsedAccountNumber = account.getAccountNumber();

		for (int i = 0; i < 9; i++) {
			assertEquals(parsedAccountNumber[i].getNumber(), new Integer(6));
		}

	}

	@Test
	public void test_parse_123456789() {
		AccountNumber account = mockSequenceAccountNumber();
		AccountDigit[] parsedAccountNumber = account.getAccountNumber();
		for (int i = 0; i < 9; i++) {
			Integer number = parsedAccountNumber[i].getNumber();
			assertEquals(new Integer(i + 1), number);
		}

	}

	@Test
	public void test_checksum_is_valid() {
		assertTrue(mockSequenceAccountNumber().checkSum());
	}

	@Test
	public void test_checksum_is_invalid() {
		assertFalse(mockInvalidAccountNumber().checkSum());
	}

	@Test
	public void test_checksum_for_all_given_account_number() {
		assertTrue(mockTestAccountNumber().checkSum());
	}

	private AccountNumber mockAllZeroAccountNumber() {
		String[] accountNumber = new String[4];
		accountNumber[0] = " _  _  _  _  _  _  _  _  _ ";
		accountNumber[1] = "| || || || || || || || || |";
		accountNumber[2] = "|_||_||_||_||_||_||_||_||_|";
		accountNumber[3] = "                           ";
		return new AccountNumber(accountNumber);
	}

	private AccountNumber mockSequenceAccountNumber() {
		String[] accountNumber = new String[4];
		accountNumber[0] = "    _  _     _  _  _  _  _ ";
		accountNumber[1] = "  | _| _||_||_ |_   ||_||_|";
		accountNumber[2] = "  ||_  _|  | _||_|  ||_| _|";
		accountNumber[3] = "                           ";
		return new AccountNumber(accountNumber);
	}

	private AccountNumber mockTestAccountNumber() {
		AccountDigit[] digits = new AccountDigit[9];
		digits[0] = AccountDigit.THREE;
		digits[1] = AccountDigit.FOUR;
		digits[2] = AccountDigit.FIVE;
		digits[3] = AccountDigit.EIGHT;
		digits[4] = AccountDigit.EIGHT;
		digits[5] = AccountDigit.TWO;
		digits[6] = AccountDigit.EIGHT;
		digits[7] = AccountDigit.SIX;
		digits[8] = AccountDigit.FIVE;
		return new AccountNumber(digits);
	}

	private AccountNumber mockInvalidAccountNumber() {
		String[] accountNumber = new String[4];
		accountNumber[0] = "    _  _     _  _  _  _  _ ";
		accountNumber[1] = "  | _| _||_||  |_   ||_||_|";
		accountNumber[2] = "  ||_  _|  | _||_|  ||_| _|";
		accountNumber[3] = "                           ";
		return new AccountNumber(accountNumber);
	}

	private AccountNumber mockAllOnesAccountNumber() {
		String[] accountNumber = new String[4];
		accountNumber[0] = "                           ";
		accountNumber[1] = "  |  |  |  |  |  |  |  |  |";
		accountNumber[2] = "  |  |  |  |  |  |  |  |  |";
		accountNumber[3] = "                           ";

		return new AccountNumber(accountNumber);
	}

	private AccountNumber mockAllSixesAccountNumber() {
		String[] accountNumber = new String[4];
		accountNumber[0] = " _  _  _  _  _  _  _  _  _ ";
		accountNumber[1] = "|_ |_ |_ |_ |_ |_ |_ |_ |_ ";
		accountNumber[2] = "|_||_||_||_||_||_||_||_||_|";
		accountNumber[3] = "                           ";

		return new AccountNumber(accountNumber);

	}

}
