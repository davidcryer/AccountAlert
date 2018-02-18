package com.davidcryer.accountalert.common.domain;

import android.support.annotation.Nullable;

public enum RepeatType {
    DAILY, WEEKLY, FORTNIGHTLY, MONTHLY, QUARTERLY, BI_ANNUALLY, ANNUALLY, SEMI_ANNUALLY;

    public final static String NEVER_STR = "Never";
    public final static String DAILY_STR = "Daily";
    public final static String WEEKLY_STR = "Weekly";
    public final static String FORTNIGHTLY_STR = "Fortnightly";
    public final static String MONTHLY_STR = "Monthly";
    public final static String QUARTERLY_STR = "Quarterly";
    public final static String BI_ANNUALLY_STR = "Bi-annually";
    public final static String ANNUALLY_STR = "Annually";
    public final static String SEMI_ANNUALLY_STR = "Semi-annually";

    public static @Nullable RepeatType from(String type) {
        switch (type) {
            case NEVER_STR: {
                return null;
            }
            case DAILY_STR: {
                return DAILY;
            }
            case WEEKLY_STR: {
                return WEEKLY;
            }
            case FORTNIGHTLY_STR: {
                return FORTNIGHTLY;
            }
            case MONTHLY_STR: {
                return MONTHLY;
            }
            case QUARTERLY_STR: {
                return QUARTERLY;
            }
            case BI_ANNUALLY_STR: {
                return BI_ANNUALLY;
            }
            case ANNUALLY_STR: {
                return ANNUALLY;
            }
            case SEMI_ANNUALLY_STR: {
                return SEMI_ANNUALLY;
            }
        }
        return null;
    }
}
