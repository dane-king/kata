package com.videostore;

public class Customer {
	public Customer(final String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	private final String name;
}