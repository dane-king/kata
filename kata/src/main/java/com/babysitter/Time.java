package com.babysitter;

public class Time {

	private final int time;

	public Time(final int time) {
		this.time = time;
	}

	public Time plus(final Time time) {
		int newTime = this.time + time.getTime();
		if (newTime > 24) {
			newTime -= 24;
		}
		return new Time(newTime);
	}

	@Override
	public int hashCode() {
		return time;
	}

	@Override
	public boolean equals(final Object obj) {
		return obj instanceof Time && time == ((Time) obj).time;
	}

	public int getTime() {
		return time;
	}

	public Time oneHour() {
		return new Time(1);
	}

}
