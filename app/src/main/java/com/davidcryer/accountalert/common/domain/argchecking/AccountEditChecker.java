package com.davidcryer.accountalert.common.domain.argchecking;

import java.util.Date;

public class AccountEditChecker extends AccountArgChecker<AccountEditResults, BadAccountEditException> {
    private final AccountEditResults.Builder resultsBuilder = new AccountEditResults.Builder();

    public AccountEditChecker title(final String title) {
        resultsBuilder.title(titleResult(title));
        return this;
    }

    AccountEditChecker reminder(final Date reminder) {
        resultsBuilder.reminder(reminderResult(reminder));
        return this;
    }

    @Override
    protected AccountEditResults results() {
        return resultsBuilder.results();
    }

    @Override
    protected BadAccountEditException exception(AccountEditResults results) {
        return new BadAccountEditException(results);
    }
}
