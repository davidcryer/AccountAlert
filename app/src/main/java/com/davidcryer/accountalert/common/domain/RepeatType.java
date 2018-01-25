package com.davidcryer.accountalert.common.domain;

public enum RepeatType {
    NEVER, DAILY, WEEKLY, FORTNIGHTLY, MONTHLY, QUARTERLY, BI_ANNUALLY, ANNUALLY, SEMI_ANNUALLY;

    public static RepeatType from(String type) {
        switch (type) {
            case "Never": {
                return NEVER;
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
