package com.babysitter.rate;

import java.util.HashMap;
import java.util.Map;

import com.babysitter.Time;

public class RateMap {
	static final int STARTTIME = 17;
	static final int MIDNIGHT = 24;
	static final int BEDTIME = 21;
	static final int ENDTIME = 4;

	Map<Time, Rate> rateMap;

	public RateMap() {
		initializeRateMap();
	}

	void initializeRateMap() {
		rateMap = new HashMap<Time, Rate>();
		for (int i = 1; i < 25; i++) {
			Time hour = new Time(i);
			determineRate(hour);

		}
	}

	private void determineRate(final Time hour) {
		if (isFirstTier(hour)) {
			rateMap.put(hour, new TierOneRate());
			return;
		}
		if (isSecondTier(hour)) {
			rateMap.put(hour, new TierTwoRate());
			return;
		}
		if (isThirdTier(hour)) {
			rateMap.put(hour, new TierThreeRate());
			return;
		}
		rateMap.put(hour, new NullRate());
	}

	public Rate lookupRate(final Time time) {
		return rateMap.get(time);
	}

	private boolean isFirstTier(final Time time) {
		return time.getTime() >= STARTTIME && time.getTime() < BEDTIME;
	}

	private boolean isSecondTier(final Time time) {
		return time.getTime() >= BEDTIME && time.getTime() <= MIDNIGHT;
	}

	private boolean isThirdTier(final Time time) {
		return time.getTime() > 0 && time.getTime() <= ENDTIME;
	}

}
