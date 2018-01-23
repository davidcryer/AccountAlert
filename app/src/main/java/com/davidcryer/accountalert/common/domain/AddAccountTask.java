package com.davidcryer.accountalert.common.domain;

class AddAccountTask {
    private final AccountStore accountStore;

    AddAccountTask(AccountStore accountStore) {
        this.accountStore = accountStore;
    }

    Account addAccount(final AccountSubmission submission) throws BadAccountInitialisationException {
        return accountStore.add(submission);
    }
}
