package com.davidcryer.accountalert.common.domain;

import com.davidcryer.accountalert.common.domain.argchecking.AccountInitialisationChecker;
import com.davidcryer.accountalert.common.domain.argchecking.BadAccountInitialisationException;

import java.util.Date;
import java.util.UUID;

public class Account {
    private final UUID id;
    private final String title;
    private final String description;
    private final Date expiry;
    private final RepeatType repeatType;

    private Account(UUID id, String title, String description, Date expiry, RepeatType repeatType) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.expiry = expiry;
        this.repeatType = repeatType;
    }

    static Account create(String title, String description, Date expiry, RepeatType repeatType) throws BadAccountInitialisationException {
        AccountInitialisationChecker.check(title, expiry);
        return new Account(UUID.randomUUID(), title, description, expiry, repeatType);
    }

    static Account inflate(UUID id, String title, String description, Date expiry, RepeatType repeatType) {
        return new Account(id, title, description, expiry, repeatType);
    }

    public UUID id() {
        return id;
    }

    public String title() {
        return title;
    }

    public String description() {
        return description;
    }

    public Date expiry() {
        return expiry;
    }

    public RepeatType repeatType() {
        return repeatType;
    }
}
