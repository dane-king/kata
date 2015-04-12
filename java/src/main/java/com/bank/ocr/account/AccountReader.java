package com.bank.ocr.account;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Reads Account from a text file
 * 
 * @author Dane King
 * 
 */
public class AccountReader {
	private static final int LINES_PER_ACCOUNT = 4;

	/**
	 * 
	 * @param filePath
	 *            is string representing location of text file
	 * @return List of account numbers parsed from file
	 * @throws IOException
	 */
	public static List<AccountNumber> getValidAccounts(final String filePath) throws IOException {
		List<AccountNumber> accounts = new ArrayList<AccountNumber>();
		BufferedReader br = openFile(filePath);
		String line;
		int counter = 0;
		String[] lines = new String[LINES_PER_ACCOUNT];
		try {
			while ((line = br.readLine()) != null) {
				if (counter < LINES_PER_ACCOUNT - 1) {
					lines[counter] = line;
				} else {
					lines[counter] = line;
					accounts.add(new AccountNumber(lines));
					counter = -1;
				}
				counter++;
			}
		} finally {
			br.close();
		}
		return accounts;
	}

	private static BufferedReader openFile(final String filePath) throws IOException {
		URL url = AccountReader.class.getClass().getResource(filePath);
		if (url == null) {
			throw new IOException("Problem constructing URL with file path = " + filePath);
		}
		File testFile = new File(url.getFile());
		BufferedReader br = new BufferedReader(new FileReader(testFile));
		return br;
	}
}
