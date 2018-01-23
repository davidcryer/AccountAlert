package com.davidcryer.accountalert.common.domain;

import java.util.Date;

public class AccountSubmission {
    final String title;
    final String description;
    final Date nextNotification;
    final RepeatType repeatType;

    public AccountSubmission(String title, String description, Date nextNotification, RepeatType repeatType) {
        this.title = title;
        this.description = description;
        this.nextNotification = nextNotification;
        this.repeatType = repeatType;
    }
}
