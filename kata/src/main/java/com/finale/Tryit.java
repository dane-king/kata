package com.finale;

import java.io.IOException;

public class Tryit {
	public void thowit() {
		throw new IllegalArgumentException("method throws error");
	}

	@SuppressWarnings("finally")
	public static void main(final String[] args) throws IllegalAccessException {
		Tryit t = new Tryit();
		try {
			t.thowit();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			throw new IOException();
		} finally {
			throw new IllegalAccessException();
		}

	}
}
