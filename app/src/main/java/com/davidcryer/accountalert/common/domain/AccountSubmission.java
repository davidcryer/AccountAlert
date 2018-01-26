package com.davidcryer.accountalert.common.domain;

import java.util.Date;

public class AccountSubmission {
    final String title;
    final String description;
    final Date reminder;
    final RepeatType repeatType;

    public AccountSubmission(String title, String description, Date reminder, RepeatType repeatType) {
        this.title = title;
        this.description = description;
        this.reminder = reminder;
        this.repeatType = repeatType;
    }
}
