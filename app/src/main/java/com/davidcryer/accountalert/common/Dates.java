package com.davidcryer.accountalert.common;

import java.util.Date;

public class Dates {

    private Dates() {}

    public static Date midnightToday() {
        return previousMidnight(new Date());
    }

    public static Date previousMidnight(final Date date) {
        return Calendars.previousMidnight(Calendars.from(date)).getTime();
    }

    public static Date midnightTomorrow() {
        return nextMidnight(new Date());
    }

    public static Date nextMidnight(final Date date) {
        return Calendars.nextMidnight(Calendars.from(date)).getTime();
    }
}
