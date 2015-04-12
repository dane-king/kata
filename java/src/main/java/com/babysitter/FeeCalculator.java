package com.babysitter;

import com.babysitter.rate.Rate;
import com.babysitter.rate.RateMap;

public class FeeCalculator {

	final Time endtime;
	final Time starttime;
	final RateMap factory;

	public FeeCalculator(final int starttime, final int endtime) {
		this.endtime = new Time(endtime);
		this.starttime = new Time(starttime);
		factory = new RateMap();
	}

	public Dollars calculateFee() {
		Time start = starttime;
		int rate = 0;
		while (!start.equals(endtime)) {
			rate += getHourlyRate(start).getValue();
			start = start.plus(endtime.oneHour());
		}

		return new Dollars(rate);

	}

	private Rate getHourlyRate(final Time tempTime) {
		return factory.lookupRate(tempTime);
	}

}
