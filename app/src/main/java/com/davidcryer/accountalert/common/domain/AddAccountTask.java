package com.davidcryer.accountalert.common.domain;

import com.davidcryer.accountalert.common.domain.argchecking.BadAccountInitialisationException;
import com.davidcryer.accountalert.common.domain.reminder.AlarmService;

public class AddAccountTask {
    private final AlarmService alarmService;
    private final AccountStore accountStore;

    public AddAccountTask(AlarmService alarmService, AccountStore accountStore) {
        this.alarmService = alarmService;
        this.accountStore = accountStore;
    }

    Account addAccount(final AccountSubmission submission) throws BadAccountInitialisationException {
        final Account account = accountStore.add(submission);
        alarmService.register(account);
        return account;
    }
}
