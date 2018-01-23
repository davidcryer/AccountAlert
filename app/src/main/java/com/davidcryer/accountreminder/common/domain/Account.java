package com.davidcryer.accountreminder.common.domain;

import java.util.Date;
import java.util.UUID;

public class Account {
    private final UUID id;
    private final String title;
    private final String description;
    private final Date nextNotification;
    private final RepeatType repeatType;

    Account(String title, String description, Date nextNotification, RepeatType repeatType) {
        this(UUID.randomUUID(), title, description, nextNotification, repeatType);
    }

    Account(UUID id, String title, String description, Date nextNotification, RepeatType repeatType) {//TODO validate
        this.id = id;
        this.title = title;
        this.description = description;
        this.nextNotification = nextNotification;
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

    public Date nextNotification() {
        return nextNotification;
    }

    public RepeatType repeatType() {
        return repeatType;
    }
}
