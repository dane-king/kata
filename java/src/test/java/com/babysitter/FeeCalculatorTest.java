package com.babysitter;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class FeeCalculatorTest {
	static final int STARTTIME = 17;
	static final int MIDNIGHT = 24;
	static final int BEDTIME = 21;
	static final int ENDTIME = 4;

	private FeeCalculator underTest;

	@Test
	public void chargeFromStartToBedTimeShouldBe48() {
		underTest = new FeeCalculator(STARTTIME, BEDTIME);
		assertThat(underTest.calculateFee(), equalTo(new Dollars(48)));
	}

	@Test
	public void chargeFromMidnightToEndShouldBe56() {
		underTest = new FeeCalculator(MIDNIGHT, ENDTIME);
		assertThat(underTest.calculateFee(), equalTo(new Dollars(56)));

	}

	@Test
	public void chargeFromBedTimeToMidnightShouldBe24() {
		underTest = new FeeCalculator(BEDTIME, MIDNIGHT);
		assertThat(underTest.calculateFee(), equalTo(new Dollars(24)));
	}

	@Test
	public void chargeFromStartToMidnight() {
		underTest = new FeeCalculator(STARTTIME, MIDNIGHT);
		assertThat(underTest.calculateFee(), equalTo(new Dollars(72)));
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowErrorWhenStartTooEarly() {
		underTest = new FeeCalculator(16, MIDNIGHT);
		underTest.calculateFee();
	}
}
