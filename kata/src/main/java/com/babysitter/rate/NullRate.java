package com.babysitter.rate;

public class NullRate implements Rate {

	public int getValue() {
		throw new IllegalArgumentException();
	}

}
