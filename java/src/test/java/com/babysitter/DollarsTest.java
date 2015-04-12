package com.babysitter;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

public class DollarsTest {
	private Dollars underTest;

	@Before
	public void setup() {
		underTest = new Dollars(25);
	}

	@Test
	public void shouldBeEqual() {
		assertThat(underTest, equalTo(new Dollars(25)));
	}

	@Test
	public void shouldNotBeEqual() {
		assertThat(underTest, not(equalTo(new Dollars(30))));
	}

	@Test
	public void shouldNotBeEqualForDifferentObjects() {
		assertFalse(underTest.equals(Integer.valueOf(25)));
	}

	@Test
	public void hashCodeShouldBeAmount() {
		assertThat(underTest.hashCode(), equalTo(25));
	}
}
