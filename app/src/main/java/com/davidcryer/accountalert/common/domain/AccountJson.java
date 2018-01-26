package com.davidcryer.accountalert.common.domain;

import java.util.Date;

public class AccountJson {
    private final String title;
    private final String description;
    private final Date reminder;
    private final RepeatType repeatType;

    public AccountJson(String title, String description, Date reminder, RepeatType repeatType) {
        this.title = title;
        this.description = description;
        this.reminder = reminder;
        this.repeatType = repeatType;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getReminder() {
        return reminder;
    }

    public RepeatType getRepeatType() {
        return repeatType;
    }
}
