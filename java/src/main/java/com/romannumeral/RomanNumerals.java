package com.romannumeral;

public enum RomanNumerals {
	I('I') {
		@Override
		public int numericalValue() {
			return 1;
		}
	},
	V('V') {
		@Override
		public int numericalValue() {
			return 5;
		}
	},
	X('X') {
		@Override
		public int numericalValue() {
			return 10;
		}
	};
	private final char value;

	private RomanNumerals(final char value) {
		this.value = value;
	}

	public char getValue() {
		return value;
	}

	public abstract int numericalValue();
};
