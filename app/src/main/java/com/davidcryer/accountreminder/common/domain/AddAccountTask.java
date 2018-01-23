package com.davidcryer.accountreminder.common.domain;

class AddAccountTask {
    private final AccountStore accountStore;

    AddAccountTask(AccountStore accountStore) {
        this.accountStore = accountStore;
    }

    Account addAccount(final AccountSubmission submission) throws BadAccountInitialisationException {
        final Account account = new Account(submission.title, submission.description, submission.nextNotification, submission.repeatType);
        accountStore.add(account);
        return account;
    }
}
