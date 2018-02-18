package com.davidcryer.accountalert.common.domain;

import java.util.Date;

public class AccountSubmission {
    final String title;
    final String description;
    final Date expiry;
    final RepeatType repeatType;

    public AccountSubmission(String title, String description, Date expiry, RepeatType repeatType) {
        this.title = title;
        this.description = description;
        this.expiry = expiry;
        this.repeatType = repeatType;
    }
}
