package com.bank.ocr.account;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import com.bank.account.AccountReader;

public class AccountReaderTest {

	private static final String TEST_FILE = "/accounts.txt";

	@Test
	public void test_read_file_should_have_more_than_0_elements() throws IOException {
		List<AccountNumber> accounts = AccountReader.getValidAccounts(TEST_FILE);
		assertNotNull(accounts);
		assertTrue(accounts.size() > 0);
	}

	@Test
	public void test_read_file_should_throw_exception_when_path_is_invalid() {

		boolean hasErrors = false;
		try {
			List<AccountNumber> accounts = AccountReader.getValidAccounts("");
		} catch (IOException e) {
			hasErrors = true;
		}

		assertTrue(hasErrors);
	}

	@Test
	public void test_valid_contents() throws IOException {
		List<AccountNumber> accounts = AccountReader.getValidAccounts(TEST_FILE);
		assertEquals("000000000", accounts.get(0).toString());
		assertEquals("999999999", accounts.get(10).toString());
		assertEquals("123456789", accounts.get(9).toString());

	}
}
