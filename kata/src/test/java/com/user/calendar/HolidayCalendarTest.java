package com.user.calendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Calendar;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.user.calendar.HolidayCalendar.Holidays;

public class HolidayCalendarTest {
	private HolidayCalendar calendar;
	private Calendar now;

	@Before
	public void setUp() {
		now = Calendar.getInstance();
		String currentYear = String.valueOf(now.get(Calendar.YEAR));
		calendar = new HolidayCalendar(currentYear);

	}

	@Test
	public void calendar_instance_should_be_created() {
		assertNotNull(calendar);
	}

	@Test
	public void calendar_should_have_a_list_of_dates() {
		Map<Holidays, String> dates = calendar.getDates();
		assertNotNull(dates);
	}

	@Test
	public void christmas_should_be_a_holiday() {
		String expectedDate = String.format("12/25/%s", now.get(Calendar.YEAR));
		assertEquals(expectedDate, calendar.getHoliday(Holidays.CHRISTMAS));
	}

	@Test
	public void new_years_should_be_a_holiday() {
		String expectedDate = String.format("01/01/%s", now.get(Calendar.YEAR));

		assertEquals(expectedDate, calendar.getHoliday(Holidays.NEW_YEARS));
	}

	@Test
	public void new_years_in_past_should_be_a_holiday() {
		now.add(Calendar.YEAR, -1);
		String previousYear = String.valueOf(now.get(Calendar.YEAR));
		HolidayCalendar previousYearCalendar = new HolidayCalendar(previousYear);
		String expectedDate = String.format("01/01/%s", now.get(Calendar.YEAR));
		assertEquals(expectedDate, previousYearCalendar.getHoliday(Holidays.NEW_YEARS));
	}
}
