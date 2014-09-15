package com.user.calendar;

import java.util.HashMap;
import java.util.Map;

public class HolidayCalendar {
	private final Map<Holidays, String> dates = new HashMap<Holidays, String>();

	public enum Holidays {
		NEW_YEARS, CHRISTMAS;
	}

	public HolidayCalendar(final String year) {
		dates.put(Holidays.CHRISTMAS, String.format("12/25/%s", year));
		dates.put(Holidays.NEW_YEARS, String.format("01/01/%s", year));
	}

	public HashMap<Holidays, String> getDates() {
		return new HashMap<Holidays, String>(dates);
	}

	public String getHoliday(final Holidays christmas) {
		return dates.get(christmas);
	}

}
