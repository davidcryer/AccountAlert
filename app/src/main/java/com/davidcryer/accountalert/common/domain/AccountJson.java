package com.davidcryer.accountalert.common.domain;

import java.util.Date;

public class AccountJson {
    private final String title;
    private final String description;
    private final Date nextNotification;
    private final RepeatType repeatType;

    public AccountJson(String title, String description, Date nextNotification, RepeatType repeatType) {
        this.title = title;
        this.description = description;
        this.nextNotification = nextNotification;
        this.repeatType = repeatType;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getNextNotification() {
        return nextNotification;
    }

    public RepeatType getRepeatType() {
        return repeatType;
    }
}
