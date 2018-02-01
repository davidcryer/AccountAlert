package com.davidcryer.accountalert.common;

public class Millis {
    private final static long SECOND = 1000;
    private final static long MINUTE = SECOND * 60;
    private final static long HOUR = MINUTE * 60;

    public static long inHour(final int hour) {
        return hour * HOUR;
    }
}
