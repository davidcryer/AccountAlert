package com.davidcryer.accountalert.common.domain;

import java.util.Date;

public class AccountJson {
    private final String title;
    private final String description;
    private final Date expiry;
    private final RepeatType repeatType;

    public AccountJson(String title, String description, Date expiry, RepeatType repeatType) {
        this.title = title;
        this.description = description;
        this.expiry = expiry;
        this.repeatType = repeatType;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getExpiry() {
        return expiry;
    }

    public RepeatType getRepeatType() {
        return repeatType;
    }
}
