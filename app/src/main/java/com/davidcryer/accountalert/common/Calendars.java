package com.davidcryer.accountalert.common;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Calendars {

    private Calendars() {}

    public static Calendar from(final Date date) {
        final Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        return calendar;
    }

    public static Calendar previousMidnight(final Calendar calendar) {
        return new GregorianCalendar(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
    }

    public static Calendar nextMidnight(final Calendar calendar) {
        final Calendar result = previousMidnight(calendar);
        result.add(Calendar.DAY_OF_MONTH, 1);
        return result;
    }
}
