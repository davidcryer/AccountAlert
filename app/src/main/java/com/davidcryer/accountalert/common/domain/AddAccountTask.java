package com.davidcryer.accountalert.common.domain;

public class AddAccountTask {
    private final AccountStore accountStore;

    public AddAccountTask(AccountStore accountStore) {
        this.accountStore = accountStore;
    }

    Account addAccount(final AccountSubmission submission) throws BadAccountInitialisationException {
        return accountStore.add(submission);
    }
}
