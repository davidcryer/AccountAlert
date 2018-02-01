package com.davidcryer.accountalert.common.domain;

import com.davidcryer.accountalert.common.domain.argchecking.AccountInitialisationChecker;
import com.davidcryer.accountalert.common.domain.argchecking.BadAccountInitialisationException;

import java.util.Date;
import java.util.UUID;

public class Account {
    private final UUID id;
    private final String title;
    private final String description;
    private final Date reminder;
    private final RepeatType repeatType;

    Account(String title, String description, Date reminder, RepeatType repeatType) throws BadAccountInitialisationException {
        this(UUID.randomUUID(), title, description, reminder, repeatType);
    }

    Account(UUID id, String title, String description, Date reminder, RepeatType repeatType) throws BadAccountInitialisationException {
        AccountInitialisationChecker.check(id, title, reminder);
        this.id = id;
        this.title = title;
        this.description = description;
        this.reminder = reminder;
        this.repeatType = repeatType;
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

    public Date reminder() {
        return reminder;
    }

    public RepeatType repeatType() {
        return repeatType;
    }
}
