package com.davidcryer.accountalert.common.domain;

import com.davidcryer.accountalert.common.domain.argchecking.BadAccountInitialisationException;

public class AddAccountTask {
    private final AccountStore accountStore;

    public AddAccountTask(AccountStore accountStore) {
        this.accountStore = accountStore;
    }

    Account addAccount(final AccountSubmission submission) throws BadAccountInitialisationException {
        return accountStore.add(submission);
    }
}
