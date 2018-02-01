package com.davidcryer.accountalert.common.domain;

import android.support.annotation.Nullable;

public enum RepeatType {
    DAILY, WEEKLY, FORTNIGHTLY, MONTHLY, QUARTERLY, BI_ANNUALLY, ANNUALLY, SEMI_ANNUALLY;

    public static @Nullable RepeatType from(String type) {
        switch (type) {
            case "Never": {
                return null;
            }
            case "Daily": {
                return DAILY;
            }
            case "Weekly": {
                return WEEKLY;
            }
            case "Fortnightly": {
                return FORTNIGHTLY;
            }
            case "Monthly": {
                return MONTHLY;
            }
            case "Quarterly": {
                return QUARTERLY;
            }
            case "Bi-annually": {
                return BI_ANNUALLY;
            }
            case "Annually": {
                return ANNUALLY;
            }
            case "Semi-annually": {
                return SEMI_ANNUALLY;
            }
        }
        return null;
    }
}
